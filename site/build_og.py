"""Make the picture a link preview shows.

    python site/build_og.py

X, Telegram and every chat app that unfurls a link want 1200x630. The store banner is
1200x600 and already carries the brand, the claim and the device, so the honest thing is to
use it rather than invent a second look for the same product.

The missing 30 pixels are added by repeating the top and bottom rows of the image itself,
not by painting a strip of flat colour behind it. The banner's background is a gradient; a
flat strip lands on it as a visible seam across the top of every shared link, which is the
kind of detail nobody names and everybody notices.
"""
from __future__ import annotations

from pathlib import Path

from PIL import Image

ROOT = Path(__file__).resolve().parent.parent
SOURCE = ROOT / "design/store/banner-1200x600.png"
TARGET = ROOT / "site/assets/og.png"

WIDTH, HEIGHT = 1200, 630


def main() -> None:
    banner = Image.open(SOURCE).convert("RGB")
    if banner.size != (1200, 600):
        raise SystemExit(f"expected a 1200x600 banner, found {banner.size}")

    pad = (HEIGHT - banner.height) // 2
    canvas = Image.new("RGB", (WIDTH, HEIGHT))
    canvas.paste(banner, (0, pad))

    # Edge replication: the top row stretched upward, the bottom row stretched down.
    top = banner.crop((0, 0, WIDTH, 1)).resize((WIDTH, pad))
    bottom = banner.crop((0, banner.height - 1, WIDTH, banner.height)).resize(
        (WIDTH, HEIGHT - banner.height - pad)
    )
    canvas.paste(top, (0, 0))
    canvas.paste(bottom, (0, pad + banner.height))

    TARGET.parent.mkdir(parents=True, exist_ok=True)
    canvas.save(TARGET, "PNG", optimize=True)
    print(f"wrote {TARGET.relative_to(ROOT)} - {canvas.size[0]}x{canvas.size[1]}, "
          f"{TARGET.stat().st_size // 1024} KB")


if __name__ == "__main__":
    main()
