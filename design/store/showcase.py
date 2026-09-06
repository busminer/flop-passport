"""Shared pieces for the store art that is built out of real phone captures.

The banner and the screenshots both want the same three things: a screen cut out
of a Seeker capture, a device shape to put it in, and a way to stand that device
at an angle. They live here so the two builders cannot drift apart.

Nothing in here invents a look. The palette is the app's own, the fonts are the
two the app ships, and every screen is a capture from the phone rather than a
mockup - which is the whole reason the art can be trusted to match what a person
installs.
"""
from __future__ import annotations

import os

import numpy as np
from PIL import Image, ImageDraw, ImageFilter

ROOT = os.path.abspath(os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", ".."))
OUT = os.path.join(ROOT, "design", "store")
RAW = os.path.join(OUT, "raw")
FONTS = os.path.join(ROOT, "app", "src", "main", "res", "font")
MONO_B = os.path.join(FONTS, "space_mono_bold.ttf")
MONO_R = os.path.join(FONTS, "space_mono_regular.ttf")
INTER = os.path.join(FONTS, "inter_regular.ttf")

BASE = (10, 17, 40)
CYAN = (0, 180, 216)
BLUE = (4, 102, 200)
GREEN = (50, 215, 75)
ICE = (245, 247, 250)
GREY = (92, 102, 112)

# Measured on this Seeker, not guessed: the status bar ends at y=90 and the
# gesture pill owns the last 58 rows. Neither is the app, and both date a
# screenshot with somebody's battery level and notification icons.
STATUS_BAR_PX = 90
GESTURE_PILL_PX = 58


def screen(name):
    """One capture with the system furniture cropped off."""
    im = Image.open(os.path.join(RAW, name)).convert("RGB")
    return im.crop((0, STATUS_BAR_PX, im.width, im.height - GESTURE_PILL_PX))


def device(im, width, radius=0.055, edge=(58, 84, 132), edge_px=3):
    """Put a screen in a rounded body with a hairline edge, on transparency.

    The rounding is done at four times the size and scaled down, because a mask
    drawn straight at final size gives corners with visible steps in them.
    """
    h = round(im.height * width / im.width)
    im = im.resize((width, h), Image.LANCZOS).convert("RGBA")
    r = int(width * radius)

    s = 4
    mask = Image.new("L", (width * s, h * s), 0)
    ImageDraw.Draw(mask).rounded_rectangle((0, 0, width * s - 1, h * s - 1), radius=r * s, fill=255)
    mask = mask.resize((width, h), Image.LANCZOS)

    body = Image.new("RGBA", (width, h), (0, 0, 0, 0))
    body.paste(im, (0, 0))
    body.putalpha(mask)

    ring = Image.new("RGBA", (width, h), (0, 0, 0, 0))
    ImageDraw.Draw(ring).rounded_rectangle(
        (edge_px / 2, edge_px / 2, width - edge_px / 2 - 1, h - edge_px / 2 - 1),
        radius=r, outline=edge + (255,), width=edge_px,
    )
    body.alpha_composite(ring)
    return body


def _coeffs(dst, src):
    """Perspective coefficients mapping output points back to input points."""
    a, b = [], []
    for (x, y), (u, v) in zip(dst, src):
        a.append([x, y, 1, 0, 0, 0, -u * x, -u * y])
        a.append([0, 0, 0, x, y, 1, -v * x, -v * y])
        b += [u, v]
    return np.linalg.lstsq(np.array(a, float), np.array(b, float), rcond=None)[0]


def stand(im, lean, facing):
    """Tilt a device as if it were standing at an angle to the viewer.

    `lean` is how much of its height the far edge loses, 0 for flat on and about
    0.3 for a hard angle. `facing` is the side the near edge is on: a device to
    the left of the centre faces right, so its right edge is the tall one.

    The canvas grows by the same amount it would otherwise crop, so nothing is
    cut off and the caller can keep positioning by the centre.
    """
    w, h = im.size
    cut = h * lean / 2
    pad = int(cut) + 2
    canvas = Image.new("RGBA", (w, h + pad * 2), (0, 0, 0, 0))
    canvas.paste(im, (0, pad))
    W, H = canvas.size

    if facing == "right":
        dst = [(0, pad + cut), (W, pad), (W, H - pad), (0, H - pad - cut)]
    else:
        dst = [(0, pad), (W, pad + cut), (W, H - pad - cut), (0, H - pad)]
    src = [(0, 0), (W, 0), (W, H), (0, H)]
    return canvas.transform((W, H), Image.PERSPECTIVE, _coeffs(dst, src), Image.BICUBIC)


def recede(im, dim, blur=0.0):
    """Push a device into the distance: darker toward the background, softer."""
    if blur:
        im = im.filter(ImageFilter.GaussianBlur(blur))
    veil = Image.new("RGBA", im.size, BASE + (int(255 * dim),))
    veil.putalpha(Image.eval(im.split()[3], lambda v: int(v * dim)))
    out = im.copy()
    out.alpha_composite(veil)
    return out


def glow(size, centre, radius, colour, peak):
    """A soft radial wash, built small and blown back up so it stays smooth."""
    s = 8
    small = Image.new("L", (max(size[0] // s, 1), max(size[1] // s, 1)), 0)
    d = ImageDraw.Draw(small)
    cx, cy, r = centre[0] / s, centre[1] / s, radius / s
    steps = 44
    for i in range(steps, 0, -1):
        rr = r * i / steps
        d.ellipse((cx - rr, cy - rr, cx + rr, cy + rr), fill=int(peak * (1 - i / steps) ** 2))
    layer = Image.new("RGBA", size, colour + (0,))
    layer.putalpha(small.resize(size, Image.BICUBIC))
    return layer


def shade(size, centre, radius, peak):
    """The same wash in the background colour, to sit a bright word on."""
    return glow(size, centre, radius, BASE, peak)


def tint(mark, colour, alpha):
    solid = Image.new("RGBA", mark.size, colour + (255,))
    solid.putalpha(mark.split()[3].point(lambda v: int(v * alpha)))
    return solid


def fit(mark, width=None, height=None):
    w, h = mark.size
    if width:
        height = round(h * width / w)
    else:
        width = round(w * height / h)
    return mark.resize((width, height), Image.LANCZOS)


def spaced(d, xy, text, font, fill, tracking=0):
    x, y = xy
    for ch in text:
        d.text((x, y), ch, font=font, fill=fill)
        x += d.textlength(ch, font=font) + tracking


def spaced_width(d, text, font, tracking=0):
    return sum(d.textlength(c, font=font) + tracking for c in text) - tracking


def paste_centre(bg, im, centre):
    bg.alpha_composite(im, (int(centre[0] - im.width / 2), int(centre[1] - im.height / 2)))
