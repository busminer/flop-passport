"""Pull the page's sentences out of the markup, so they can be translated.

    python site/i18n/extract.py

Writes `segments.json`: every leaf block on the site - a heading, a paragraph, a list
item, a button's face - as the exact inner HTML it has in the partial. Inline tags stay
inside the segment on purpose. A translator handed "publishes it where anyone can verify
it" as three fragments around a `<code>` tag cannot move the words, and every language
here moves words differently from English.

The segments are keyed by the English text itself, the same rule the app uses: a string
nobody has translated renders in English rather than as an identifier. The cost is the
same too - editing an English sentence orphans its translation - and `apply.py` reports
that rather than letting it pass silently.

This step needs BeautifulSoup. The site build does not: `apply.py` writes finished
partials to disk, and `build.py` only assembles them.
"""
from __future__ import annotations

import json
from pathlib import Path

from bs4 import BeautifulSoup, NavigableString, Tag

SITE = Path(__file__).resolve().parent.parent
HERE = Path(__file__).resolve().parent

# The partials that carry prose. `_quotes.html` is deliberately absent: the quotes are
# what FLOP said, in the language they said it in, and the page promises them in full.
SOURCES = ["_body.html", "_privacy.html", "_platform.html", "_tip.html"]

# A leaf block is one of these with no other block inside it.
BLOCKS = {"h1", "h2", "h3", "h4", "p", "li", "blockquote", "figcaption", "summary", "dt", "dd"}
# Small standalone labels and controls, which hold a word or two and no children.
LEAVES = {"button", "span", "a", "strong", "em"}

# Text that is data, a mark, or a name. Translating any of these would be a bug.
SKIP = {
    "Passport", "FLOP", "$FLOP", "Seeker", "Solana", "Solana Mobile", "Technocore",
    "Seed Vault", "StrongBox", "Alex Kosa", "@AlexKosa1", "@flop_labs", "alexkosa.dev",
    "did:key", "flop.alexkosa.dev", "FLOP Passport", "FLOP Passport for Seeker",
    # The tip wallet, printed under the button so a desktop reader can copy it. It is an
    # address: one wrong character sends money nowhere, so no language gets to touch it.
    "BmJaEmaEURBDpj91GUTvJcpKy2MAu8ZtRFRPaMpEuuax",
}


def is_block(node: Tag) -> bool:
    return node.name in BLOCKS


def has_block_child(node: Tag) -> bool:
    return any(isinstance(c, Tag) and c.name in BLOCKS for c in node.descendants)


def inner(node: Tag) -> str:
    return node.decode_contents()


def worth_translating(html: str) -> bool:
    t = " ".join(html.split())
    return bool(t) and t not in SKIP and any(ch.isalpha() for ch in t)


def leaves(soup: BeautifulSoup):
    """Walk the one rule both halves of this depend on: which nodes hold a sentence.

    `apply.py` puts translations back through this same walk rather than by searching the
    file for the English text, so the two can never disagree about what a segment is.
    """
    for node in soup.find_all(True):
        # `translate="no"` is the standard attribute for text that must survive as written,
        # and it is honoured here for the same reason a machine translator honours it: a
        # translated sentence inside quotation marks, attributed to a named account on a
        # named date, is a quotation nobody made. The one place it is used is FLOP's own
        # words in the manual, which appear a screen higher with a labelled translation.
        if node.get("translate") == "no" or node.find_parent(attrs={"translate": "no"}):
            continue
        if node.name in BLOCKS and not has_block_child(node):
            pass
        elif node.name in LEAVES and not any(isinstance(c, Tag) for c in node.children):
            parent = node.find_parent()
            if parent is not None and parent.name in BLOCKS and not has_block_child(parent):
                continue  # already covered by the block around it
        else:
            continue
        html = inner(node)
        if worth_translating(html):
            yield node, html


def collect(path: Path) -> list[str]:
    soup = BeautifulSoup(path.read_text(encoding="utf-8"), "html.parser")
    return [html for _, html in leaves(soup)]


def main() -> None:
    segments: list[str] = []
    seen: set[str] = set()
    per_file = {}
    for name in SOURCES:
        found = collect(SITE / name)
        per_file[name] = len(found)
        for s in found:
            if s not in seen:
                seen.add(s)
                segments.append(s)

    (HERE / "segments.json").write_text(
        json.dumps(segments, ensure_ascii=False, indent=2) + "\n", encoding="utf-8"
    )
    words = sum(len(" ".join(s.split()).split()) for s in segments)
    for name, n in per_file.items():
        print(f"{name}: {n} segments")
    print(f"segments.json: {len(segments)} unique, about {words} words")


if __name__ == "__main__":
    main()
