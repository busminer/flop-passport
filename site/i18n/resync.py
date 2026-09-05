"""Bring the `<lang>.raw.json` files back into step after the page is reordered.

    python site/i18n/resync.py <path to the previous segments.json>

`pack.py` pairs a raw file with `segments.json` by position, which is what makes writing a
translation bearable - a flat list, in reading order, nothing to key by hand. The cost is
that moving a section of the page silently re-points every translation after it.

Nothing is lost as long as the old order is known: each raw entry belongs to the English
sentence that sat at its index before, and that sentence still has an index now. This
rewrites the raw files into the new order, reports any sentence that no longer exists, and
leaves an empty slot for anything new - which `pack.py` skips and the page then renders in
English rather than blank.

The keyed `<lang>.json` tables are not touched. They were never order-dependent; only the
raw files are, and only because a person has to read them.
"""
from __future__ import annotations

import json
import sys
from pathlib import Path

HERE = Path(__file__).resolve().parent
LANGS = ["ru", "zh", "es", "pt", "de", "tr", "vi", "id", "ko", "ja"]


def main() -> int:
    if len(sys.argv) != 2:
        print(__doc__)
        return 2

    old = json.loads(Path(sys.argv[1]).read_text(encoding="utf-8"))
    new = json.loads((HERE / "segments.json").read_text(encoding="utf-8"))

    for lang in LANGS:
        path = HERE / f"{lang}.raw.json"
        if not path.exists():
            continue
        raw = json.loads(path.read_text(encoding="utf-8"))
        if len(raw) != len(old):
            print(f"{lang}: {len(raw)} entries against an old list of {len(old)}, skipped")
            continue

        by_english = {english: raw[i] for i, english in enumerate(old)}
        rebuilt = [by_english.get(english, "") for english in new]
        missing = sum(1 for v in rebuilt if not v)
        gone = [e for e in old if e not in set(new)]

        path.write_text(json.dumps(rebuilt, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")
        note = f", {missing} now empty" if missing else ""
        note += f", {len(gone)} sentence(s) no longer on the page" if gone else ""
        print(f"{lang}: {len(rebuilt)} entries{note}")

    return 0


if __name__ == "__main__":
    sys.exit(main())
