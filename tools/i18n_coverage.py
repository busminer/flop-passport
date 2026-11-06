"""Find every sentence a person could meet in English on a translated phone.

    python tools/i18n_coverage.py

The app translates at the moment of drawing: `t(english)` looks the sentence up and returns
it unchanged when there is no entry. That is the right failure - a missing translation shows
English rather than an identifier - but it is a silent one, and silence is the problem. A
screen that is nine tenths Chinese with one English paragraph in the middle of it reads as a
broken app, and nobody reports it, they just stop.

So this walks the source the way the app does and lists what has no entry.

Two kinds of string reach `t()`. Some are written at the point of drawing, `t("Create")`.
Most are written in the ViewModel as plain English - a step's summary, what to do about a
failure - carried into the screen and translated there. Both are the same thing to a reader,
so both are collected: every literal in the UI and ViewModel layers that looks like a
sentence a person would read.

The filtering is deliberately loose in the direction of noise. A false positive costs a
glance; a false negative is a paragraph of English on somebody's screen.
"""
from __future__ import annotations

import re
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
SRC = ROOT / "app/src/main/java/dev/alexkosa/floppassport"
I18N = SRC / "i18n"

# Where user-facing sentences are written.
# `proof` is left out on purpose: the post goes out in English because that is the language
# this audience reads, and the voices and examples in PostComposer are that post.
# Sentences reach the screen from four more folders: a biometric refusal, a wallet error,
# a vault message, and every "detail" line the network layer produces. They were invisible
# to this tool, so they were English in all ten languages and nobody could tell.
LOOKED_AT = ["ui", "notify", "util", "technocore", "wallet", "vault", "flop"]

STRING = re.compile(r'"((?:[^"\\\n]|\\.)*)"')
ENTRY = re.compile(r'"((?:[^"\\]|\\.)*)"\s+to\s+"((?:[^"\\]|\\.)*)"', re.S)

# Things that are data, code or a name, not prose.
SKIP_EXACT = {
    "FLOP", "Seeker", "Solana", "Technocore", "Seed Vault", "StrongBox", "Android",
    "Alex Kosa", "@AlexKosa1", "text/plain", "did:key:", "https://technocore.chat",
    "flop-passport", "UTF-8", "SHA-256", "Ed25519",
}
SKIP_IF_CONTAINS = (
    "://", "did:key:z", "androidx.", "dev.alexkosa", "R.drawable", "%s", "%02x",
    "\\u", "/kv/", "/r/", "solana:", "#FLOP", "font_scale",
)


# Deliberately English, each for a reason worth writing down.
ALLOWED = {
    # Exception text. These are the messages of thrown errors and failed `require`s: they
    # reach a crash log and a developer, never a screen. The app shows a written sentence
    # for every one of these situations instead.
    "A Solana account key is 32 bytes, got ",
    # A substring test on an exception message, never shown.
    "connect",
    "no connection",
    "no stream",
    "The wallet signed with a different account than the one it authorized",
    "A nonce is 1-19 digits",
    "An Ed25519 signature is 64 bytes, got ",
    "No Passport stored on this device",
    "Nothing visible survives the sweep",
    "Passport ciphertext has no IV",
    "Passport seed must be 32 bytes, got ",
    "Produced a non-canonical signature",
    "Refusing to store a seed that does not produce the expected DID",
    "The Passport wrapping key is missing from the Keystore",
    "The note was accepted but read back as: ",
    "The wallet returned no signature",
    "The wallet returned no signed message",
    "!! UNTRUSTED CONTENT",
    "$PREFIX ${DidKey.fingerprint(did)} ${hashOf(noteBody)}",
    "A Solana account key is 32 bytes, got ${walletPublicKey.size}",
    "An Ed25519 signature is 64 bytes, got ${signature.size}",
    "Passport seed must be 32 bytes, got ${seed.size}",
    "The note was accepted but read back as: ${readBack ?: ",
    "technocore.chat answered ${r.status}",
    "technocore.chat answered ${r.status} for the note",
    "technocore.chat sent something that is not a room",
    # JSON field names and a clipboard label, not sentences.
    "FLOP Passport",
    "from",
    "messages",

    # The text that gets signed and posted. Translating it would change the bytes the
    # signature covers, which is the one thing in this app that must never move.
    # The first signed line, for the same reason as the daily one: it is the text a
    # signature covers, so translating it would change the bytes the key vouched for.
    "FLOP Passport for Seeker. First signed check-in. ",
    "FLOP Passport for Seeker. First signed check-in.",
    "FLOP Passport for Seeker. Signed record for $today.",
    # Data, shown as data: a status line, a measurement, a counter, a hex blob.
    "HTTP ${r.status}: ${r.message}",
    "${draft.weightedLength} / 280",
    "${pulse.millis} ms",
    "$verifiedCount / 5",
    "seed_hex: $seedHex",
    "did: $identity",
    "seq ${record.seq}",
    # A label on the system clipboard, not a sentence on our screen.
    "FLOP Passport key",
    # Names of animations and of animated values. Never drawn.
    "breathe", "travel", "pulse", "alpha", "mark", "wire", "token", "name",
    # The names of placeholders, as in t("vault {level}", "level" to ...). The sentence
    # around them is translated; these are the holes in it.
    "title", "level", "code", "count", "room", "seq", "character",
}


