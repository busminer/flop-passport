# What this app can honestly claim about the FLOP airdrop

Researched 2026-08-30 through the `floop-ripper` Hermes profile, which searched official
FLOP sources and reported what it could and could not confirm. Every claim below is tagged
OFFICIAL or NOT VERIFIED. The distinction is the whole point of this document: the product
sells a real path, and a real path is worth more than an exaggerated one.

## OFFICIAL — this is the spine of the product

FLOP Labs publicly asked agents to **create a unique `did:key` and do useful work on
Technocore**, and said this would be rewarded during the $FLOP airdrop.

> https://x.com/flop_labs/status/2091830155270672521

That single statement is what makes this app a product rather than a wrapper. It names
three things a user must do, and the app exists to make each of them possible from a phone:

1. **A unique DID.** FLOOP Passport creates one, derived from the user's own Solana wallet,
   so it is unique per wallet and reproducible without a seed phrase.
2. **Useful work on Technocore.** The app produces real signed records with read-back
   verification, and a Proof Capsule for each.
3. **Spreading the word.** Named in the same statement.

FLOP Labs has also publicly looked for useful Technocore projects and said such work could
be added to the `awesome-technocore` repository and noticed by the main project:

> https://x.com/flop_labs/status/2092493034122576221

An open-source, reproducible Seeker client is exactly that shape of work.

## OFFICIAL — the limits, stated by FLOP itself

- Technocore "settles nothing, holds no keys, and is not part of any protocol", and is
  "ephemeral by design". It is a satellite service, not the FLOP protocol.
- FLOP's own contact forms state that submitting is no guarantee of selection,
  participation, compensation, payment, token, allocation or reward, and that future
  programmes may carry separate eligibility requirements.

## NOT VERIFIED — never say these in the app

- That posting signed messages earns points, or that message count matters. There is no
  published points system, snapshot, or scoring mechanic. Volume-farming is a community
  inference, not a stated mechanism.
- That an identity note by itself is a qualifying action.
- That FLOP endorses Solana Mobile, Seeker, or Android clients. No confirmed official FLOP
  statement connects FLOP to Solana Mobile at all.
- That owning a Seeker improves eligibility.
- That this app is official, affiliated, or endorsed.

## What the product copy is therefore allowed to say

> FLOP asked agents to create a unique identity and do useful work on Technocore, and said
> that work would be rewarded at the airdrop. This app is how you do that from your phone,
> and it keeps the receipts.

And, everywhere a reward is implied, the same sentence in the same screen:

> No one can promise you an allocation, and this app does not. What it can do is make sure
> that if there is one, you have a real, verifiable history rather than nothing.

## Why the strategy is the strongest available

The most provable contribution chain, per the research, is:

1. a public GitHub repository with working source and reproducible build instructions;
2. an app-generated `did:key` whose private key never leaves the user's control;
3. real signed Technocore interactions with public read-back URLs and sequence numbers;
4. short technical documentation of why this is safer than hand-built signing URLs.

The app produces 2 and 3 for every user. Shipping it open-source produces 1 and 4 once, for
Alex. That is the same list FLOP publicly asked for.

## Latest confirmed official announcement

27 August 2026, a thread on the compute-market thesis, not an eligibility announcement:
https://x.com/flop_labs/status/2092786761709871609

Re-check before every release; this document is a snapshot, not a standing truth.
