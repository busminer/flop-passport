"""Generate the FLOOP Passport launch cue - an original asset, synthesised from scratch.

Nothing here is sampled, ripped, or derived from any FLOP or Solana Mobile material. It is
pure additive synthesis, so the file is ours to ship and its licence is not a question.

The cue tells the launch scene's story in sound, in the same three beats the motion uses:

    COMPUTE     a low sine that rises - a machine coming up
    HANDSHAKE   two clipped high blips - two systems recognising each other
    VERIFIED    a clean fifth that blooms and decays - settled, trustworthy

Design constraints, which are what keep it from sounding like a game:
  - no square/saw waves, no detune, no pitch bend beyond the opening rise;
  - every partial is a pure sine, so there is nothing harsh to fatigue on repeat;
  - the loudest moment is the verified chord, not the impact, so it reads as
    confirmation rather than alarm;
  - -14 dBFS peak, because a launch cue that makes someone reach for the volume
    button has failed regardless of how good it sounds.

    python tools/make_launch_sound.py app/src/main/res/raw/launch_cue.wav
"""
from __future__ import annotations

import struct
import sys
import wave
from pathlib import Path

import numpy as np

SR = 48_000
DURATION = 1.05
PEAK_DBFS = -14.0


def t_axis(seconds: float) -> np.ndarray:
    return np.linspace(0.0, seconds, int(SR * seconds), endpoint=False)


def env(n: int, attack: float, decay: float, curve: float = 3.0) -> np.ndarray:
    """Percussive envelope: fast attack, exponential decay, no sustain."""
    a = max(1, int(SR * attack))
    d = max(1, n - a)
    rise = np.linspace(0.0, 1.0, a) ** 0.6
    fall = np.exp(-curve * np.linspace(0.0, 1.0, d) * (1.0 / max(decay, 1e-6)) * decay * 5.0)
    return np.concatenate([rise, fall])[:n]


def sine(freq: float, seconds: float, phase: float = 0.0) -> np.ndarray:
    return np.sin(2 * np.pi * freq * t_axis(seconds) + phase)


def place(buf: np.ndarray, part: np.ndarray, at: float, gain: float) -> None:
    i = int(SR * at)
    j = min(len(buf), i + len(part))
    buf[i:j] += part[: j - i] * gain


buf = np.zeros(int(SR * DURATION), dtype=np.float64)

# --- 1. COMPUTE: a low sine rising a fifth, the machine coming up to speed -----------
rise_len = 0.30
tt = t_axis(rise_len)
sweep_hz = 110.0 * (1.5 ** (tt / rise_len))
low = np.sin(2 * np.pi * np.cumsum(sweep_hz) / SR)
low *= env(len(low), attack=0.035, decay=1.0, curve=1.6)
place(buf, low, 0.00, 0.55)
# One octave above at a whisper, so the low end reads on a phone speaker that
# cannot reproduce 110 Hz at all.
place(buf, low * 0.5, 0.00, 0.22)

# --- 2. HANDSHAKE: two clipped blips, two systems recognising each other -------------
for at, hz, g in ((0.26, 1760.0, 0.16), (0.34, 2349.3, 0.14)):
    blip = sine(hz, 0.055) * env(int(SR * 0.055), attack=0.002, decay=1.0, curve=6.0)
    place(buf, blip, at, g)

# --- 3. VERIFIED: a clean fifth that blooms and settles ------------------------------
chord_len = 0.62
for hz, g in ((880.0, 0.30), (1320.0, 0.20), (1760.0, 0.09), (440.0, 0.16)):
    tone = sine(hz, chord_len) * env(int(SR * chord_len), attack=0.012, decay=1.0, curve=2.4)
    place(buf, tone, 0.42, g)

# A single soft transient at the moment of confirmation, felt more than heard, so the
# haptic tick the app fires at the same instant has something to land against.
click = np.random.default_rng(7).normal(0, 1, int(SR * 0.006))
click *= np.exp(-np.linspace(0, 1, len(click)) * 9.0)
place(buf, click, 0.42, 0.045)

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
    "|", f"peak {20 * np.log10(np.max(np.abs(buf))):.1f} dBFS",
    "|", f"{out.stat().st_size / 1024:.0f} KB",
)
