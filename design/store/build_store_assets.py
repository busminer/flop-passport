"""Build the dApp Store showcase art from the one source of truth.

Everything here is derived from design/icon/flop-passport-icon.svg and the two
fonts the app itself ships, so the store art and the app cannot drift apart.

    python design/store/build_store_assets.py

Writes into design/store/:
    icon-512.png              the store icon
    banner-1200x600.png       the store banner
    banner-overlay-check.png  the banner with the store's own furniture drawn on
    feature-1200x1200.png     feature graphic, only used by the Editor's choice rail

Two measured facts drive the layout, both taken off a real Seeker rather than
assumed:

  * The store draws the banner one to one and then puts the status bar, a round
    back arrow, the app icon and a bottom fade on top of it. Only
    x 440-1170 by y 110-460 is safe for anything that has to be read.
  * The published SKR Eyes icon is a 512 PNG with the rounded square baked in
    and transparent corners, radius 110 of 512. We match it so the two apps sit
    together in a list.

The icon uses the whole 108dp canvas rather than the central 72dp the launcher
mask keeps. The ink box measures x 28.0-79.9, y 20.1-86.2, so nothing is ever
clipped either way; the full canvas simply carries the margins the neighbouring
icon has.
"""
import os
import re
import subprocess

from PIL import Image, ImageDraw, ImageFont

