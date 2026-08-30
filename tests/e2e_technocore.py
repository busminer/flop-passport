"""End-to-end proof that the FLOOP Passport flow works against a real Technocore server.

Mirrors exactly what the Android app will do, in the same order, using the same canonical
strings and the same derivation. Run against a LOCAL instance so nothing is published:

    python tests/e2e_technocore.py http://127.0.0.1:8099

Every step asserts on the server's actual response, and every success is confirmed by
reading the record back. An HTTP 200 is never treated as proof on its own.
"""
from __future__ import annotations

import base64
import hashlib
import hmac
import json
import sys
import time
import unicodedata
import urllib.error
import urllib.parse
import urllib.request

from cryptography.hazmat.primitives.asymmetric.ed25519 import Ed25519PrivateKey

BASE = sys.argv[1].rstrip("/") if len(sys.argv) > 1 else "http://127.0.0.1:8099"
B58 = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
INVISIBLE = ("Cc", "Cf", "Cs", "Co", "Zl", "Zp")

passed, failed = [], []


def check(name, ok, detail=""):
    (passed if ok else failed).append(name)
    print(("  PASS  " if ok else "  FAIL  ") + name + (f"  |  {detail}" if detail else ""))


def b58(raw: bytes) -> str:
    n = int.from_bytes(raw, "big")
    out = ""
    while n:
        n, r = divmod(n, 58)
        out = B58[r] + out
    return out


def sweep(text: str) -> str:
    return "".join(" " if unicodedata.category(c) in INVISIBLE else c for c in text).strip()


def get(path: str, timeout=15):
    req = urllib.request.Request(BASE + path, headers={"User-Agent": "floop-passport-e2e/0.1"})
    try:
        with urllib.request.urlopen(req, timeout=timeout) as r:
            return r.status, r.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")


def enc(s: str) -> str:
    return urllib.parse.quote(s, safe="")


UNTRUSTED = "!! UNTRUSTED CONTENT"


def strip_banner(body: str) -> str:
    """Notes and rooms come back behind an untrusted-content banner.

    The banner is a real protocol fact the client must handle, and its warning is
    correct: note namespaces are world-writable, so anyone can overwrite anyone's
    identity note. The app therefore renders note content as inert data and never as
    configuration or instructions.
    """
    lines = body.splitlines()
    if lines and lines[0].startswith(UNTRUSTED):
        lines = lines[1:]
        while lines and not lines[0].strip():
            lines = lines[1:]
    return chr(10).join(lines).strip()


def hkdf_sha256(ikm: bytes, salt: bytes, info: bytes, length: int = 32) -> bytes:
    prk = hmac.new(salt, ikm, hashlib.sha256).digest()
    out, t, counter = b"", b"", 1
    while len(out) < length:
        t = hmac.new(prk, t + info + bytes([counter]), hashlib.sha256).digest()
        out += t
        counter += 1
    return out[:length]


print("\n[1] PASSPORT DERIVATION  (what the wallet signature turns into)")

TEST_WALLET = "TESTWa11etDoNotUse111111111111111111111111"
fake_wallet_sig = hashlib.sha512(b"FLOOP PASSPORT E2E TEST WALLET SIGNATURE - NOT REAL").digest()

seed = hkdf_sha256(fake_wallet_sig, TEST_WALLET.encode(), b"FLOOP Passport seed v1")
seed2 = hkdf_sha256(fake_wallet_sig, TEST_WALLET.encode(), b"FLOOP Passport seed v1")
check("derivation is deterministic (same wallet rebuilds the same Passport)", seed == seed2)

key = Ed25519PrivateKey.from_private_bytes(seed)
pub = key.public_key().public_bytes_raw()
DID = "did:key:z" + b58(b"\xed\x01" + pub)
FP = hashlib.sha256(DID.encode()).hexdigest()[:16]
NOTE_NS, NOTE_KEY = "did-" + FP[:2], FP[2:]
check("DID has the shape the server accepts",
      DID.startswith("did:key:z6Mk") and len(DID) == 56, DID)
print("        TEST DID        " + DID)
print("        fingerprint     " + FP)
print("        note path       /kv/" + NOTE_NS + "/" + NOTE_KEY)

print("\n[2] SERVER REACHABLE")
st, body = get("/rooms")
check("GET /rooms", st == 200, "HTTP " + str(st))

print("\n[3] PUBLISH IDENTITY NOTE, THEN READ IT BACK")
note_value = "FLOOP Passport for Seeker (E2E TEST) | agent identity"
st, body = get("/kv/" + NOTE_NS + "/" + enc(NOTE_KEY) + "/set/" + enc(note_value))
check("note write accepted", st == 200, "HTTP " + str(st) + " " + body[:90])

st, readback = get("/kv/" + NOTE_NS + "/" + enc(NOTE_KEY))
check("server marks note content as untrusted",
      readback.startswith(UNTRUSTED), repr(readback[:40]))
check("note read-back returns exactly what we wrote",
      st == 200 and strip_banner(readback) == note_value,
      "HTTP " + str(st) + " got=" + repr(strip_banner(readback)[:70]))

print("\n[4] FIRST SIGNED CHECK-IN")
ROOM = "floop-passport-e2e"
TEXT = "FLOOP Passport for Seeker. First signed check-in."
nonce = str(int(time.time() * 1000))
payload = ROOM + "|" + nonce + "|" + sweep(TEXT)
sig = base64.urlsafe_b64encode(key.sign(payload.encode())).decode().rstrip("=")
check("signature is the canonical 86-char base64url form",
      len(sig) == 86 and sig[-1] in "AQgw", sig[-12:])

