---
version: alpha
name: FLOP Network
description: Mascot V3.0 design system for FLOP Network — a computational-architecture brand for the verification layer for AI inference. Pixel-grid FLOP word mark + octagonal Chip icon + robot-rabbit mascot, FLOP Cyan primary on Base deep-navy, Electric Green verified, FLOP Blue fills, Space Mono voice. Dark-primary; Ice White light theme supported. Logo construction, lockups, clear space and minimum sizes are governed by the V1.0 logo standard (docs/brand/) — see Logo & Lockups.
colors:
  # --- DARK THEME (primary / default for all digital product UI) ---
  primary: "#00B4D8"          # FLOP Cyan (ACCENT) — primary signal: headlines, logo, key CTAs, links, brand moments
  primary-hover: "#3DC5E0"    # Derived — brighter cyan for hover/active (9.1:1 on Base)
  background: "#0A1128"       # Base — primary digital bg (the deep-navy substrate)
  surface: "#151D32"          # Derived — cards, panels, elevated surfaces
  surface-light: "#232A3E"    # Derived — borders, dividers, hover lift
  text-primary: "#F5F7FA"     # Ice White — primary text on dark (17.4:1 AAA)
  text-secondary: "#A1A7AE"   # Derived from Grey — secondary text, labels, metadata (7.7:1 AAA)
  border: "#232A3E"
  secondary: "#0466C8"        # FLOP Blue — secondary brand / fills / chart series (NOT body or link text on dark)
  # --- LIGHT THEME (supported, secondary — "ice") ---
  background-alt: "#F5F7FA"   # Ice White — light bg
  surface-alt: "#FFFFFF"      # Card lift on Ice (define with Mist border, not contrast)
  text-primary-alt: "#0A1128" # Base on Ice (17.4:1 AAA)
  text-secondary-alt: "#5C6670" # Grey on Ice (5.5:1 AA) — canonical swatch, no derivation
  border-alt: "#D9DDE1"       # Derived Mist — borders/dividers on light
  # --- Canonical Mascot V3.0 names (exact refs / prose alignment) ---
  base: "#0A1128"
  grey: "#5C6670"
  blue: "#0466C8"
  accent: "#00B4D8"
  electric-green: "#32D74B"
  ice-white: "#F5F7FA"
  red: "#FF453A"              # Error Red — Apple systemRed (dark), sibling of Electric Green
  white: "#FFFFFF"
  # --- Data-viz categorical series (aliases of existing swatches, no new hues) ---
  # A limited brand palette does not supply enough categorical colours on its own,
  # which is why chart code kept reaching for off-palette Material hues. These four
  # are the in-palette set that stays mutually distinguishable on the Base ground.
  # Series only — chart-3/chart-4 are fills, never text on Base (see contrast rules).
  chart-1: "#00B4D8"          # FLOP Cyan
  chart-2: "#32D74B"          # Electric Green
  chart-3: "#0466C8"          # FLOP Blue
  chart-4: "#A1A7AE"          # Derived grey
  # --- Semantic status aliases (palette only; red is semantic-only — see Colors) ---
  success: "#32D74B"          # Verified / positive — Electric Green (9.8:1 AAA on Base, text-safe)
  link: "#00B4D8"             # Links — FLOP Cyan on dark (7.6:1 AAA); use FLOP Blue #0466C8 on Ice
  warning: "#0466C8"          # Caution / attention — FLOP Blue as a FILL with Ice White text (5.6:1 AA); never blue text on Base
  error: "#FF453A"            # Error Red — operational failure only (5.5:1 AA on Base); never decorative
  accent-cyan: "#00B4D8"      # FLOP Cyan accent alias
  accent-green: "#32D74B"     # Electric Green — verified states / data-viz
  accent-blue: "#0466C8"      # FLOP Blue — fills / large-display / data-viz on dark
  accent-red: "#FF453A"       # Error Red alias
