"""Build the store banner out of real screens standing behind the name.

    python design/store/build_banner.py

Writes design/store/banner-1200x600.png and, beside it, banner-overlay-check.png
with the store's own furniture drawn on top so the safe zone can be checked by
eye instead of taken on trust.

The idea, in one line: the name stands in front and the app stands behind it,
receding to both sides, so a person sees what the thing looks like before they
read a word about it.

Two measured constraints shape the layout, both taken off a real Seeker:

  * The store draws the banner one to one and then lays its status bar, a round
    back arrow, the app icon and a bottom fade over it. Only x 440-1170 by
    y 110-460 survives. So the centre of the composition is x 805, not 600 -
    "centred" here means centred in what a person actually sees, and the phones
    that fall in the covered third are there as texture, nothing else.

  * Every screen is a capture from the phone. Nothing here is a mockup, so the
    art cannot promise a screen the app does not have.
"""
import os

from PIL import Image, ImageDraw, ImageFont

from build_store_assets import marks
from showcase import (
    BASE, BLUE, CYAN, GREY, ICE, MONO_B, MONO_R, OUT,
    device, fit, glow, paste_centre, recede, shade, spaced, spaced_width, stand, screen, tint,
)

W, H = 1200, 600
SAFE = (440, 110, 1170, 460)
MID = ((SAFE[0] + SAFE[2]) // 2, (SAFE[1] + SAFE[3]) // 2)   # 805, 285

# Which capture stands where. Far from the middle means smaller, dimmer, softer
# and turned harder toward the viewer's centre - the four things that read as
# distance without drawing a single perspective line.
#
#   name, centre x, centre y, width, lean, facing, dim, blur
CROWD = [
    ("06-languages.png", 88, 302, 166, 0.33, "right", 0.70, 2.0),
    ("04-activity.png", 268, 298, 196, 0.27, "right", 0.56, 1.2),
    ("03-done.png", 440, 292, 230, 0.20, "right", 0.40, 0.5),
    ("05-seedvault.png", 805, 286, 270, 0.00, "right", 0.76, 2.6),
    ("01-identity.png", 1170, 292, 230, 0.20, "left", 0.38, 0.5),
]


def build():
    img = Image.new("RGBA", (W, H), BASE + (255,))
    img.alpha_composite(glow((W, H), (805, 300), 620, BLUE, 78))
    img.alpha_composite(glow((W, H), (170, 330), 460, BLUE, 44))

    # Back to front, so the near screens overlap the far ones rather than the
    # other way round.
    for name, cx, cy, width, lean, facing, dim, blur in sorted(CROWD, key=lambda r: r[6], reverse=True):
        body = device(screen(name), width)
        if lean:
            body = stand(body, lean, facing)
        paste_centre(img, recede(body, dim, blur), (cx, cy))

    # The screens are busy and the name has to win. A wash of the background
    # colour, not a black box: the phones stay visible through it.
    img.alpha_composite(shade((W, H), MID, 460, 236))
    img.alpha_composite(glow((W, H), MID, 300, BLUE, 44))

    d = ImageDraw.Draw(img)
    m = marks()

    flop = fit(m["flop"], width=304)
    paste_centre(img, tint(flop, ICE, 1.0), (MID[0], 218))

    f = ImageFont.truetype(MONO_B, 30)
    line = "PASSPORT FOR SEEKER"
    tw = spaced_width(d, line, f, tracking=6)
    spaced(d, (MID[0] - tw / 2, 280), line, f, ICE, tracking=6)

    d.rectangle((MID[0] - 58, 336, MID[0] + 58, 338), fill=CYAN)

    sub = ImageFont.truetype(MONO_R, 21)
    tag = "one signature, one identity"
    d.text((MID[0] - d.textlength(tag, font=sub) / 2, 362), tag, font=sub, fill=(154, 176, 200))

    img.convert("RGB").save(os.path.join(OUT, "banner-1200x600.png"))
    print("banner-1200x600.png")

    check = img.copy()
    p = ImageDraw.Draw(check, "RGBA")
    p.rectangle((0, 0, W, 100), fill=(255, 0, 0, 60))
    p.ellipse((60, 194, 200, 331), outline=(255, 0, 0, 200), width=3)
    p.rectangle((64, 491, 414, 600), fill=(255, 0, 0, 60))
    p.rectangle((0, 470, W, 599), outline=(255, 120, 0, 160), width=2)
    p.rectangle(SAFE, outline=(50, 215, 75, 220), width=2)
    check.convert("RGB").save(os.path.join(OUT, "banner-overlay-check.png"))
    print("banner-overlay-check.png")


if __name__ == "__main__":
    build()