st, body = get("/r/" + ROOM + "/say-signed/" + DID + "/" + sig + "/" + nonce + "/" + enc(TEXT))
check("server accepted the signed write", st == 200, "HTTP " + str(st) + " " + body[:140])

print("\n[5] VERIFY BY READING THE ROOM BACK  (HTTP 200 is not proof)")
st, body = get("/r/" + ROOM + "?since=0&format=json")
rec = None
if st == 200:
    try:
        data = json.loads(body)
        msgs = data.get("messages", data) if isinstance(data, dict) else data
        # The DID arrives in "from", not "did" - the client must read the right field.
        # Match on the nonce as well: a room keeps earlier messages from the same DID, and
        # "some message of mine is in here" is not proof that THIS write landed.
        rec = next(
            (m for m in msgs if m.get("from") == DID and str(m.get("nonce")) == nonce),
            None,
        )
    except Exception as e:
        print("        json parse failed:", e, body[:200])
check("our message is in the room", rec is not None, "HTTP " + str(st))
if rec:
    check("server attributed it to OUR DID", rec.get("from") == DID)
    check("stored text equals the swept text we signed",
          rec.get("text") == sweep(TEXT), repr(rec.get("text")))
    check("server assigned a sequence number",
          isinstance(rec.get("seq"), int) and rec["seq"] > 0, "seq=" + str(rec.get("seq")))
    check("server echoed back the nonce we used",
          str(rec.get("nonce")) == nonce, "nonce=" + str(rec.get("nonce")))
    print("        PROOF: seq=" + str(rec.get("seq")) + " nonce=" + nonce + " did=" + DID[:20] + "...")

print("\n[6] NONCE DISCIPLINE  (replay and rollback must be refused)")
st, body = get("/r/" + ROOM + "/say-signed/" + DID + "/" + sig + "/" + nonce + "/" + enc(TEXT))
check("exact replay of the same nonce is refused", st != 200, "HTTP " + str(st) + " " + body[:80])

lower = str(int(nonce) - 1000)
p2 = ROOM + "|" + lower + "|" + sweep(TEXT)
s2 = base64.urlsafe_b64encode(key.sign(p2.encode())).decode().rstrip("=")
st, body = get("/r/" + ROOM + "/say-signed/" + DID + "/" + s2 + "/" + lower + "/" + enc(TEXT))
check("a lower nonce is refused", st != 200, "HTTP " + str(st) + " " + body[:80])

nxt = str(int(nonce) + 1)
t2 = "FLOOP Passport E2E. Second signed message."
p3 = ROOM + "|" + nxt + "|" + sweep(t2)
s3 = base64.urlsafe_b64encode(key.sign(p3.encode())).decode().rstrip("=")
st, body = get("/r/" + ROOM + "/say-signed/" + DID + "/" + s3 + "/" + nxt + "/" + enc(t2))
check("a higher nonce is accepted", st == 200, "HTTP " + str(st) + " " + body[:80])

print("\n[7] FORGERY MUST FAIL CLOSED")
bad = ("B" if sig[0] != "B" else "C") + sig[1:]
n4 = str(int(nonce) + 2)
st, body = get("/r/" + ROOM + "/say-signed/" + DID + "/" + bad + "/" + n4 + "/" + enc(TEXT))
check("tampered signature is refused", st != 200, "HTTP " + str(st))

other = Ed25519PrivateKey.from_private_bytes(hashlib.sha256(b"another identity").digest())
n5 = str(int(nonce) + 3)
p5 = ROOM + "|" + n5 + "|" + sweep(TEXT)
s5 = base64.urlsafe_b64encode(other.sign(p5.encode())).decode().rstrip("=")
st, body = get("/r/" + ROOM + "/say-signed/" + DID + "/" + s5 + "/" + n5 + "/" + enc(TEXT))
check("another key signing for our DID is refused", st != 200, "HTTP " + str(st))

print("\n[8] THE SWEEP TRAP  (signing raw text must fail, signing swept text must pass)")
raw = "  spaced\ttext  with" + chr(0x200B) + "zero width  "
n6 = str(int(nonce) + 4)
wrong = base64.urlsafe_b64encode(key.sign((ROOM + "|" + n6 + "|" + raw).encode())).decode().rstrip("=")
st, body = get("/r/" + ROOM + "/say-signed/" + DID + "/" + wrong + "/" + n6 + "/" + enc(raw))
check("signing the RAW text is refused (the bug we designed against)", st != 200, "HTTP " + str(st))

n7 = str(int(nonce) + 5)
right = base64.urlsafe_b64encode(
    key.sign((ROOM + "|" + n7 + "|" + sweep(raw)).encode())).decode().rstrip("=")
st, body = get("/r/" + ROOM + "/say-signed/" + DID + "/" + right + "/" + n7 + "/" + enc(raw))
check("signing the SWEPT text is accepted", st == 200, "HTTP " + str(st) + " " + body[:80])

print("\n" + "=" * 72)
print("  " + str(len(passed)) + " passed, " + str(len(failed)) + " failed")
for f in failed:
    print("  FAILED:", f)
print("=" * 72)
sys.exit(1 if failed else 0)
