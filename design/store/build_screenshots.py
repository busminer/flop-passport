"""Turn raw Seeker captures into the store previews, each with a line of help.

    adb shell "screencap -p /sdcard/x.png"
    adb pull /sdcard/x.png design/store/raw/01-identity.png
    python design/store/build_screenshots.py

Reads design/store/raw/*.png in name order and writes screenshot-1.png upward,
all 1080x1920, which is the shape SKR Eyes shipped and the shape the store wants
every preview in one listing to share.

Why there is writing on them at all: a person swiping a store listing has about
a second per image and no idea yet what a did:key is, or why a green tick here
is worth more than a green tick anywhere else. A bare capture makes them work it
out on their own. A line above it tells them, and the screen underneath proves
it.

Why the screen is not stretched to fill: the Seeker's display is 9:20 and the
store wants 9:16. Squeezing it would distort every letter and cropping to it
would throw away a third of the screen. So the capture keeps its own shape,
stands in a body of its own, and the room that leaves at the top carries the
writing instead of going to waste.

The system status bar and the gesture pill are cropped off. They carry the
builder's notification icons, clock and battery level, none of which is the app.
"""
import os
import sys
import textwrap

from PIL import Image, ImageDraw, ImageFont

from showcase import (
    BASE, BLUE, CYAN, ICE, INTER, MONO_B, OUT, RAW,
    device, glow, screen, spaced,
)

W, H = 1080, 1920
MARGIN = 84
SHOT_WIDTH = 600

# What each capture is for, in the order they are shown. The head is the claim,
# the note underneath is the part that stops it being a slogan.
CAPTIONS = {
    "01-today.png": (
        "YOUR DAY ON FLOP",
        ["Sign. Collect. Ask.", "One button a day."],
        "Your streak, your FLOP and today's question on one screen. Devnet FLOP "
        "is for practice: it has no price.",
    ),
    "02-window.png": (
        "ALWAYS LIVE",
        ["You always see", "what is happening."],
        "Every job runs in its own window: what the app is doing, which try, the "
        "ping. Minimise it and it keeps going.",
    ),
    "03-knock.png": (
        "IS THE MODEL BUSY?",
        ["Knock yourself.", "Keep trying."],
        "When FLOP's gateway is full, a refusal costs nothing. Wait for the timer "
        "or knock again right away.",
    ),
    "04-passport.png": (
        "ONE KEY, TWO NETWORKS",
        ["Your Seeker wallet.", "Your FLOP account."],
        "One signature makes your Passport. The same wallet brings it back on "
        "any phone, with no new seed phrase.",
    ),
    "05-pulse.png": (
        "PULSE",
        ["See who is here", "and how FLOP is doing."],
        "Live numbers anyone can repeat, thanks to both sides, and a check for "
        "links people send you.",
    ),
    "06-back.png": (
        "IT COMES BACK",
        ["Delete the app.", "Keep your streak."],
        "Your history lives on a public record. The same wallet finds it again, "
        "so there is nothing new to back up.",
    ),
}


def compose(name):
    img = Image.new("RGBA", (W, H), BASE + (255,))
    img.alpha_composite(glow((W, H), (540, 1180), 900, BLUE, 66))
    d = ImageDraw.Draw(img)

    label, head, note = CAPTIONS[name]

    spaced(d, (MARGIN, 108), label, ImageFont.truetype(MONO_B, 26), CYAN, tracking=5)

    f_head = ImageFont.truetype(MONO_B, 52)
    y = 168
    for line in head:
        d.text((MARGIN, y), line, font=f_head, fill=ICE)
        y += 68

    d.rectangle((MARGIN, y + 20, MARGIN + 96, y + 23), fill=CYAN)

    f_note = ImageFont.truetype(INTER, 27)
    y += 58
    for line in textwrap.wrap(note, width=52):
        d.text((MARGIN, y), line, font=f_note, fill=(158, 178, 200))
        y += 38

    body = device(screen(name), SHOT_WIDTH)
    top = H - 96 - body.height
    if top < y + 36:
        raise SystemExit(f"{name}: the writing and the screen collide, shorten the note")
    img.alpha_composite(glow((W, H), (540, top + body.height // 2), 620, BLUE, 46))
    img.alpha_composite(body, ((W - body.width) // 2, top))
    return img.convert("RGB")


def main():
    if not os.path.isdir(RAW):
        sys.exit("no captures: put them in " + RAW)
    shots = sorted(f for f in os.listdir(RAW) if f.lower().endswith(".png"))
    if len(shots) < 4:
        sys.exit("the store wants at least four previews, found " + str(len(shots)))
    missing = [s for s in shots if s not in CAPTIONS]
    if missing:
        sys.exit("no caption written for: " + ", ".join(missing))
    for i, name in enumerate(shots, start=1):
        out = os.path.join(OUT, f"screenshot-{i}.png")
        compose(name).save(out)
        print(os.path.basename(out), "<-", name)


if __name__ == "__main__":
    main()
