"""Turn a plain list of translations into the keyed table `apply.py` reads.

    python site/i18n/pack.py ru

A translator - me, sentence by sentence - works from `segments.json`, which is an ordered
list, and writes `ru.raw.json`: the same list, same length, same order, translated. This
script pairs them up.

Retyping the English key beside each translation would be the obvious alternative and is a
bad one: the keys carry the indentation they have in the partial, and a key that differs
from the page by one space matches nothing and fails silently as English. Here the key
comes from the file, and the surrounding whitespace is put back around the translation, so
the built HTML keeps the shape of the source.

An entry left as the empty string is not a translation and is skipped, so the page shows
that sentence in English rather than showing it blank.
"""
from __future__ import annotations

import json
import sys
from pathlib import Path

HERE = Path(__file__).resolve().parent


def whitespace(sample: str) -> tuple[str, str]:
    lead = sample[: len(sample) - len(sample.lstrip())]
    trail = sample[len(sample.rstrip()):]
    return lead, trail


def pack(lang: str) -> None:
    segments = json.loads((HERE / "segments.json").read_text(encoding="utf-8"))
    raw = json.loads((HERE / f"{lang}.raw.json").read_text(encoding="utf-8"))
    if len(raw) != len(segments):
        raise SystemExit(
            f"{lang}.raw.json has {len(raw)} entries, segments.json has {len(segments)}. "
            "They are paired by position, so a missing line would shift every one after it."
        )

    table = {}
    for english, translated in zip(segments, raw):
        if not translated.strip():
            continue
        lead, trail = whitespace(english)
        table[english] = lead + translated.strip() + trail

    out = HERE / f"{lang}.json"
    out.write_text(json.dumps(table, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")
    print(f"{lang}.json: {len(table)}/{len(segments)} segments")


if __name__ == "__main__":
    for name in sys.argv[1:]:
        pack(name)