def looks_like_prose(s: str) -> bool:
    t = s.strip()
    if len(t) < 4 or t in SKIP_EXACT or t in ALLOWED:
        return False
    if any(bit in t for bit in SKIP_IF_CONTAINS):
        return False
    # A Kotlin template is not a sentence a translator can be given: the hole is filled at
    # runtime with a status code, a byte count or a hash. The sentences that legitimately
    # carry a hole use {braces} instead, which this app's own `t()` fills after lookup.
    if re.search(r"\$\{|\$[A-Za-z_]", t):
        return False
    if not re.search(r"[A-Za-z]", t):
        return False
    # A sentence, a label of two words, or a single word that is plainly a caption.
    words = [w for w in re.split(r"\s+", t) if w]
    if len(words) == 1:
        return t.islower() and t.isalpha() and len(t) > 3
    return True


def table_keys() -> set[str]:
    keys: set[str] = set()
    for path in I18N.glob("*.kt"):
        if path.name == "Strings.kt":
            continue
        for english, _ in ENTRY.findall(path.read_text(encoding="utf-8")):
            keys.add(english)
    return keys


def main() -> int:
    keys = table_keys()
    missing: dict[str, list[str]] = {}

    for folder in LOOKED_AT:
        for path in sorted((SRC / folder).rglob("*.kt")):
            text = path.read_text(encoding="utf-8")
            # Comments carry English prose that is never drawn; strip them first.
            text = re.sub(r"/\*.*?\*/", "", text, flags=re.S)
            text = re.sub(r"//[^\n]*", "", text)
            # Kotlin joins a long sentence out of several literals. The app looks up the
            # joined result, so that is what has to be compared - checking the pieces
            # reports two thirds of the app as untranslated and hides the real gaps in
            # the noise.
            text = re.sub(r'"\s*\+\s*"', "", text, flags=re.S)
            for m in STRING.finditer(text):
                s = m.group(1)
                if not looks_like_prose(s) or s in keys:
                    continue
                missing.setdefault(s, []).append(str(path.relative_to(SRC)))

    gaps = uneven_tables()

    if not missing and not gaps:
        print("every sentence in the app has an entry, in every language")
        return 0

    if missing:
        print(f"{len(missing)} string(s) with no entry in any table:\n")
        for s, where in sorted(missing.items(), key=lambda kv: -len(kv[0])):
            print(f"  {where[0]}")
            print(f"    {s[:150]}")

    if gaps:
        print(f"\n{sum(len(v) for v in gaps.values())} entry/entries present in some "
              "languages and not others:\n")
        for lang, keys in sorted(gaps.items()):
            print(f"  {lang} is missing {len(keys)}:")
            for k in sorted(keys):
                print(f"    {k[:110]}")
    return 1


def uneven_tables() -> dict[str, set[str]]:
    """Where one language carries a sentence and another quietly does not.

    Every table should hold the same keys: they translate the same app. A key present in
    nine of ten is not a judgement call, it is a line somebody forgot, and the person it
    happens to sees a paragraph of English in the middle of their own language.
    """
    tables: dict[str, set[str]] = {}
    for path in sorted(I18N.glob("*.kt")):
        if path.name == "Strings.kt":
            continue
        tables[path.stem] = {
            english for english, _ in ENTRY.findall(path.read_text(encoding="utf-8"))
        }
    if not tables:
        return {}
    everything: set[str] = set().union(*tables.values())
    return {lang: everything - keys for lang, keys in tables.items() if everything - keys}


if __name__ == "__main__":
    sys.exit(main())
