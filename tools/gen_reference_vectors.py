"""Generate Technocore interop fixtures from the SERVER'S OWN CODE.

Run against a checkout of flop-labs/technocore-chat so the expected values come from the
implementation that will actually judge our signatures, not from prose in a doc.

    python tools/gen_reference_vectors.py <path-to-technocore-chat> tests/reference-vectors.json
"""
from __future__ import annotations

import base64
import hashlib
import json
import sys
import unicodedata
from pathlib import Path

sys.path.insert(0, str(Path(sys.argv[1]) / "src"))
import didkey  # noqa: E402  (server's own did:key implementation)

from cryptography.hazmat.primitives.asymmetric.ed25519 import Ed25519PrivateKey  # noqa: E402

INVISIBLE = ("Cc", "Cf", "Cs", "Co", "Zl", "Zp")


def clean_text(text: str) -> str:
    """Copied verbatim from the server's store.clean_text sweep."""
    return "".join(" " if unicodedata.category(c) in INVISIBLE else c for c in text).strip()


def b58(raw: bytes) -> str:
    alphabet = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
    n = int.from_bytes(raw, "big")
    out = ""
    while n:
        n, rem = divmod(n, 58)
        out = alphabet[rem] + out
    return out


# Fixed, non-secret test seeds. These are FIXTURES, never a real identity.
SEEDS = [
    bytes(range(32)),
    bytes.fromhex("00" * 32),
    bytes.fromhex("ff" * 32),
    hashlib.sha256(b"floop-passport-test-vector-3").digest(),
]

NBSP = chr(0x00A0)
ZWSP = chr(0x200B)
ZWJ = chr(0x200D)
BIDI = chr(0x202E)
LSEP = chr(0x2028)
TAB = chr(0x09)
LF = chr(0x0A)
RABBIT = chr(0x1F430)
ROBOT = chr(0x1F916)
MAN, WOMAN, GIRL = chr(0x1F468), chr(0x1F469), chr(0x1F467)

TEXTS = [
    "FLOOP Passport for Seeker. First signed check-in.",
    "  leading and trailing spaces  ",
    "line" + LF + "break" + TAB + "and" + TAB + "tabs",
    "zero" + ZWSP + "width and " + BIDI + "bidi override",
    "emoji survive: " + RABBIT + " " + ROBOT,
    "family flattens: " + MAN + ZWJ + WOMAN + ZWJ + GIRL,
    "nbsp" + NBSP + "edges and" + LSEP + "line sep",
    NBSP + " leading nbsp stripped by python " + NBSP,
]


vectors = {"identities": [], "sweep": [], "messages": [], "notes": []}

for seed in SEEDS:
    key = Ed25519PrivateKey.from_private_bytes(seed)
    pub = key.public_key().public_bytes_raw()
    did = "did:key:z" + b58(b"\xed\x01" + pub)
    assert didkey.public_key(did) == pub, "server rejects our own DID rendering"
    fp = hashlib.sha256(did.encode()).hexdigest()[:16]
    vectors["identities"].append(
        {
            "seed_hex": seed.hex(),
            "public_key_hex": pub.hex(),
            "did": did,
            "fingerprint": fp,
            "note_path": f"/kv/did-{fp[:2]}/{fp[2:]}",
            "abbreviated": didkey.abbreviate(did),
        }
    )

for text in TEXTS:
    vectors["sweep"].append({"input": text, "swept": clean_text(text)})

seed = SEEDS[0]
key = Ed25519PrivateKey.from_private_bytes(seed)
did = vectors["identities"][0]["did"]
for room, nonce, text in [
    ("lobby", "1", "FLOOP Passport for Seeker. First signed check-in."),
    ("lobby", "1756500000000", "  swept  text  with\ttabs  "),
    ("floop", "42", "emoji \U0001F430 survive the sweep"),
]:
    payload = f"{room}|{nonce}|{clean_text(text)}"
    sig = base64.urlsafe_b64encode(key.sign(payload.encode())).decode().rstrip("=")
    didkey.verify(did, sig, payload)  # server verifies its own fixture
    vectors["messages"].append(
        {
            "did": did,
            "room": room,
            "nonce": nonce,
            "raw_text": text,
            "canonical_payload": payload,
            "signature": sig,
        }
    )

fp = vectors["identities"][0]["fingerprint"]
for ns, k, nonce, value in [(f"did-{fp[:2]}", fp[2:], "1", "FLOOP Passport for Seeker")]:
    payload = f"{ns}|{k}|{nonce}|{clean_text(value)}"
    sig = base64.urlsafe_b64encode(key.sign(payload.encode())).decode().rstrip("=")
    didkey.verify(did, sig, payload)
    vectors["notes"].append(
        {
            "did": did,
            "ns": ns,
            "key": k,
            "nonce": nonce,
            "raw_value": value,
            "canonical_payload": payload,
            "signature": sig,
        }
    )


out = Path(sys.argv[2])
out.write_text(json.dumps(vectors, indent=2, ensure_ascii=False) + chr(10), encoding="utf-8")
print("wrote", out, "-",
      len(vectors["identities"]), "identities,",
      len(vectors["sweep"]), "sweep cases,",
      len(vectors["messages"]), "messages,",
      len(vectors["notes"]), "notes;",
      "all verified by the server's own didkey.verify")