typography:
  h1:
    fontFamily: Space Mono
    fontSize: 32px
    fontWeight: 700
    lineHeight: 1.1
  h2:
    fontFamily: Space Mono
    fontSize: 24px
    fontWeight: 700
    lineHeight: 1.2
  h3:
    fontFamily: Space Mono
    fontSize: 18px
    fontWeight: 700
    lineHeight: 1.3
  body-md:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: 400
    lineHeight: 1.5
  body-sm:
    fontFamily: Inter
    fontSize: 12px
    fontWeight: 400
    lineHeight: 1.4
  label:
    fontFamily: Space Mono
    fontSize: 12px
    fontWeight: 400
    lineHeight: 1
  code:
    fontFamily: Space Mono
    fontSize: 13px
    fontWeight: 400
    lineHeight: 1.4
  # PDF-inspired small mono for brand precision
rounded:
  none: 0px
  sm: 2px
  md: 4px
  lg: 8px
  full: 9999px
spacing:
  xs: 4px
  sm: 8px
  md: 16px
  lg: 24px
  xl: 32px
components:
  button-primary:
    backgroundColor: "{colors.accent}"
    textColor: "{colors.base}"
    rounded: "{rounded.md}"
    padding: "{spacing.md}"
  button-primary-hover:
    backgroundColor: "#3DC5E0"
  button-secondary:
    backgroundColor: "{colors.surface}"
    textColor: "{colors.text-primary}"
    rounded: "{rounded.md}"
  button-ghost:
    backgroundColor: transparent
    textColor: "{colors.text-secondary}"
  card:
    backgroundColor: "{colors.surface}"
    rounded: "{rounded.md}"
    padding: "{spacing.md}"
  badge:
    rounded: "{rounded.full}"
    padding: "{spacing.sm}"
  input:
    backgroundColor: "{colors.surface}"
    textColor: "{colors.text-primary}"
    rounded: "{rounded.md}"
    padding: "{spacing.sm}"
    # focus ring uses primary (FLOP Cyan) per prose; border via surface-light in impl
---

## Overview

**FLOP Network** embodies the aesthetic of **Computational Architecture** — a design language built on a **precise pixel-grid** derived from the visual language of computer circuitry: precision, connectivity, and computational intelligence. The FLOP **word mark** is a single drawing of four characters built from one square **block** module laid on a grid — clean, engineered, unified with the icon. The **Chip** is the octagon standing in for the O and our primary icon: eight modules square, corners cut at 45°, with one block-sized **aperture** knocked out of the centre that stays open and empty — the unit of agent-to-agent inference. The **O of FLOP is the Chip itself**, and word mark and Chip are one object that is never separated. High contrast, zero decoration; every element is intentional, solid, and grid-aligned. The machine is the art — order and precision over noise (GRID-EXACT + HIGH SIGNAL).

*("Chip" is the canonical term as of the V1.0 logo standard; earlier revisions of these docs called it the "die-tile mark". Same geometry, one name.)*

The system has one warm counterpoint: the **FLOP mascot** (Mascot V3.0) — a compact robot rabbit whose long floppy ears are the literal pun on FLOP, and whose chest medallion **is the Chip**. The mascot carries approachability; the grid carries authority. They meet at the Chip: the same geometry that forms the O of FLOP hangs on the mascot's chest. Never let the mascot's softness leak into UI geometry — chrome, panels, and controls stay foundry-precise (see Shapes).

Every visual decision reinforces the core proposition: this is where AI inference becomes provable — settled in the literal unit of compute (FLOP = floating-point operations). The palette is confident and technical: a **Base** deep-navy substrate, **FLOP Cyan** the primary signal, **Electric Green** for verified truth, and **FLOP Blue** for structural fills. Mascot V3.0 revised the colour system specifically **to improve visibility against dark backgrounds** — developer environments are dark, and the brand must survive there. The interface rewards attention rather than demanding it. It favors functional beauty over flash or ornamentation (HIGH CONTRAST + FOUNDRY PRECISION). Dark-substrate default for all digital product UI; an **Ice White** light theme is supported for print, docs, and light surfaces.

