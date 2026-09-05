"""Turn raw Seeker captures into the four store screenshots.

    adb shell screencap -p /sdcard/x.png && adb pull /sdcard/x.png design/store/raw/01-passport.png
    python design/store/build_screenshots.py

Reads design/store/raw/*.png in name order and writes
design/store/screenshot-1.png .. screenshot-4.png, all 1080x1920.

Why any processing at all, rather than shipping the captures:

  * The Seeker's screen is 1200x2670, which is 9:20. The store wants every
    screenshot in one aspect ratio, and SKR Eyes shipped 9:16 at 1080x1920, so
    the two listings should match. Scaling 9:20 into 9:16 would stretch every
    letter; cropping to it would cut a third of the screen away. So the capture
    is scaled to fit and centred on the app's own background colour, which
    reads as deliberate rather than as a mistake because it is the same colour
    the screen it sits in is painted with.

  * The system status bar goes. It carries whatever notification icons the
    builder's phone happened to be showing, the clock, and the battery level -
    none of it is the app, and all of it dates the screenshot. The gesture pill
    at the very bottom goes for the same reason. The app's own bottom bar
    stays: it is part of the product.

The crop is in device pixels and was measured on this Seeker, not guessed: the
status bar ends at y=90 and the gesture pill occupies the last 58 rows.
"""
import os
import sys

from PIL import Image

ROOT = os.path.abspath(os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", ".."))
OUT = os.path.join(ROOT, "design", "store")
RAW = os.path.join(OUT, "raw")

# The app's own Base colour, from ui/designsystem/FlopColors.kt.
BASE = (0x0A, 0x11, 0x28)

TARGET = (1080, 1920)
STATUS_BAR_PX = 90
GESTURE_PILL_PX = 58


def compose(path):
    shot = Image.open(path).convert("RGB")
    w, h = shot.size
    shot = shot.crop((0, STATUS_BAR_PX, w, h - GESTURE_PILL_PX))

    scale = min(TARGET[0] / shot.width, TARGET[1] / shot.height)
    fitted = shot.resize(
        (round(shot.width * scale), round(shot.height * scale)), Image.LANCZOS,
    )
    canvas = Image.new("RGB", TARGET, BASE)
    canvas.paste(fitted, ((TARGET[0] - fitted.width) // 2, (TARGET[1] - fitted.height) // 2))
    return canvas


def main():
    if not os.path.isdir(RAW):
        sys.exit("no captures: put them in " + RAW)
    shots = sorted(f for f in os.listdir(RAW) if f.lower().endswith(".png"))
    if len(shots) < 4:
        sys.exit("the store wants at least four screenshots, found " + str(len(shots)))
    for i, name in enumerate(shots, start=1):
        out = os.path.join(OUT, "screenshot-" + str(i) + ".png")
        compose(os.path.join(RAW, name)).save(out)
        print(os.path.basename(out), "<-", name)


if __name__ == "__main__":
    main()
