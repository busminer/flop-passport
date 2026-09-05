"""Check the translation tables for the mistakes a reader would notice and I would not.

    python site/i18n/lint.py

Every check here exists because it caught something real, or because the failure it looks
for is silent. A translation is the one kind of text whose author cannot proofread it by
reading it back: I wrote the Japanese, so I am the last person who will notice a Russian
word left inside a Japanese sentence. A script notices.

  * script bleed - a language written in the wrong alphabet for the file it is in. This
    found `первый взгляд` sitting in the middle of a Japanese quote;
  * untranslated entries - a value identical to its English key, which renders correctly
    and says nothing was done;
  * markup drift - tags or `{placeholders}` that differ from the English;
  * missing files and short tables, per language, so a half-finished language is visible
    as a number rather than as an English paragraph in the middle of a page.
"""
from __future__ import annotations

import json
import re
import sys
from pathlib import Path

HERE = Path(__file__).resolve().parent

LANGS = ["ru", "zh", "es", "pt", "de", "tr", "vi", "id", "ko", "ja"]

CYRILLIC = re.compile(r"[Ѐ-ӿ]")
HAN = re.compile(r"[一-鿿]")
KANA = re.compile(r"[぀-ヿ]")
HANGUL = re.compile(r"[가-힯]")

TAG = re.compile(r"<\s*/?\s*([a-zA-Z0-9]+)")
PLACEHOLDER = re.compile(r"\{[a-z_]+\}")

# Names that are the same in every language and must never be translated away.
KEEP = ["FLOP", "Technocore", "Seed Vault", "StrongBox", "Seeker", "Solana"]


def signature(html: str) -> tuple:
    return (tuple(sorted(TAG.findall(html))), tuple(sorted(PLACEHOLDER.findall(html))))


def wrong_script(lang: str, text: str) -> str | None:
    """A stray alphabet is almost always a sentence left over from another language."""
    if lang != "ru" and CYRILLIC.search(text):
        return "Cyrillic"
    if lang not in ("zh", "ja") and HAN.search(text):
        return "Han characters"
    if lang != "ja" and KANA.search(text):
        return "kana"
    if lang != "ko" and HANGUL.search(text):
        return "Hangul"
    if lang == "ja" and not (KANA.search(text) or HAN.search(text)) and len(text) > 40:
        return "no Japanese script at all"
    if lang == "ko" and not HANGUL.search(text) and len(text) > 40:
        return "no Hangul at all"
    return None


def check_table(
    lang: str, name: str, table: dict[str, str], problems: list[str], *, keyed_by_english: bool = True
) -> None:
    """`keyed_by_english` is false for the quote cards, whose keys are post ids.

    There the key says nothing about the value, so comparing markup between them is
    meaningless - and the quotes themselves contain `<fp>` and `<sha256 of the body>`,
    which a tag check reads as markup that the translation invented.
    """
    for english, translated in table.items():
        where = f"{lang} {name} {english[:48]!r}"
        if english.startswith("_") or english.endswith(":date"):
            continue
        script = wrong_script(lang, translated)
        if script:
            problems.append(f"{where}\n    {script} in the translation: {translated[:90]!r}")
        if not keyed_by_english:
            continue
        if translated.strip() == english.strip() and len(english) > 24:
            problems.append(f"{where}\n    identical to the English")
        if signature(english) != signature(translated):
            problems.append(f"{where}\n    markup or placeholders differ: {translated[:90]!r}")
        for word in KEEP:
            if word in english and word not in translated:
                problems.append(f"{where}\n    lost the name {word!r}")


def main() -> int:
    segments = json.loads((HERE / "segments.json").read_text(encoding="utf-8"))
    js_keys = json.loads((HERE / "segments-js.json").read_text(encoding="utf-8"))
    problems: list[str] = []

    for lang in LANGS:
        counts = []
        for name, expected in (("json", len(segments)), ("js.json", len(js_keys))):
            path = HERE / f"{lang}.{name}"
            if not path.exists():
                counts.append(f"{name}: missing")
                continue
            table = json.loads(path.read_text(encoding="utf-8"))
            check_table(lang, name, table, problems)
            counts.append(f"{name}: {len(table)}/{expected}")

        quotes = HERE / f"{lang}.quotes.json"
        if quotes.exists():
            table = json.loads(quotes.read_text(encoding="utf-8"))
            check_table(lang, "quotes", table, problems, keyed_by_english=False)
            counts.append(f"quotes: {len(table)}")
        else:
            counts.append("quotes: missing")

        print(f"{lang}: " + ", ".join(counts))

    if problems:
        print("\n" + "\n".join(problems))
        print(f"\n{len(problems)} problem(s).")
        return 1
    print("\nno problems found")
    return 0


if __name__ == "__main__":
    sys.exit(main())
