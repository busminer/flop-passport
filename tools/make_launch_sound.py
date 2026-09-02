"""Generate the FLOP Passport launch cue - an original asset, synthesised from scratch.

Nothing here is sampled, ripped, or derived from any FLOP or Solana Mobile material. It is
pure additive synthesis, so the file is ours to ship and its licence is not a question.

The cue is scored to the launch scene beat for beat, so sound and motion land together:

    0.00  GRID IGNITES     a low fifth rises out of nothing
    0.55  LOCKUP RESOLVES   a warm bloom arrives underneath
    1.00  SIGNAL TRAVELS    a bright tone sweeps across the stereo of the mix
    1.70  CHIP PULSES       one clean bell
    2.10  SEEKER IGNITES    three rising tones - two ecosystems meeting
    2.55  VERIFIED          a settled fifth blooms and decays under a soft transient

Design constraints, which are what keep it from sounding like a game:
  - every partial is a pure sine: nothing harsh to fatigue on the hundredth launch;
  - no square or saw waves, no detune, no pitch bend except the deliberate opening rise;
  - the loudest moment is the verified chord, not an impact, so it reads as
    confirmation rather than alarm;
  - -14 dBFS peak, because a launch cue that makes someone reach for the volume
    button has failed no matter how good it sounds.

    python tools/make_launch_sound.py app/src/main/res/raw/launch_cue.wav
"""
from __future__ import annotations

import struct
import sys
import wave
from pathlib import Path

import numpy as np

SR = 48_000
DURATION = 3.15
PEAK_DBFS = -14.0

# One key for the whole cue: A, with its fifth. Everything is a member of this set, which
# is why beats layered seconds apart still sound like one object rather than a sequence.
A2, A3, E4, A4, CS5, E5, A5 = 110.0, 220.0, 329.63, 440.0, 554.37, 659.25, 880.0


def t_axis(seconds: float) -> np.ndarray:
    return np.linspace(0.0, seconds, int(SR * seconds), endpoint=False)


def perc_env(n: int, attack: float, curve: float) -> np.ndarray:
    """Percussive: fast attack, exponential decay, no sustain. Higher curve = shorter."""
    a = max(1, min(n - 1, int(SR * attack)))
    rise = np.linspace(0.0, 1.0, a) ** 0.6
    fall = np.exp(-curve * np.linspace(0.0, 1.0, n - a))
    return np.concatenate([rise, fall])


def swell_env(n: int, peak_at: float = 0.4) -> np.ndarray:
    """Slow bloom and slow release - for pads that sit under everything else."""
    p = max(1, min(n - 1, int(n * peak_at)))
    return np.concatenate([
        np.linspace(0.0, 1.0, p) ** 1.6,
        np.cos(np.linspace(0.0, np.pi / 2, n - p)) ** 1.4,
    ])


def sine(freq: float, seconds: float) -> np.ndarray:
    return np.sin(2 * np.pi * freq * t_axis(seconds))


def place(buf: np.ndarray, part: np.ndarray, at: float, gain: float) -> None:
    i = int(SR * at)
    j = min(len(buf), i + len(part))
    if j > i:
        buf[i:j] += part[: j - i] * gain


buf = np.zeros(int(SR * DURATION), dtype=np.float64)

# --- 0.00  GRID IGNITES -------------------------------------------------------------
# A low sine climbing a fifth over 0.7s. Cumulative-sum phase rather than a naive
# freq*t, which would phase-jump and click on every sample of a glide.
rise_len = 0.70
tt = t_axis(rise_len)
sweep_hz = A2 * (1.5 ** (tt / rise_len))
low = np.sin(2 * np.pi * np.cumsum(sweep_hz) / SR) * perc_env(int(SR * rise_len), 0.10, 1.1)
place(buf, low, 0.00, 0.24)
place(buf, low, 0.00, 0.10)  # doubled an octave up in effect - phones cannot render 110 Hz

