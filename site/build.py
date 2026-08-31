"""Assemble the site's pages from parts and the official brand SVGs.

The marks are inlined rather than linked so the page renders them with no second request
and no chance of a broken image where a logo should be. Path data is copied byte for byte
out of the supplied files; only the wrapping `<svg>` attributes are touched, and only to
size and scope them.

    python site/build.py
"""
from __future__ import annotations

import re
import hashlib

import quotes
from pathlib import Path

SITE = Path(__file__).parent
ASSETS = SITE / "assets"


def svg(name: str, *, class_prefix: str | None = None) -> str:
    """Inline an SVG, optionally renaming its CSS classes so two marks can share a page."""
    text = (ASSETS / name).read_text(encoding="utf-8")
    text = re.sub(r"<\?xml[^>]*\?>\s*", "", text)
    text = re.sub(r"<!--.*?-->", "", text, flags=re.S)
    if class_prefix:
        # Both official files use .st0/.st1. Inlined together, the second would repaint the
        # first: the wordmark would take the Chip's accent, which is exactly the mistake the
        # brand guide calls out.
        text = re.sub(r"\.st(\d)", rf".{class_prefix}\1", text)
        text = re.sub(r'class="st(\d)"', rf'class="{class_prefix}\1"', text)
    return text.strip()


def cachebust(name: str) -> str:
    """Append a content hash so a redeploy cannot serve a stale stylesheet.

    Learned the boring way: an edited stylesheet kept rendering the old layout in a
    browser that had cached it, which reads exactly like a CSS rule that did not work.
    """
    digest = hashlib.sha256((SITE / name).read_bytes()).hexdigest()[:8]
    return f"/{name}?v={digest}"


def page(title: str, description: str, body: str) -> str:
    return f"""<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>{title}</title>
<meta name="description" content="{description}" />
<meta name="color-scheme" content="dark" />
<meta name="theme-color" content="#0A1128" />

<meta property="og:title" content="{title}" />
<meta property="og:description" content="{description}" />
<meta property="og:type" content="website" />
<meta property="og:url" content="https://flop.alexkosa.dev/" />

<link rel="icon" href="/assets/flop-chip-favicon.svg" type="image/svg+xml" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Space+Mono:wght@400;700&family=Inter:wght@400;500&display=swap" />
<link rel="stylesheet" href="{cachebust("styles.css")}" />
</head>
<body>
{body}
<script src="{cachebust("app.js")}" defer></script>
</body>
</html>
"""


def build_index() -> None:
    body = (SITE / "_body.html").read_text(encoding="utf-8")
    lockup = svg("flop-lockup-reverse.svg", class_prefix="fl")
    seeker = svg("seeker_solana_mobile_lockup_white.svg", class_prefix="sk")

    small = lockup.replace("<svg ", '<svg style="height:20px;width:auto" ', 1)

    body = body.replace("<!--LOCKUP_SMALL-->", small)
    body = body.replace("<!--LOCKUP-->", lockup)
    body = body.replace("<!--SEEKER-->", seeker)
    body = body.replace("<!--TWEETS-->", quotes.render())
    # A second copy for the platform plate: an SVG cannot be in two places at
    # once, and its classes are scoped again so the two do not share a rule.
    body = body.replace(
        "<!--SEEKER_PLATE-->",
        svg("seeker_solana_mobile_lockup_white.svg", class_prefix="sp"),
    )

    out = page(
        "FLOOP Passport for Seeker",
        "Create a Technocore did:key identity from your Solana wallet, publish it where "
        "anyone can verify it, and keep the receipts. Open source, no account, no server.",
        body,
    )
    (SITE / "index.html").write_text(out, encoding="utf-8")
    print(f"wrote index.html — {len(out) // 1024} KB")


def build_privacy() -> None:
    body = (SITE / "_privacy.html").read_text(encoding="utf-8")
    small = svg("flop-lockup-reverse.svg", class_prefix="fl").replace(
        "<svg ", '<svg style="height:20px;width:auto" ', 1
    )
    body = body.replace("<!--LOCKUP_SMALL-->", small)
    out = page(
        "Privacy — FLOOP Passport for Seeker",
        "FLOOP Passport has no account, no analytics and no server of its own. What the app "
        "stores, what leaves your phone, and how to delete everything.",
        body,
    )
    (SITE / "privacy.html").write_text(out, encoding="utf-8")
    print(f"wrote privacy.html — {len(out) // 1024} KB")


if __name__ == "__main__":
    build_index()
    build_privacy()
