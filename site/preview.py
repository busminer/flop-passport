"""Build a single self-contained HTML file of the site, for review off a server.

Inlines the stylesheet, the script and the two images, so the file can be opened straight
from disk with nothing else beside it. Every substitution uses a lambda rather than a
replacement string: the script contains regex escapes like `\\s`, and `re.sub` would try to
interpret those as replacement templates and fail.

    python site/preview.py
"""
from __future__ import annotations

import base64
import re
from pathlib import Path

SITE = Path(__file__).parent

IMAGES = (
    ("flop_labs_avatar.jpg", "image/jpeg"),
    ("flop-chip-favicon.svg", "image/svg+xml"),
)


def main() -> None:
    html = (SITE / "index.html").read_text(encoding="utf-8")
    css = (SITE / "styles.css").read_text(encoding="utf-8")
    js = (SITE / "app.js").read_text(encoding="utf-8")

    html = re.sub(
        r'<link rel="stylesheet" href="/styles\.css\?v=[a-f0-9]+" />',
        lambda _: "<style>\n" + css + "\n</style>",
        html,
    )
    html = re.sub(
        r'<script src="/app\.js\?v=[a-f0-9]+" defer></script>',
        lambda _: "<script>\n" + js + "\n</script>",
        html,
    )

    for name, mime in IMAGES:
        data = base64.b64encode((SITE / "assets" / name).read_bytes()).decode()
        html = html.replace(f"/assets/{name}", f"data:{mime};base64,{data}")

    # The privacy page cannot be reached from a file on disk, so point at where it will live.
    html = html.replace('href="/privacy.html"', 'href="https://flop.alexkosa.dev/privacy.html"')

    out = SITE / "preview-single-file.html"
    out.write_text(html, encoding="utf-8")
    print(f"wrote {out.name} — {len(html) // 1024} KB")


if __name__ == "__main__":
    main()