# A sparse shimmer while the grid is coming up: five short high tones, thinning out, so
# the opening has texture without becoming a melody that competes with the ending.
rng = np.random.default_rng(11)
for k, at in enumerate((0.10, 0.21, 0.30, 0.42, 0.52)):
    hz = float(rng.choice([A5, CS5 * 2, E5 * 2, A5 * 1.5]))
    tone = sine(hz, 0.05) * perc_env(int(SR * 0.05), 0.001, 9.0)
    place(buf, tone, at, 0.035 - k * 0.004)

# --- 0.55  LOCKUP RESOLVES ----------------------------------------------------------
# A warm pad on the root and fifth, blooming slowly under the moment the mark appears.
for hz, g in ((A3, 0.17), (E4, 0.11), (A4, 0.06)):
    pad = sine(hz, 1.90) * swell_env(int(SR * 1.90), peak_at=0.30)
    place(buf, pad, 0.55, g)

# --- 1.00  SIGNAL TRAVELS -----------------------------------------------------------
# One bright tone gliding upward over 0.85s, mirroring the cyan sweep crossing the mark.
sw_len = 0.85
st = t_axis(sw_len)
glide_hz = A4 * (2.0 ** (st / sw_len))
glide = np.sin(2 * np.pi * np.cumsum(glide_hz) / SR)
glide *= np.sin(np.linspace(0.0, np.pi, len(glide))) ** 1.5  # fades in and out, no edges
place(buf, glide, 1.00, 0.075)

# --- 1.70  CHIP PULSES --------------------------------------------------------------
for hz, g in ((A5, 0.24), (E5 * 2, 0.09)):
    bell = sine(hz, 0.45) * perc_env(int(SR * 0.45), 0.004, 4.5)
    place(buf, bell, 1.70, g)

# --- 2.10  SEEKER IGNITES -----------------------------------------------------------
# Three rising tones, the only melodic gesture in the cue. This is the handshake: the
# second ecosystem arriving and resolving onto the same root the first one started from.
for at, hz, g in ((2.10, E4, 0.22), (2.24, A4, 0.25), (2.38, CS5, 0.28)):
    tone = sine(hz, 0.30) * perc_env(int(SR * 0.30), 0.006, 5.0)
    place(buf, tone, at, g)

# --- 2.55  VERIFIED -----------------------------------------------------------------
chord_len = 0.55
for hz, g in ((A4, 0.30), (A5, 0.46), (E5 * 2, 0.26), (A5 * 2, 0.11)):
    tone = sine(hz, chord_len) * perc_env(int(SR * chord_len), 0.010, 3.2)
    place(buf, tone, 2.55, g)

# A single soft transient at the instant of confirmation, felt more than heard, so the
# haptic tick the app fires at the same moment has something to land against.
click = rng.normal(0, 1, int(SR * 0.006)) * np.exp(-np.linspace(0, 1, int(SR * 0.006)) * 9.0)
place(buf, click, 2.55, 0.07)

# --- master ---------------------------------------------------------------------------
# 12 ms fades at both ends: a waveform that starts or stops mid-cycle clicks, and on a
# launch screen that click is the first thing the user hears.
fade = int(SR * 0.012)
buf[:fade] *= np.linspace(0.0, 1.0, fade)
buf[-fade:] *= np.linspace(1.0, 0.0, fade)

buf /= np.max(np.abs(buf))
buf *= 10 ** (PEAK_DBFS / 20.0)

out = Path(sys.argv[1] if len(sys.argv) > 1 else "launch_cue.wav")
out.parent.mkdir(parents=True, exist_ok=True)
pcm = np.clip(buf * 32767.0, -32768, 32767).astype(np.int16)
with wave.open(str(out), "wb") as w:
    w.setnchannels(1)
    w.setsampwidth(2)
    w.setframerate(SR)
    w.writeframes(struct.pack("<%dh" % len(pcm), *pcm))

print(
    "wrote", out,
    "|", f"{len(pcm) / SR:.2f}s", f"{SR} Hz mono 16-bit",
    "|", f"peak {PEAK_DBFS:.1f} dBFS",
    "|", f"{out.stat().st_size / 1024:.0f} KB",
)