Audience: developers, researchers, protocol engineers, and autonomous agents building on verified inference. DESIGN.md is the persistent source of truth (YAML tokens + evocative rationale) so agents (Stitch, Grok, etc.) generate UIs that match exactly. Cross-reference brand guidelines (docs/brand/) for mascot rules; **logo rules are mandatory and live in Logo & Lockups below** (4X clear space, 120px logotype / 24px Chip minimum; Base #0A1128 or Ice White #F5F7FA substrates only).

## Colors

A strictly limited palette from the **Mascot V3.0** study (`docs/brand/flop_mascot_design_v3.pdf`). High contrast, zero decoration — every colour carries a function. The six swatches are canonical and travel as one system; the two mascot colourways (Cyan and Electric Green) are finishes *within* that system, not alternative palettes.

**Brand palette (canonical V3.0 swatches):**

- **Base (#0A1128):** Foundational deep-navy substrate — the ground on which all signal emerges. Primary canvas for digital product UI. (RGB 10, 17, 40)
- **Grey (#5C6670):** Structural neutral — muted UI chrome, dividers, disabled states on dark; **secondary text on Ice White**. Not text-safe on Base (see contrast rules). (RGB 92, 102, 112)
- **FLOP Blue (#0466C8):** Structural brand blue — fills, chart series, large-display on dark; **the text/link colour on Ice White**. Not text-safe on Base. (RGB 4, 102, 200)
- **FLOP Cyan (#00B4D8):** The primary accent — the confident brand signal. Headlines, **the Chip**, key CTAs, links, brand moments. The mascot's eyes, visor, and primary body finish. It is the Chip's colour and never the word mark's (see Logo & Lockups). (RGB 0, 180, 216)
- **Electric Green (#32D74B):** Verified / positive — the proof-settled signal, and the mascot's second colourway. Text-safe on Base. (RGB 50, 215, 75)
- **Ice White (#F5F7FA):** Primary text on dark grounds; the light-theme substrate and print ground. (RGB 245, 247, 250)
- **Error Red (#FF453A):** Operational failure only — Apple's systemRed (dark). Text-safe on Base at 5.5:1 AA. Never decorative, never a large fill, never the sole signal. (RGB 255, 69, 58)

Five **derived** tokens extend the six swatches where the palette alone cannot carry a UI role — each is a straight mix of two canonical swatches, listed in the frontmatter and marked `Derived`: `surface` (#151D32) and `surface-light`/`border` (#232A3E) lift Base toward Grey for tonal depth; `text-secondary` (#A1A7AE) lifts Grey toward Ice White to reach AAA as body text on dark; `primary-hover` (#3DC5E0) lifts Cyan toward Ice White; `border-alt` (#D9DDE1) darkens Ice White toward Grey. Nothing else.

**On red.** The system carries exactly one red — **Error Red #FF453A**, Apple's systemRed (dark) — and it is **semantic only**. It marks operational failure: a failed transaction, a slashing event, a rejected proof, an unreachable service. It is never decorative, never a large fill, and never a brand accent. The earlier rule was that the palette had no red at all; that held while the brand had no operational surface, and stopped holding once it did — the explorer's error states resolved to the same value as body text, which is to say they were invisible. Electric Green is Apple's systemGreen (dark), so systemRed is its designed sibling rather than an invented hue.

**Caveat on the data-viz ramp.** The four chart colours are drawn from a deliberately narrow palette, so they do not all separate under colour blindness: measured pairwise, `chart-1`/`chart-2` collapse to 1.27 and `chart-2`/`chart-4` to 1.18 for deuteranopia and protanopia (1.00 = identical). Today every chart in the repo plots a **single** labelled series, so colour there is decorative and nothing is lost. Before putting two or more series on one chart, give them a non-colour encoding as well — dash pattern, point shape, or direct labels — because the ramp alone will not carry the distinction (WCAG 1.4.1).

**Red is never the only signal.** Roughly 8% of men cannot separate red from green, so every error state pairs the colour with an icon or a label that survives without it (WCAG 1.4.1). Where a pair is purely directional rather than an error — a value moving up versus down — prefer **Ice White against Electric Green** over red/green: it is the more legible pair for dichromats and carries no failure connotation.

**WCAG Contrast Ratios (measured against the canonical swatches — usage rules below follow directly):**

*Dark theme (primary), on Base #0A1128:*

- #F5F7FA Ice White : **17.4 : 1 AAA** — primary text
- #32D74B Electric Green : **9.8 : 1 AAA** — verified/success, text-safe at all sizes
- #A1A7AE Derived Grey : **7.7 : 1 AAA** — secondary text, labels
- #00B4D8 FLOP Cyan : **7.6 : 1 AAA** — text-safe primary accent (links, headlines, CTAs) at all sizes
- #FF453A Error Red : **5.5 : 1 AA** — operational failure at all text sizes; pair with an icon or label
- #0466C8 FLOP Blue : **3.3 : 1** — **fills and large display only; never body or link text on Base** (place Ice White text *on* the blue fill instead — 5.6:1 AA)
- #5C6670 Grey : **3.2 : 1** — **non-text only**: dividers, borders, disabled chrome

*Light theme (supported), on Ice White #F5F7FA:*

- #0A1128 Base : **17.4 : 1 AAA** — primary text
- #5C6670 Grey : **5.5 : 1 AA** — secondary text
- #0466C8 FLOP Blue : **5.2 : 1 AA** — text and links on Ice White
- #FF453A Error Red : **3.2 : 1** — **large text only on Ice White** (AA-large); for body-size error text on a light ground use Base with an icon, or place Ice White text on a red fill
- #00B4D8 FLOP Cyan : **2.3 : 1** and #32D74B Electric Green : **1.8 : 1** — **fills / large-display only; never as text on Ice White** (place Base text *on* the fill instead)

The two themes invert which swatches carry text: **on dark, Cyan and Green are the text-safe signals and Blue/Grey are structure; on light, Blue and Grey are the text-safe signals and Cyan/Green are fills.** This is the single most important colour rule in the system.

**On caution states:** the palette has no dedicated *caution* hue — Cyan is the primary signal, Green is success, and Red is reserved for outright failure. Rather than invent one, `warning` is a **FLOP Blue fill with Ice White text** — structurally distinct from both the cyan primary and the green success signal, and carried by placement and icon rather than by an off-palette colour. Never render it as blue text on Base.

## Typography

Two fonts. One system. Monospace for brand voice — sans-serif for clarity. (Unchanged by V3.0 — the mascot study respecifies colour and character, not type; the foundry voice is still terminal-dense and grid-aligned.)

**Primary Typeface — Display & Brand:** Space Mono (Colophon Foundry, Open Font License).

- Regular (400): Body copy, captions, UI labels
- Bold (700): Headlines, callouts, navigation

**Secondary Typeface — Body & UI:** Inter (Rasmus Andersson, Open Font License).

**Type Scale** (sourced from brand guidelines; UI implementations scale for readability while preserving monospace density and precision intent):

- Hero / Cover: Space Mono Bold ~28pt
- Page Heading: Space Mono Bold 18pt (24px)
- Section Heading: Space Mono Bold 12pt (18px)
- Body Copy: Inter 9pt (14px)
- Caption / Label: Space Mono 7pt (12px)

Use Space Mono for headlines, navigation, data (addresses, hashes, signatures), labels, and code. Use Inter for body prose and general UI text.

## Logo & Lockups

Governed by **FLOP Logo & Usage Standards V1.0** (2026-07-29 — the PDF is Drive-hosted, see `docs/brand/DRIVE_ASSETS.md`). These rules are mandatory, and the standard's closing rule is the one to internalise: **anything not shown in it is unapproved — ask before improvising.**

**Use the supplied files.** The word mark must **never** be redrawn, retraced, rebuilt from squares, or re-exported from a screenshot, slide or PDF. The masters live in `docs/brand/official/` and are used byte-for-byte. Gutters, corner cuts, and letter spacing are not adjustable — the proportions in the file *are* the logo. (This retires `gen_flop_1a_logo.py` as a source of truth; see `docs/brand/official/README.md`.)

**Construction.** Everything sits on one grid. Each block is a rounded square set on a module 10% wider than itself, so a hairline gutter always shows between blocks. Cap height is eight modules. The Chip is eight modules square with its corners cut at 45° and one block-sized aperture at the centre. The aperture always shows the ground behind it — never fill it, never put a letter, dot or image in it.

**Clear space: 4X**, where **X is one grid module** — the block the letters are built from. The logo holds 4X of empty space on every side, measured **from the artwork, not the file's bounding box**. Nothing enters it: not type, not a rule, not a fold, not the trim or the edge of the sheet. 4X is a minimum, not a target — give it more room whenever you can.

**Minimum sizes.** Logotype **120 px / 32 mm** wide; Chip **24 px / 8 mm**. Below 200 px always use the One-color version. Below 24 px the aperture closes and the octagon reads as a blob — use a hand-tuned 16 px favicon only where a platform demands one.

**Approved lockups — there are no others:**

| Lockup | Word mark | Chip | Where |
|---|---|---|---|
| **Primary** | Base | Accent | Ice White or paper. **The default in every medium** |
| **Reverse** | Ice White | Accent | On Base **only** — never on Blue, Grey or a photograph |
| **Print alternate** | Base | Blue | Single-pass print where Accent shifts |
| **Product** | Base | Electric Green | Product surfaces and internal tooling **only** — never print or outgoing work |
| **One-color** | Base *or* Ice White | same | Engraving, emboss, foil, single-ink, stitching, laser etch, anything under 200 px |

**The one colour rule for the logo:** the **word mark takes the neutral that contrasts the ground — Base on light, Ice White on dark — and no other colour ever. The Chip carries the colour.** Never swap that relationship, never put three inks in one lockup, never mix Accent and Electric Green, and never set a two-tone lockup on a ground other than Base.

One-color restrictions: **Accent on Ice White is never approved** (it fails contrast at every size). Accent on Base is screen-only and only at ≥200 px. Blue on Ice White is single-ink print only. Grey is permitted for blind emboss, deboss and etch — where the colour comes from the material rather than the ink — and is **never used on screen**. **Never invert the artwork yourself**: reversed lockups are supplied files, not a positive run through an invert or `brightness(0)` filter.

**Chip placement.** In a square box at **76–80% of the box width**, optically centred. Do not crop it to the edge. Do not round its corners further, and do not mask it into a circle or squircle — the platform applies its own mask and we do not pre-empt it. Never use the Chip as a frame, bullet, pattern tile, or container for other content.

**Misuse — none of this may ship:** stretching, condensing or uneven scaling; rotation or angling; shadow, glow, bevel or outline; two accents or a coloured word mark; swapping the colours so the word mark carries the colour; a background the colour cannot hold against; mirroring, flipping, or animating the artwork as anything other than a whole; reduced opacity as a watermark; cropping to a corner; adding a tagline, department name, product name or year to the lockup; re-exporting from a screenshot or slide.

A tagline may sit on the same page as the logo — it just may not be **locked to** it. Keep it outside the 4X clear space and visually independent.

**Two of these colour rules are logo-scoped and do not restrict the UI.** V1.0 talks about ink in a lockup; the Colors section talks about pixels in a product. **Electric Green** appears in a lockup only in the product lockup, but remains the live/verified/successful state throughout the interface. **Accent** is V1.0's *"one spot color used small and rarely"* — a print-economy instruction about a spot ink and about the Chip being the only place colour lands in the logo, **not** a cap on FLOP Cyan as the primary UI accent.

**Delivered artwork drifts from the specified hex.** The standard states the palette as hex and requires matching by value, not by eye. The delivered SVGs came back through a CMYK round-trip and disagree — including two different Base values in one delivery. **The palette above is authoritative; the drift is a delivery defect, not a palette revision.** Use the supplied files unaltered, but set surrounding page colour from the spec hex. Measured table and re-runnable check: `docs/brand/official/README.md`, `scripts/check_brand_colors.py`.

## Mascot

The **FLOP mascot** is a compact robot rabbit — the brand's one approachable surface, introduced in Mascot V3.0 (`docs/brand/flop_mascot_design_v3.pdf`). It exists to make a verification protocol legible and likeable to developers without diluting the foundry precision of the wordmark.

**Anatomy (fixed — do not redraw):**

- **Ears:** long, soft, floppy — the literal pun on FLOP. They fall outside the head silhouette and read at small sizes. The ears are the recognition asset.
- **Helmet:** a chrome/silver crown cap with a vertical **FLOP Cyan** oval visor indicator at the brow.
- **Face:** a glossy near-black dome (Base, deepened) carrying two **FLOP Cyan** oval eyes and a small cyan `w` smile. The face is a screen, not skin — it emits, it does not express.
- **Medallion:** the **Chip** worn on the chest — the octagon with its centre aperture, in a chrome frame. **This is the FLOP icon.** It is the same geometry as the O of FLOP. It is not decoration and must never be replaced with another emblem.
- **Paws / feet:** glossy dark tips, Base-deepened.

**Colourways (both canonical):**

| Colourway | Body | Use |
|---|---|---|
| **Cyan** (primary) | FLOP Cyan #00B4D8 | Default. Pairs with the primary UI signal; the on-brand choice for product, docs, and web. |
| **Electric Green** | Electric Green #32D74B | Verified/celebration contexts, proof-settled moments, secondary campaigns. |

Both colourways were drawn specifically to **hold up on dark backgrounds** — that is the stated purpose of the V3.0 revision. The **V2 all-black mascot is superseded** (page 5 of the source study, kept for history) — it disappeared against dark developer themes, which is exactly what V3.0 fixes.

**Mascot rules:**

- Place the mascot on Base #0A1128 (digital) or Ice White #F5F7FA (light/print) — the same substrates as the mark.
- Keep the medallion legible. If the chest chip cannot resolve, the mascot is too small — use the mark alone instead.
- The mascot **supplements** the wordmark; it never replaces it in a lockup, header, or signature.
- Do not recolour the body outside the two canonical colourways. Do not restyle the face, add pupils, or animate expressions beyond the fixed `w` smile.
- Do not use the mascot as a favicon or app icon — that is the mark's job (`flop_mark.svg`).

**Assets.** The mascot ships in two forms:

- **Vector masters (use these):** `docs/brand/mascot/flop_mascot.svg` (Cyan) and `flop_mascot_green.svg` (Electric Green) — resolution-independent redraws, safe for print, large-format, and merchandise. Render at any size (`rsvg-convert -w 4096 …`); no raster exports are committed, so generate rather than upscale.
- **Design reference:** `docs/brand/flop_mascot_design_v3.pdf`. Its renders are the **fidelity reference** for the vector redraw and extract with `pdfimages -all -p`. The masters are a faithful reconstruction, not a pixel-identical copy of the original 3D renders; for photoreal 3D or print-scale marketing renders, source the originals from the Drive assets (`docs/brand/DRIVE_ASSETS.md`).

`docs/brand/mascot/DRAWING_GUIDE.md` (+ `flop_mascot_steps.svg`) documents how to reproduce the character by hand — a six-shape freehand route and a proportion grid.

## Layout

The layout follows a **Contained Grid** model with strict mask-like rhythm — centered content with a max-width container, generous margins, and an 8px spacing scale for grid-aligned precision.

- **Container:** Centered, responsive padding.
- **Spacing Scale:** 4px → 8px → 16px → 24px → 32px.
- **Components:** Grouped in tonal surfaces (surface on Base) with internal padding matching the scale. Dense but precise.

## Elevation & Depth

Depth is achieved through **Tonal Layers** (deep-navy substrate tones) rather than heavy shadows, consistent with high-contrast minimalism.

- Dark: Base (#0A1128) → surface (#151D32) → surface-light (#232A3E) creates natural separation.
- Light: Ice White (#F5F7FA) → White card (#FFFFFF) defined by Mist (#D9DDE1) borders (the lift is subtle — use the border, not contrast).
- No drop shadows on static elements — flat design with tonal separation.
- Hover: subtle FLOP Cyan accent or tonal border lift on interactive cards.

## Shapes

The shape language is defined by **Foundry Precision** and grid-aligned, mask-like geometry. The mascot is the sole soft form in the system and is an illustration, not a component — its curvature never propagates into UI chrome.

- Minimal radii for engineered sharpness: 0-4px default.
- **none (0px), sm (2px), md (4px):** Buttons, cards, inputs — the standard for grid precision.
- **lg (8px):** Hero containers or featured elements.
- **full (9999px):** Status badges, pills, tags.

No soft curves or decoration that does not carry information.

## Components

### Buttons

Three variants (use Primary only for the single most important action per screen):
- **Primary** (FLOP Cyan #00B4D8 fill with Base #0A1128 text — the sole driver for interaction, CTAs, key moments. Rounded md/4px, md padding. Hover lifts to #3DC5E0. Base text on the cyan fill reads 7.6:1 AAA.)
- **Secondary** (surface #151D32 fill, Ice White text. For supporting actions.)
- **Ghost** (transparent, secondary-text colour; hover lifts to surface. For navigation, non-destructive.)

Primary actions *always* use Primary variant. Secondary/tertiary use Secondary or Ghost. Ghost for nav. A **FLOP Blue #0466C8** fill is available for structural/large emphasis blocks — it takes **Ice White** text (5.6:1 AA), never Base text.

### Cards

Containers for grouped content. surface #151D32 (tonal layer above Base), md (4px) radius per "foundry sharpness", md (16px) padding. Tonal separation provides depth (no heavy drop shadows — flat with tonal + subtle FLOP Cyan lift on hoverable per ELEVATION & DEPTH). On light theme: White card on Ice White, defined by a Mist #D9DDE1 border.

### Badges

Status indicators — full radius (pills), Space Mono labels at label size (~12px). **Electric Green #32D74B** for verified/positive states (proofs settled, finalized blocks — text-safe at 9.8:1); **FLOP Cyan** for active/primary states; Grey/surface for neutral/secondary; **FLOP Blue** as a *fill* with Ice White text for structural emphasis. Always high contrast on dark surfaces. No decoration without information.

### Inputs

Text fields, search boxes. surface background, Ice White text, md (4px) radius, sm (8px) padding. Focus ring uses **FLOP Cyan**. Borders use surface-light (#232A3E). Precise, grid-aligned, minimal.

## Do's and Don'ts

- **Do** use FLOP Cyan #00B4D8 as the confident primary — headlines, logo, key CTAs, links (text-safe at 7.6:1 on Base).
- **Do** use Electric Green #32D74B for verified/settled/positive states — it is the proof signal, text-safe at 9.8:1.
- **Do** use Error Red #FF453A for operational failure only (5.5:1 AA on Base), always with an icon or label alongside.
- **Do** treat FLOP Blue #0466C8 as a *fill* on dark (Ice White text on top) and as the *text/link* colour on Ice White.
- **Do** use the supplied logo files from `docs/brand/official/` unaltered; the O of FLOP is the Chip, and word mark and Chip are one object.
- **Do** set the word mark in Base on light grounds and Ice White on dark ones — the Chip is what carries colour.
- **Do** keep the mascot's chest medallion as the Chip — that link is the reason the mascot belongs to this system.
- **Do** use Space Mono for brand headlines, navigation, data (hashes, addresses, signatures), labels, and code.
- **Do** use Inter for body copy and general UI text.
- **Do** maintain 8px spacing rhythm and grid alignment throughout.
- **Do** place the logo and mascot only on Base #0A1128 (digital) or Ice White #F5F7FA (light/print) backgrounds.
- **Do** hold 4X clear space (X = one grid module) on all four sides of the logo, measured from the artwork, and keep everything out of it.
- **Do** drop to the One-color version below 200px, and never set the logotype under 120px or the Chip under 24px.
- **Do** present data with foundry precision — labels, units, context; every value on the grid.
- **Do** use tonal layers (Base → surface → surface-light) for depth.
- **Don't** introduce any colour outside the canonical swatches plus the listed derived tokens.
- **Don't** use Error Red #FF453A as decoration, a large fill, or a brand accent — it means operational failure and nothing else.
- **Don't** let red be the only carrier of an error state; always pair it with an icon or label.
- **Don't** use FLOP Blue or Grey as body/link text on Base (3.3:1 and 3.2:1 — both fail); use Cyan, Green, Ice White, or derived #A1A7AE.
- **Don't** use FLOP Cyan or Electric Green as text on Ice White (2.3:1 and 1.8:1 — both fail); use them as fills with Base text on top.
- **Don't** use Primary cyan fills for navigation or secondary actions.
- **Don't** stretch, rotate, recolour, mirror, crop, watermark, or apply drop shadows/glows/filters to the logo — and don't redraw, retrace, rebuild or re-export it from a screenshot or slide.
- **Don't** colour the word mark, put two accents in one lockup, or lock a tagline, product name or year to it.
- **Don't** recolour the mascot outside the Cyan and Electric Green colourways, or revive the superseded V2 all-black finish.
- **Don't** upscale the mascot PNGs for print — render the SVG masters at the size you need instead.
- **Don't** let the mascot replace the wordmark in a lockup, header, or signature — or serve as the favicon.
- **Don't** place the mark or mascot on mid-tone or photographic backgrounds.
- **Don't** introduce arbitrary spacing values or radii; stick to the defined scales.
- **Don't** decorate with gradients, glows, or elements that do not carry information.
- **Don't** mix the dark and light themes in the same view (pick one ground per surface).
