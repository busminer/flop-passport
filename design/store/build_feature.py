"""Build the square feature graphic, in the same language as the banner.

    python design/store/build_feature.py

Writes design/store/feature-1200x1200.png. The store uses it only in the
Editor's Choice rail on the home screen, where it is shown whole with no
furniture over it - so unlike the banner it may use its own middle, and the name
sits where a square wants it.

Same idea as the banner: the app stands behind its own name. Here the screens
fan out below the wordmark instead of beside it, because a square gives height
rather than width.
"""
import os

from PIL import Image, ImageDraw, ImageFont

from build_store_assets import marks
from showcase import (
    BASE, BLUE, CYAN, ICE, MONO_B, MONO_R, OUT,
    device, fit, glow, paste_centre, recede, shade, spaced, spaced_width, stand, screen, tint,
)

S = 1200

#   name, centre x, centre y, width, lean, facing, dim, blur
CROWD = [
    ("06-languages.png", 118, 990, 250, 0.30, "right", 0.70, 2.2),
    ("04-activity.png", 366, 968, 310, 0.22, "right", 0.50, 1.1),
    ("01-identity.png", 600, 950, 372, 0.00, "right", 0.26, 0.0),
    ("03-done.png", 834, 968, 310, 0.22, "left", 0.50, 1.1),
    ("05-seedvault.png", 1082, 990, 250, 0.30, "left", 0.70, 2.2),
]


def build():
    img = Image.new("RGBA", (S, S), BASE + (255,))
    img.alpha_composite(glow((S, S), (600, 760), 760, BLUE, 84))

    for name, cx, cy, width, lean, facing, dim, blur in sorted(CROWD, key=lambda r: r[6], reverse=True):
        body = device(screen(name), width)
        if lean:
            body = stand(body, lean, facing)
        paste_centre(img, recede(body, dim, blur), (cx, cy))

    # The screens run up behind the name; this is what keeps the name readable
    # without hiding them behind a box.
    img.alpha_composite(shade((S, S), (600, 340), 680, 250))

    d = ImageDraw.Draw(img)
    m = marks()

    plate = fit(m["plate"], height=300)
    paste_centre(img, tint(plate, CYAN, 0.16), (600, 300))

    flop = fit(m["flop"], width=560)
    paste_centre(img, tint(flop, ICE, 1.0), (600, 268))

    f = ImageFont.truetype(MONO_B, 52)
    line = "PASSPORT FOR SEEKER"
    tw = spaced_width(d, line, f, tracking=10)
    spaced(d, (600 - tw / 2, 372), line, f, ICE, tracking=10)

    d.rectangle((600 - 70, 452, 600 + 70, 456), fill=CYAN)

    sub = ImageFont.truetype(MONO_R, 30)
    tag = "one signature, one identity"
    d.text((600 - d.textlength(tag, font=sub) / 2, 486), tag, font=sub, fill=(160, 182, 206))

    img.convert("RGB").save(os.path.join(OUT, "feature-1200x1200.png"))
    print("feature-1200x1200.png")


if __name__ == "__main__":
    build()