ROOT = os.path.abspath(os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", ".."))
OUT = os.path.join(ROOT, "design", "store")
SVG = os.path.join(ROOT, "design", "icon", "flop-passport-icon.svg")
FONTS = os.path.join(ROOT, "app", "src", "main", "res", "font")
MONO_B = os.path.join(FONTS, "space_mono_bold.ttf")
MONO_R = os.path.join(FONTS, "space_mono_regular.ttf")
INTER = os.path.join(FONTS, "inter_regular.ttf")
CHROME = r"C:\Program Files\Google\Chrome\Application\chrome.exe"
WORK = os.path.join(OUT, "_work")

BASE = (10, 17, 40)     # Base
CYAN = (0, 180, 216)    # FLOP Cyan
BLUE = (4, 102, 200)    # FLOP Blue
GREEN = (50, 215, 75)   # Electric Green
ICE = (245, 247, 250)   # Ice White
GREY = (92, 102, 112)   # FLOP Grey

RADIUS = 110 / 512      # measured off the published SKR Eyes icon
SAFE = (440, 110, 1170, 460)
DID = "did:key:z6Mkw1JAVEwLgronRpuuzvHTyiiUgdoQGqkHG8VXH847dqcJ"


# ---------------------------------------------------------------- rendering ---

def shoot(svg_doc, size, name):
    """Render an SVG string on a transparent ground and return it trimmed."""
    os.makedirs(WORK, exist_ok=True)
    page = os.path.join(WORK, f"{name}.html")
    open(page, "w", encoding="utf-8").write(
        "<style>html,body{margin:0;padding:0;background:transparent}"
        "svg{display:block}</style>" + svg_doc
    )
    shot = os.path.join(WORK, f"{name}.png")
    if os.path.exists(shot):
        os.remove(shot)
    subprocess.run(
        [CHROME, "--headless=new", "--disable-gpu", "--hide-scrollbars",
         "--default-background-color=00000000", f"--window-size={size},{size}",
         f"--screenshot={shot}", "file:///" + page.replace("\\", "/")],
        check=True, capture_output=True,
    )
    return Image.open(shot).convert("RGBA")


def marks():
    """The three drawn elements, cut out as tight transparent images.

    Rendering each group alone and trimming by its own alpha beats redoing the
    transform arithmetic by hand: the bounding boxes come from the shapes.
    """
    svg = open(SVG, encoding="utf-8").read()
    groups = re.findall(r"<g transform=\"([^\"]+)\">(.*?)</g>", svg, re.S)
    assert len(groups) == 3, f"expected plate, FLOP and Seeker groups, got {len(groups)}"
    out = {}
    for name, (transform, inner), size in zip(("plate", "flop", "seeker"), groups, (2400, 4800, 4800)):
        doc = (f'<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 108 108" '
               f'width="{size}" height="{size}"><g transform="{transform}">{inner}</g></svg>')
        im = shoot(doc, size, f"mark_{name}")
        out[name] = im.crop(im.split()[3].getbbox())
    return out


# ------------------------------------------------------------------ helpers ---

def rounded(im, radius=RADIUS):
    n = im.size[0]
    m = Image.new("L", (n * 4, n * 4), 0)
    ImageDraw.Draw(m).rounded_rectangle((0, 0, n * 4 - 1, n * 4 - 1),
                                        radius=int(n * 4 * radius), fill=255)
    out = im.copy()
    out.putalpha(m.resize((n, n), Image.LANCZOS))
    return out


def glow(size, centre, radius, colour, peak):
    """A soft radial wash, built small and blown back up so it stays smooth."""
    s = 8
    small = Image.new("L", (size[0] // s, size[1] // s), 0)
    d = ImageDraw.Draw(small)
    cx, cy, r = centre[0] / s, centre[1] / s, radius / s
    steps = 44
    for i in range(steps, 0, -1):
        rr = r * i / steps
        d.ellipse((cx - rr, cy - rr, cx + rr, cy + rr), fill=int(peak * (1 - i / steps) ** 2))
    layer = Image.new("RGBA", size, colour + (0,))
    layer.putalpha(small.resize(size, Image.BICUBIC))
    return layer


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


def cut_card(d, box, cut, fill, edge):
    """A panel with its corners cut at 45 degrees, the way the Chip's are.

    Drawn edge by edge on purpose: a polygon outline rounds its joints, and the
    whole point of the shape is that the corners are cut, not curved.
    """
    x0, y0, x1, y1 = box
    pts = [(x0 + cut, y0), (x1 - cut, y0), (x1, y0 + cut), (x1, y1 - cut),
           (x1 - cut, y1), (x0 + cut, y1), (x0, y1 - cut), (x0, y0 + cut)]
    d.polygon(pts, fill=fill)
    for a, b in zip(pts, pts[1:] + pts[:1]):
        d.line([a, b], fill=edge, width=2)


def proof_card(d, box, title_size=13, mono_size=18, wrap=19):
    """The identity panel: a real did:key, split to fit, and the verified line."""
    x0, y0, x1, y1 = box
    cut_card(d, box, 15, (14, 25, 56, 255), (40, 62, 102, 255))
    d.text((x0 + 26, y0 + 26), "YOUR IDENTITY", font=ImageFont.truetype(MONO_B, title_size), fill=GREY)
    f = ImageFont.truetype(MONO_R, mono_size)
    for i in range(0, len(DID), wrap):
        d.text((x0 + 26, y0 + 56 + (i // wrap) * (mono_size + 9)), DID[i:i + wrap], font=f, fill=(126, 152, 178))
    d.text((x0 + 48, y1 - 40), "SIGNATURE VERIFIED", font=ImageFont.truetype(MONO_B, 15), fill=GREEN)
    d.line([(x0 + 26, y1 - 31), (x0 + 32, y1 - 25), (x0 + 42, y1 - 39)], fill=GREEN, width=3)


# -------------------------------------------------------------------- icon ---

def build_icon(_):
    svg = open(SVG, encoding="utf-8").read()
    full = shoot(f"<style>svg{{width:1080px;height:1080px}}</style>{svg}", 1080, "icon_full")
    rounded(full.resize((512, 512), Image.LANCZOS)).save(os.path.join(OUT, "icon-512.png"))
    print("icon-512.png")


# ------------------------------------------------------------------ banner ---

def build_banner(m):
    W, H = 1200, 600
    img = Image.new("RGBA", (W, H), BASE + (255,))

    # Left third carries texture only: this is where the store drops its own
    # furniture, so nothing that has to be read may live here.
    plate = fit(m["plate"], height=398)
    img.alpha_composite(glow((W, H), (190, 286), 430, BLUE, 62))
    img.alpha_composite(tint(plate, CYAN, 0.30),
                        (int(190 - plate.size[0] / 2), int(286 - plate.size[1] / 2)))
    img.alpha_composite(glow((W, H), (1010, 500), 500, BLUE, 26))

    d = ImageDraw.Draw(img)
    x0 = 470
    flop = fit(m["flop"], width=296)          # far above the 120px floor the brand sets
    img.alpha_composite(tint(flop, ICE, 1.0), (x0, 136))
    spaced(d, (x0 - 2, 224), "PASSPORT", ImageFont.truetype(MONO_B, 66), ICE, tracking=4)
    d.rectangle((x0, 322, x0 + 116, 324), fill=CYAN)

    body = ImageFont.truetype(INTER, 21)
    for i, line in enumerate(["One wallet signature becomes an identity",
                              "that any phone can bring back."]):
        d.text((x0, 348 + i * 30), line, font=body, fill=(200, 210, 222))

    d.text((x0, 428), "for", font=ImageFont.truetype(MONO_R, 17), fill=GREY)
    img.alpha_composite(tint(fit(m["seeker"], height=22), ICE, 0.92), (x0 + 40, 424))

    proof_card(d, (866, 136, 1170, 330))

    img.convert("RGB").save(os.path.join(OUT, "banner-1200x600.png"))
    print("banner-1200x600.png")

    # The same banner with the store's furniture drawn over it, so the safe zone
    # can be checked by eye instead of taken on trust.
    check = img.copy()
    p = ImageDraw.Draw(check, "RGBA")
    p.rectangle((0, 0, W, 100), fill=(255, 0, 0, 60))             # status bar
    p.ellipse((60, 194, 200, 331), outline=(255, 0, 0, 200), width=3)  # back arrow
    p.rectangle((64, 491, 414, 600), fill=(255, 0, 0, 60))        # app icon
    p.rectangle((0, 470, W, 599), outline=(255, 120, 0, 160), width=2)  # fade
    p.rectangle(SAFE, outline=GREEN + (220,), width=2)
    check.convert("RGB").save(os.path.join(OUT, "banner-overlay-check.png"))
    print("banner-overlay-check.png")


# ---------------------------------------------------------- feature graphic ---

def build_feature(m):
    S = 1200
    img = Image.new("RGBA", (S, S), BASE + (255,))
    img.alpha_composite(glow((S, S), (600, 470), 700, BLUE, 70))
    plate = fit(m["plate"], height=470)
    img.alpha_composite(tint(plate, CYAN, 0.92),
                        (int(600 - plate.size[0] / 2), int(300 - plate.size[1] / 2)))

    d = ImageDraw.Draw(img)
    flop = fit(m["flop"], width=470)
    img.alpha_composite(tint(flop, ICE, 1.0), (int(600 - flop.size[0] / 2), 600))
    f = ImageFont.truetype(MONO_B, 84)
    w = sum(d.textlength(c, font=f) + 6 for c in "PASSPORT") - 6
    spaced(d, (600 - w / 2, 720), "PASSPORT", f, ICE, tracking=6)

    body = ImageFont.truetype(INTER, 26)
    line = "One wallet signature becomes an identity that any phone can bring back."
    d.text((600 - d.textlength(line, font=body) / 2, 860), line, font=body, fill=(200, 210, 222))

    seeker = fit(m["seeker"], height=30)
    d.text((600 - (seeker.size[0] + 56) / 2, 936), "for", font=ImageFont.truetype(MONO_R, 22), fill=GREY)
    img.alpha_composite(tint(seeker, ICE, 0.92), (int(600 - (seeker.size[0] + 56) / 2 + 56), 932))

    proof_card(d, (424, 998, 776, 1148), mono_size=14, wrap=28)
    img.convert("RGB").save(os.path.join(OUT, "feature-1200x1200.png"))
    print("feature-1200x1200.png")


if __name__ == "__main__":
    os.makedirs(OUT, exist_ok=True)
    m = marks()
    build_icon(m)
    build_banner(m)
    build_feature(m)
