# Official brand assets — provenance

Every file here was downloaded from an official source and is used unmodified unless the
transformation is stated. Nothing here is redrawn, traced, or regenerated: both brand
guides forbid it, and a redrawn mark is the fastest way to look like a counterfeit.

## FLOP Labs

| File | Source | Retrieved | Transformed | Used for |
|---|---|---|---|---|
| `flop-lockup-reverse.svg` | https://flop.finance/assets/flop-lockup-reverse.svg | 2026-08-30 | no | Launch scene. The reverse lockup is the only approved lockup on Base, per Logo & Usage Standards V1.0. |
| `flop-chip-favicon.svg` | https://flop.finance/assets/flop-chip-favicon.svg | 2026-08-30 | no | App icon base. The design system names the Chip as the primary mark; the mascot explicitly may not be an app icon. |
| `og.png` | https://flop.finance/assets/og.png | 2026-08-30 | no | Reference only — confirms wordmark construction and Chip placement. |

**Not available:** the mascot vectors (`flop_mascot.svg`, `flop_mascot_green.svg`) are
referenced by design.md at `docs/brand/mascot/`, which is a path inside a repository FLOP
Labs has not published. flop.finance serves exactly three assets and none is the mascot.
The mascot is therefore absent from v1 rather than approximated. Asking FLOP Labs for the
file is tracked in PROJECT_STATE.md.

## Solana Mobile

| File | Source | Retrieved | Transformed | Used for |
|---|---|---|---|---|
| `seeker_isolated_white.svg` | Solana Seeker Press Kit (EXTERNAL), `Seeker Logo Isolated/02 White/` — https://drive.google.com/drive/folders/1x_xE73ZzQ6e_twQ9OnKe-q02lCg1FVjT | 2026-08-30 | no | The "FOR Seeker" line of the launch scene. White isolated variant, which is the one intended for dark grounds. |

The press kit is published by Solana Mobile for external use and is publicly readable
without an account. In the launch-scene prototype the SVG's internal CSS classes are
renamed `st0/st1` to `sk0/sk1` so they do not collide with the FLOP lockup's classes when
both are inlined in one HTML document. Path data, geometry and fill are untouched.

## Type

| Family | Licence | Source |
|---|---|---|
| Space Mono | SIL Open Font Licence 1.1 | https://github.com/google/fonts/tree/main/ofl/spacemono |
| Inter | SIL Open Font Licence 1.1 | https://github.com/google/fonts/tree/main/ofl/inter |

Both are the families named by the FLOP design system, and both are bundled rather than
fetched at runtime so the identity screens never fall back to a system face.
