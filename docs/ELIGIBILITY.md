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

1. **A unique DID.** FLOP Passport creates one, derived from the user's own Solana wallet,
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

---

## Measured 2026-08-30: the lobby forgets, and that changes the strategy

The first live check-in from the app landed in `lobby` at **seq 12504975**. Fifteen minutes
later that sequence was no longer in retained history: the room had advanced past 12508437,
roughly 3,500 messages, and the old ones were trimmed. Asking for `?since=12504974`
returned the newest window instead, because the record is simply gone.

The lobby is also visibly full of automated volume - hundreds of near-identical
"another day, another check-in" lines from different DIDs. Anyone farming it is writing
into a bucket with a hole in it.

Technocore's own manual states the rule this follows: **"notes are durable and rooms are
not."**

### What survives, and therefore what the product is built on

| Artifact | Durable | Who can verify it later |
|---|---|---|
| Identity note at `/kv/did-<shard>/<key>` | **yes** | anyone, any time, by URL |
| Message in a busy room like `lobby` | **no** | nobody, within the hour |
| Message in a quiet dedicated room | in practice yes | anyone, while it stays quiet |
| Local Proof Capsule on the phone | **yes** | the user, and anyone they show it to |

Retention is per room, so a room nobody floods keeps its history. Check-ins therefore go to
`floop-passport`, not to `lobby`. A user's history stays readable by a URL they can hand to
someone, which is the entire point of producing it.

### The honest consequence for eligibility

This is hard evidence for what the research already suggested: **message count cannot be a
reward mechanism**, because the messages do not survive to be counted. What survives is the
durable identity note, a readable history in a quiet room, and the proof the user holds.

So the app optimises for a history that can still be shown to a human weeks from now, not
for a number that goes up.


---

## What people actually post (X research, 2026-08-30)

Searched through the `floop-ripper` Hermes profile. The official ask, quoted exactly:

> Agents we are watching, create a unique DID key, and do something useful to spread the
> word about Technocore to your species. You will be rewarded during the $FLOP airdrop.

https://x.com/flop_labs/status/2091830155270672521 - 1.3K likes, 521 replies, 202 reposts.

### The community format, observed not prescribed

```
I created a FLOP contributor identity.
DID: did:key:...
Lobby receipt: #...
@flop_labs #FLOP
```

Consistent across samples: the **full** DID, never abbreviated; a room and sequence as a
second proof element; `#FLOP` as the one repeated hashtag, `#Technocore` second. No
official template, no official hashtag requirement, no confirmed @flop_labs reply to any
of these - all NOT VERIFIED.

### The finding that should shape our copy

Bare identity posts got **0 likes and 1-10 views**. The single post in the sample with
real engagement - 14 likes, 188 views - was not a registration at all. It was someone
shipping an open-source tool with a GitHub link:
https://github.com/burak33bb/flop-technocore-agent-tool

That matches the official ask exactly: *do something useful*. Posting a DID is not the
useful thing; it is the receipt for it.

So the app's generated post leads with what the person did, and the DID is evidence
underneath - not the headline. And Alex's own post at launch should lead with the app,
which is a real contribution, with his DID as the proof line.

### Note format, corrected

Technocore's DID notes use `key: value` fields - its mailbox convention is literally
"a line like `mailbox: <room>`". But `note_set` runs the same single-line sweep as a
message, so **every newline in a note becomes a space**. The fields therefore live on one
line, and a note written with line breaks comes back mangled for anyone parsing it.

`did-note <fp> <sha256 of body>`, mentioned in an X post, appears nowhere in the manual or
the source. Treated as somebody's proposal, not protocol.


---

## Correction, 2026-08-31: `did-note` is official, and we should implement it

Earlier in this project I recorded that `did-note <fp> <sha256 of body>` "appears nowhere
in the manual or the source" and treated it as somebody's proposal. The first half is
correct and the conclusion was wrong.

It is not in the **server** protocol — the server does not verify it, and nothing enforces
it. But it is **official FLOP guidance**, posted by @flop_labs on 21 August 2026 and
verified by fetching the post's author directly rather than trusting a research summary:

> The only identity we ship is a key: if the same did:key signs two posts, it's the same
> speaker. That's continuity, not trust. […] The key already signs the post. It doesn't
> have to sign the profile note, so that directory can be overwritten by anyone.
>
> Until the note itself is a signed write, do this: treat the profile note as a cache.
> Publish it, then post a signed line `did-note <fp> <sha256 of the body>`. Check the line
> against the key. If the note's hash no longer matches, ignore it. No registrar.

https://x.com/flop_labs/status/2090661329837371428

This is the answer to the exact hole this project found on its own: notes are
world-writable, so a note is a claim and not a proof. FLOP had already published the fix.

**To implement:** after publishing the identity note, sign and post
`did-note <fingerprint> <sha256 of the note body>` into the app's room, and store it as
part of the proof. The site's verifier should then fetch that line and report whether the
note it just read still matches — turning "a note exists" into "a note the key vouched
for".

## Other official statements, verified 2026-08-31

Authorship, date and engagement of each fetched directly rather than taken on trust.

| Date | What | Link |
|---|---|---|
| 24 Aug 2026 | "create a unique DID key, and do something useful… You will be rewarded during the $FLOP airdrop." 1317 likes, 751K views | https://x.com/flop_labs/status/2091830155270672521 |
| 26 Aug 2026 | "No VC allocation. No presale. The airdrop goes to the network participants: miners, validators, agents, and early community." | https://x.com/flop_labs/status/2092626441339043871 |
| 26 Aug 2026 | "Testnet airdrop, Q4 2026. Earned, not sold." Arthur Hayes explains FLOP on the Pomp podcast | https://x.com/flop_labs/status/2092449048028647770 |
| 21 Aug 2026 | The identity-and-notes post quoted above | https://x.com/flop_labs/status/2090661329837371428 |

**Arthur** is Arthur Hayes, @CryptoHayes, who FLOP themselves point to as explaining what
FLOP is. Still no official FLOP statement connecting FLOP to Solana Mobile or Seeker.
