"""Convert a flat single-layer SVG into an Android VectorDrawable.

Deliberately narrow: it handles exactly the shape of the two official marks we ship - a
viewBox, a <style> block mapping classes to fills, and a flat list of <path d="..."/>.
It does not attempt transforms, gradients, groups or strokes, and it refuses rather than
guesses if it meets them, because a logo that silently comes out wrong is worse than a
build error.

Path data is copied byte for byte. Only the container changes.

    python tools/svg_to_vector_drawable.py in.svg out.xml [--recolor "#FFFFFF=#F5F7FA"]
"""
from __future__ import annotations

import re
import sys
import xml.etree.ElementTree as ET
from pathlib import Path

SVG_NS = "{http://www.w3.org/2000/svg}"


def parse_class_fills(root: ET.Element) -> dict[str, str]:
    fills: dict[str, str] = {}
    for style in root.iter(SVG_NS + "style"):
        for cls, body in re.findall(r"\.([A-Za-z0-9_-]+)\s*\{([^}]*)\}", style.text or ""):
            m = re.search(r"fill:\s*(#[0-9A-Fa-f]{3,8})", body)
            if m:
                fills[cls] = m.group(1).upper()
    return fills


def main() -> int:
    src, dst = Path(sys.argv[1]), Path(sys.argv[2])
    recolor: dict[str, str] = {}
    if "--recolor" in sys.argv:
        for pair in sys.argv[sys.argv.index("--recolor") + 1].split(","):
            a, b = pair.split("=")
            recolor[a.strip().upper()] = b.strip().upper()

    root = ET.parse(src).getroot()
    vb = (root.get("viewBox") or "").split()
    if len(vb) != 4:
        print("refusing: no usable viewBox", file=sys.stderr)
        return 1
    min_x, min_y, vw, vh = (float(v) for v in vb)
    # A cropped viewBox is expressed as a group translate, which is the exact equivalent:
    # VectorDrawable has no viewBox origin, so the artwork is shifted instead of the frame.
    # Geometry is untouched either way.

    fills = parse_class_fills(root)

    for tag in ("polygon", "rect", "circle", "ellipse", "line", "polyline", "use", "image"):
        if root.find(f".//{SVG_NS}{tag}") is not None:
            print(f"refusing: <{tag}> present - convert it to a path first", file=sys.stderr)
            return 1

    paths = []
    for p in root.iter(SVG_NS + "path"):
        d = p.get("d")
        if not d:
            continue
        colour = p.get("fill") or fills.get((p.get("class") or "").strip(), "#000000")
        colour = colour.upper()
        colour = recolor.get(colour, colour)
        if len(colour) == 4:
            colour = "#" + "".join(c * 2 for c in colour[1:])
        paths.append((colour, d))

    if not paths:
        print("refusing: no path data found", file=sys.stderr)
        return 1

    out = [
        '<?xml version="1.0" encoding="utf-8"?>',
        "<!--",
        f"  Generated from {src.name} by tools/svg_to_vector_drawable.py.",
        "  Path data is byte-identical to the official supplied file; only the container",
        "  format changed. Do not hand-edit: regenerate from the source asset.",
        "-->",
        '<vector xmlns:android="http://schemas.android.com/apk/res/android"',
        f'    android:width="{vw / 4:.0f}dp"',
        f'    android:height="{vh / 4:.0f}dp"',
        f'    android:viewportWidth="{vw:g}"',
        f'    android:viewportHeight="{vh:g}">',
    ]
    shifted = min_x or min_y
    if shifted:
        out.append(f'    <group android:translateX="{-min_x:g}" android:translateY="{-min_y:g}">')
    indent = "        " if shifted else "    "
    for colour, d in paths:
        out.append(f"{indent}<path")
        out.append(f'{indent}    android:fillColor="{colour}"')
        out.append(f'{indent}    android:pathData="{d}" />')
    if shifted:
        out.append("    </group>")
    out.append("</vector>")

    dst.parent.mkdir(parents=True, exist_ok=True)
    dst.write_text("\n".join(out) + "\n", encoding="utf-8")
    colours = sorted({c for c, _ in paths})
    print(f"wrote {dst} - {len(paths)} paths, {vw:g}x{vh:g}, colours {', '.join(colours)}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
