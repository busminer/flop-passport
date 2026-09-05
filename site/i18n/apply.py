"""Write the translated partials the site build assembles.

    python site/i18n/apply.py

Reads `segments.json` and one `<lang>.json` per language, and writes `_body.ru.html`,
`_privacy.ru.html` and so on next to the English partials. The build itself then needs
nothing but string replacement, so a missing library on the machine that deploys cannot
turn into a half-English page in front of a reader.

Replacement walks the document with the same rule that extracted the segments, rather than
searching the file for the English text. Searching looked simpler and was wrong: the
segments come out of a parser, which turns `<br />` into `<br/>` and `&middot;` into the
character it stands for, so 27 of 181 sentences never matched their own source and stayed
in English in a page that was otherwise fully translated. Walking the same tree cannot
drift like that - a segment is found where it was taken from, or it is reported.

Every translation is checked before anything is written:

  * a translation whose inline tags differ from the English is refused. `<code>` around
    `did:key` carries meaning here, and a dropped `</a>` silently eats the rest of a page;
  * a placeholder like `{name}` must survive;
  * an untranslated segment is reported by count, and left in English rather than hidden.
"""
from __future__ import annotations

import json
import re
import sys
from pathlib import Path

from bs4 import BeautifulSoup

from extract import SOURCES, leaves

SITE = Path(__file__).resolve().parent.parent
HERE = Path(__file__).resolve().parent

# The language codes the app offers, in the app's own order.
LANGS = ["ru", "zh", "es", "pt", "de", "tr", "vi", "id", "ko", "ja"]

TAG = re.compile(r"<\s*/?\s*([a-zA-Z0-9]+)")
PLACEHOLDER = re.compile(r"\{[a-z_]+\}")


def signature(html: str) -> tuple:
    """What must be identical on both sides: the tags used, and how many of each."""
    return (tuple(sorted(TAG.findall(html))), tuple(sorted(PLACEHOLDER.findall(html))))


def check(lang: str, table: dict[str, str], segments: list[str]) -> list[str]:
    problems = []
    known = set(segments)
    for english, translated in table.items():
        if english not in known:
            problems.append(f"{lang}: orphan, no longer on the site: {english[:70]!r}")
            continue
        if signature(english) != signature(translated):
            problems.append(
                f"{lang}: markup differs\n    en: {english[:110]!r}\n    {lang}: {translated[:110]!r}"
            )
    return problems


def translate_file(path: Path, table: dict[str, str]) -> tuple[str, int, int]:
    soup = BeautifulSoup(path.read_text(encoding="utf-8"), "html.parser")
    hit = miss = 0
    # Collected before anything is changed. Replacing a paragraph detaches the `<strong>`
    # inside it, and a detached node is neither translated nor missing - it is simply no
    # longer part of the page, and counting it either way would be a lie.
    for node, inner in list(leaves(soup)):
        if node.parent is None:
            continue
        translated = table.get(inner)
        if translated is None:
            miss += 1
            continue
        node.clear()
        node.append(BeautifulSoup(translated, "html.parser"))
        hit += 1
    return str(soup), hit, miss


def main() -> int:
    segments = json.loads((HERE / "segments.json").read_text(encoding="utf-8"))
    problems: list[str] = []
    tables: dict[str, dict[str, str]] = {}

    for lang in LANGS:
        path = HERE / f"{lang}.json"
        if not path.exists():
            print(f"{lang}: no table yet, skipped")
            continue
        table = json.loads(path.read_text(encoding="utf-8"))
        problems += check(lang, table, segments)
        tables[lang] = table

    if problems:
        print("\n".join(problems))
        print(f"\n{len(problems)} problem(s). Nothing written.")
        return 1

    for lang, table in tables.items():
        hit = miss = 0
        for name in SOURCES:
            text, h, m = translate_file(SITE / name, table)
            hit += h
            miss += m
            (SITE / name.replace(".html", f".{lang}.html")).write_text(text, encoding="utf-8")
        note = f", {miss} still English" if miss else ""
        print(f"{lang}: {hit}/{hit + miss} places translated{note}")

    return 0


if __name__ == "__main__":
    sys.exit(main())
