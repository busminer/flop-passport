/*
  FLOP Passport — site behaviour.

  Two jobs: reveal sections as they scroll in, and verify a did:key against the live
  Technocore service entirely in the visitor's browser. There is no backend here, so
  nothing anybody pastes reaches us — which is also the honest reason the verifier can be
  offered at all.
*/

(function () {
  "use strict";

  // ---------------------------------------------------------------- language
  /*
    Same rule as the app: the English sentence is its own key, and a sentence with no
    entry renders in English rather than as an identifier. The table is written into the
    page by the build, so a translated page needs no second request before it can answer.
    Values are filled in after the lookup - pasting a room name into the key first is
    exactly how a string stops matching its own table.
  */
  var STRINGS = window.FLOP_I18N || {};

  function T(english, values) {
    var out = STRINGS[english] || english;
    if (values) {
      for (var name in values) {
        out = out.split("{" + name + "}").join(values[name]);
      }
    }
    return out;
  }

  // ---------------------------------------------------------------- reveal
  var reduce = window.matchMedia("(prefers-reduced-motion: reduce)").matches;

  if (!reduce && "IntersectionObserver" in window) {
    var io = new IntersectionObserver(
      function (entries) {
        entries.forEach(function (e) {
          if (e.isIntersecting) {
            e.target.classList.add("in");
            io.unobserve(e.target);
          }
        });
      },
      { rootMargin: "0px 0px -12% 0px", threshold: 0.05 }
    );
    document.querySelectorAll(".reveal").forEach(function (el) {
      io.observe(el);
    });
  } else {
    document.querySelectorAll(".reveal").forEach(function (el) {
      el.classList.add("in");
    });
  }

  // The marks fade in as whole objects. FLOP's logo standards forbid animating the lockup
  // as anything other than a whole, so the page never takes it apart.
  if (!reduce) {
    ["heroLockup", "heroJoin", "heroFor"].forEach(function (id) {
      var el = document.getElementById(id);
      if (el) el.classList.add("play");
    });
  }

  // ---------------------------------------------------------------- did:key
  var B58 = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

  function base58Decode(str) {
    var bytes = [0];
    for (var i = 0; i < str.length; i++) {
      var value = B58.indexOf(str[i]);
      if (value === -1) throw new Error(T("Not valid base58: {character}", { character: str[i] }));
      for (var j = 0; j < bytes.length; j++) bytes[j] *= 58;
      bytes[0] += value;
      var carry = 0;
      for (var k = 0; k < bytes.length; k++) {
        bytes[k] += carry;
        carry = bytes[k] >> 8;
        bytes[k] &= 0xff;
      }
      while (carry) {
        bytes.push(carry & 0xff);
        carry >>= 8;
      }
    }
    for (var z = 0; z < str.length && str[z] === "1"; z++) bytes.push(0);
    return new Uint8Array(bytes.reverse());
  }

  /**
   * Decode a did:key and fail closed, exactly as the server does. A DID copied out of a
   * screenshot is usually broken, and telling somebody that is more useful than showing
   * them an empty card.
   */
  function publicKeyOf(did) {
    if (did.indexOf("did:key:") !== 0) throw new Error(T("A did:key starts with did:key:z6Mk"));
    var mb = did.slice("did:key:".length);
    if (mb.length !== 48 || mb[0] !== "z") {
      throw new Error(T("Expected 48 characters starting with z, got {count}", { count: mb.length }));
    }
    var raw = base58Decode(mb.slice(1));
    if (raw.length !== 34 || raw[0] !== 0xed || raw[1] !== 0x01) {
      throw new Error(T("Only Ed25519 keys (z6Mk…) are accepted"));
    }
    return raw.slice(2);
  }

  async function fingerprint(did) {
    var digest = await crypto.subtle.digest("SHA-256", new TextEncoder().encode(did));
    return Array.from(new Uint8Array(digest))
      .map(function (b) {
        return b.toString(16).padStart(2, "0");
      })
      .join("")
      .slice(0, 16);
  }

  var UNTRUSTED = "!! UNTRUSTED CONTENT";

  /**
   * Strip the service's untrusted-content banner before display. Stripping the frame does
   * not make the content trusted: note namespaces are world-writable, so it is rendered as
   * inert text and never as markup.
   */
  function stripBanner(body) {
    var lines = body.split("\n");
    if (lines.length && lines[0].indexOf(UNTRUSTED) === 0) {
      lines.shift();
      while (lines.length && !lines[0].trim()) lines.shift();
    }
    return lines.join("\n").trim();
  }

  function el(tag, cls, text) {
    var node = document.createElement(tag);
    if (cls) node.className = cls;
    if (text !== undefined) node.textContent = text;
    return node;
  }

  function row(list, key, value, cls) {
    list.appendChild(el("dt", null, key));
    var dd = el("dd", cls);
    dd.textContent = value;
    list.appendChild(dd);
  }


  /**
   * SHA-256 of a string, lowercase hex. The same bytes the app hashes, so a `did-note`
   * line written by the app and this page's check either agree or genuinely disagree.
   */
  async function sha256(text) {
    var digest = await crypto.subtle.digest("SHA-256", new TextEncoder().encode(text));
    return Array.from(new Uint8Array(digest))
      .map(function (b) { return b.toString(16).padStart(2, "0"); })
      .join("");
  }

  /** Base64url with no padding, which is how the service stores a signature. */
  function unb64url(text) {
    var b64 = text.replace(/-/g, "+").replace(/_/g, "/");
    while (b64.length % 4) b64 += "=";
    var binary = atob(b64);
    var bytes = new Uint8Array(binary.length);
    for (var i = 0; i < binary.length; i++) bytes[i] = binary.charCodeAt(i);
    return bytes;
  }

  /**
   * Whether this browser can check Ed25519 itself — decided by trying it, not by reading a
   * version number. Cached, since the answer cannot change while the page is open.
   */
  var ed25519Ready = null;
  function canVerifyHere() {
    if (!ed25519Ready) {
      ed25519Ready = (async function () {
        if (!window.crypto || !crypto.subtle) return false;
        try {
          await crypto.subtle.importKey(
            "raw", new Uint8Array(32), { name: "Ed25519" }, false, ["verify"]
          );
          return true;
        } catch (e) {
          return false;
        }
      })();
    }
    return ed25519Ready;
  }

  /**
   * Check one stored record against the key that claims to have written it.
   *
   * Until 05:07 UTC on 31 August 2026 this could not be done at all: the service verified a
   * signature on the way in and then discarded it, so "posted by agent A" was the service's
   * word and nothing more. Signatures are kept now, so a reader can stop taking that word.
   *
   * The signed bytes are exactly `<room>|<nonce>|<text>`, where the text is what the
   * service stored after its own sweep. seq and ts are assigned by the service and are
   * deliberately not covered, because nobody can know them at signing time.
   */
  async function verifyRecord(room, message) {
    if (!message.sig || !message.from) return false;
    if (!(await canVerifyHere())) return false;
    try {
      var key = await crypto.subtle.importKey(
        "raw", publicKeyOf(message.from), { name: "Ed25519" }, false, ["verify"]
      );
      return await crypto.subtle.verify(
        { name: "Ed25519" },
        key,
        unb64url(message.sig),
        new TextEncoder().encode(room + "|" + message.nonce + "|" + message.text)
      );
    } catch (e) {
      return false;
    }
  }

  /**
   * Read a room, keeping every nonce as a string.
   *
   * A stored nonce can run to 19 digits, past what a JavaScript number holds exactly.
   * Letting JSON.parse round one would rebuild the wrong bytes and fail a perfectly good
   * signature, so the digits are quoted before parsing and never become a number.
   */
  async function readRoom(room) {
    // `/export` rather than `?limit=200`, which returns the newest 200 and nothing else.
    // Every user of this app signs into one shared room, so a cap of 200 would quietly
    // stop finding the did-note of anyone who joined early - the exact people whose
    // records are worth the most - the moment the room passed two hundred messages.
    // Export is the whole retained ring, one JSON record per line, byte for byte as
    // written, which is also the form a signature re-verifies from.
    var response = await fetch(
      "https://technocore.chat/r/" + encodeURIComponent(room) + "/export"
    );
    if (!response.ok) return null;
    var lines = (await response.text()).split("\n");
    var messages = [];
    for (var i = 0; i < lines.length; i++) {
      var line = lines[i].trim();
      if (!line) continue;
      try {
        messages.push(JSON.parse(line.replace(/"nonce":\s*(\d+)/g, '"nonce":"$1"')));
      } catch (e) {
        // A torn last line is documented as possible. Skipping it loses one record;
        // throwing would lose the room.
      }
    }
    return messages;
  }

  var DID_NOTE = /^did-note\s+([0-9a-f]{16})\s+([0-9a-f]{64})$/;

  /**
   * Follow FLOP's own instruction for checking a profile note.
   *
   * A DID note sits in a world-writable namespace, so finding one proves only that
   * somebody wrote it. FLOP's fix: the key signs a separate line carrying the note's hash.
   * This finds the newest such line in the room the note itself names, and reports whether
   * the note in front of us is the one the key vouched for.
   *
   * https://x.com/flop_labs/status/2090661329837371428
   */
  async function checkVouch(did, fp, noteBody) {
    var room = (noteBody.match(/\broom:\s*([A-Za-z0-9-]+)/) || [])[1];
    if (!room) return { state: "missing", reason: "the note names no room to look in" };

    var messages = await readRoom(room);
    if (!messages) return { state: "unknown", room: room };

    var checked = await canVerifyHere();
    var mine = messages
      .filter(function (m) { return m.from === did; })
      .sort(function (a, b) { return b.seq - a.seq; });

    // Everything this identity wrote here that this browser could prove, newest first. A
    // record whose signature does not check out is dropped rather than counted quietly,
    // and when the browser cannot check at all we fall back to the service's word and say
    // so on the page instead of pretending the difference does not exist.
    var proved = [];
    var failed = 0;
    var unsigned = 0;
    for (var i = 0; i < mine.length; i++) {
      if (!mine[i].sig) {
        // Not a failure. The signed lane is optional and was added later, so a record
        // written before it exists carries no signature at all - it is not re-verifiable,
        // which is a different thing from invalid, and the service's own documentation
        // says to treat it that way. Counting it as a bad signature would put a red badge
        // on every early adopter.
        unsigned += 1;
      } else if (!checked) {
        proved.push(mine[i]);
      } else if (await verifyRecord(room, mine[i])) {
        proved.push(mine[i]);
      } else {
        // Dropped, and counted. A record that carries a signature which does not survive
        // the check is the most newsworthy thing this page can find; it used to disappear
        // into the same silence as a key that never published at all.
        failed += 1;
      }
    }

    var found = null;
    var claimed = null;
    for (var j = 0; j < proved.length && !found; j++) {
      var m = (proved[j].text || "").trim().match(DID_NOTE);
      if (m && m[1] === fp) {
        found = proved[j];
        claimed = m;
      }
    }

    var base = {
      room: room,
      selfChecked: checked,
      failed: failed,
      unsigned: unsigned,
      signed: proved.length,
      newest: proved.length ? proved[0].ts : null,
    };
    if (!found) {
      base.state = "missing";
      return base;
    }

    var actual = await sha256(noteBody);
    base.state = claimed[2] === actual ? "matches" : "changed";
    base.seq = found.seq;
    base.claimed = claimed[2];
    base.actual = actual;
    return base;
  }

  var out = document.getElementById("verifyOut");
  var input = document.getElementById("didInput");
  var button = document.getElementById("verifyBtn");

  function show(nodes) {
    out.innerHTML = "";
    nodes.forEach(function (n) {
      out.appendChild(n);
    });
    out.classList.add("show");
  }

  function problem(message) {
    var box = el("div", "notice");
    box.style.borderColor = "rgba(255,69,58,0.35)";
    box.style.background = "rgba(255,69,58,0.06)";
    box.appendChild(el("p", null, message)).style.margin = "0";
    show([box]);
  }

  async function verify() {
    var did = (input.value || "").trim();
    if (!did) {
      problem(T("Paste a did:key first."));
      return;
    }

    var key;
    try {
      key = publicKeyOf(did);
    } catch (e) {
      problem(T("That is not a usable did:key.") + " " + e.message);
      return;
    }

    button.disabled = true;
    button.textContent = T("Checking…");
    show([el("p", null, T("Asking technocore.chat…"))]);

    try {
      var fp = await fingerprint(did);
      var path = "/kv/did-" + fp.slice(0, 2) + "/" + fp.slice(2);
      var response = await fetch("https://technocore.chat" + path, {
        headers: { Accept: "text/plain" },
      });
      var text = response.ok ? stripBanner(await response.text()) : null;

      var nodes = [];
      var head = el("div");
      head.style.display = "flex";
      head.style.gap = "8px";
      head.style.alignItems = "center";
      head.style.flexWrap = "wrap";
      head.appendChild(el("span", "badge cyan", T("key is real")));
      head.appendChild(
        el("span", text ? "badge cyan" : "badge grey",
          text ? T("note published") : T("no note found"))
      );

      // The badge that actually means something. A published note is a claim; a note the
      // key vouched for is evidence; and a note that no longer matches its own signed hash
      // is a warning worth shouting about.
      var vouch = text ? await checkVouch(did, fp, text) : { state: "missing" };
      // Green means this browser did the arithmetic. When it could not - an old browser
      // with no Ed25519 in WebCrypto - the same facts are still worth showing, but as
      // technocore.chat's word, in grey, with the source named. A green badge over an
      // unchecked claim would be the one lie this page cannot afford.
      if (vouch.state === "matches") {
        head.appendChild(el("span", vouch.selfChecked ? "badge green" : "badge grey",
          vouch.selfChecked
            ? T("vouched for by the key")
            : T("vouched for by the key, per technocore.chat")));
      } else if (vouch.state === "changed") {
        head.appendChild(el("span", "badge red", T("note changed since signing")));
      } else if (vouch.state === "unknown") {
        head.appendChild(el("span", "badge grey", T("could not read the room")));
      }
      if (vouch.failed) {
        head.appendChild(el("span", "badge red", T("a signature did not check out")));
      }
      if (vouch.unsigned) {
        head.appendChild(
          el("span", "badge grey", vouch.unsigned === 1
            ? T("{count} record predates signatures", { count: vouch.unsigned })
            : T("{count} records predate signatures", { count: vouch.unsigned }))
        );
      }
      if (vouch.signed) {
        head.appendChild(
          el("span", vouch.selfChecked ? "badge green" : "badge grey",
            vouch.selfChecked
              ? (vouch.signed === 1
                  ? T("{count} record checked here", { count: vouch.signed })
                  : T("{count} records checked here", { count: vouch.signed }))
              : (vouch.signed === 1
                  ? T("{count} record, per technocore.chat", { count: vouch.signed })
                  : T("{count} records, per technocore.chat", { count: vouch.signed })))
        );
      }
      nodes.push(head);

      var list = el("dl", "kv");
      row(list, T("identity"), did);
      row(list, T("public key"), Array.from(key).map(function (b) {
        return b.toString(16).padStart(2, "0");
      }).join(""));
      row(list, T("fingerprint"), fp);
      row(list, T("note address"), "technocore.chat" + path);
      if (text) row(list, T("note content"), text);
      nodes.push(list);

      if (vouch.state === "matches") {
        row(list, T("vouched by"),
          T("did-note in /r/{room}, entry {seq}", { room: vouch.room, seq: vouch.seq }));
      } else if (vouch.state === "changed") {
        row(list, T("signed hash"), vouch.claimed);
        row(list, T("actual hash"), vouch.actual);
      }
      if (vouch.room && vouch.selfChecked) {
        row(list, T("signatures"),
          T("{count} verified in this browser, from /r/{room}",
            { count: vouch.signed, room: vouch.room }));
        if (vouch.newest) row(list, T("most recent"), vouch.newest);
      }

      var note = el("p", null, T(
        !text
          ? "This key is well formed, but nothing is published at its note address yet. " +
            "That is what step 03 in the app does."
          : vouch.state === "matches"
          ? "The holder of this key signed a line carrying this note's exact hash, and the " +
            "hashes agree. That is as strong as a note gets: note addresses are " +
            "world-writable, so without that line a note only proves somebody wrote it."
          : vouch.state === "changed"
          ? "Warning: this key signed a line for a different version of this note, so " +
            "somebody has changed it since. FLOP's own advice is to ignore a note whose " +
            "hash no longer matches."
          : vouch.state === "unknown"
          ? "technocore.chat did not answer for the room this note names, so nothing here " +
            "could be checked. That service refuses reads when it is busy; try again in a " +
            "moment."
          : "This note is a claim, not a proof: note addresses are world-writable, and no " +
            "signed did-note line was found vouching for this text."
      ));
      note.style.fontSize = "14px";
      note.style.marginTop = "16px";
      nodes.push(note);

      // The distinction the whole page turns on, spelled out rather than implied by a
      // badge: a service reporting an author is not the same thing as arithmetic anyone
      // can redo. Before 31 August 2026 only the first was on offer.
      if (vouch.failed) {
        var dropped = el("p", null, vouch.failed === 1
          ? T("{count} record in that room claims this key and fails the signature check. " +
              "It was not counted.", { count: vouch.failed })
          : T("{count} records in that room claim this key and fail the signature check. " +
              "They were not counted.", { count: vouch.failed }));
        dropped.style.fontSize = "14px";
        dropped.style.marginTop = "12px";
        dropped.style.color = "var(--red)";
        nodes.push(dropped);
      }

      if (vouch.room && vouch.state !== "unknown") {
        var proof = el("p", null, T(
          vouch.selfChecked
            ? "Nothing above was taken on trust. This page pulled the stored records, " +
              "rebuilt the exact bytes each signature covers, and checked them against " +
              "this key with your browser's own cryptography. technocore.chat served the " +
              "data and was not asked to vouch for it."
            : "Your browser cannot check Ed25519 signatures, so the authorship above is " +
              "technocore.chat's word rather than something proved here. A current " +
              "Chrome, Edge, Firefox or Safari will check it for itself."
        ));
        proof.style.fontSize = "14px";
        proof.style.marginTop = "12px";
        proof.style.color = vouch.selfChecked ? "var(--green)" : "var(--muted)";
        nodes.push(proof);
      }

      var link = el("a", null, T("Open the note yourself →"));
      link.href = "https://technocore.chat" + path;
      link.rel = "noopener";
      link.style.fontFamily = "var(--mono)";
      link.style.fontSize = "13px";
      nodes.push(link);

      show(nodes);
    } catch (e) {
      problem(T(
        "Could not reach technocore.chat from your browser. That says nothing about this " +
          "identity, only about the connection."
      ));
    } finally {
      button.disabled = false;
      button.textContent = T("Verify");
    }
  }

  if (button) button.addEventListener("click", verify);
  if (input) {
    input.addEventListener("keydown", function (e) {
      if (e.key === "Enter") verify();
    });
  }

  /**
   * A shareable check: /?did=did:key:z6Mk… fills the box and runs it on arrival.
   *
   * The point is a link somebody can post next to a claim about themselves, so a reader
   * lands on the answer instead of on a form they have to be persuaded to use. The value
   * is never trusted — it is validated like anything typed by hand, and it only ever
   * travels to technocore.chat, because this page has nowhere else to send it.
   */
  var shared = new URLSearchParams(location.search).get("did") ||
    (location.hash.indexOf("#did=") === 0 ? decodeURIComponent(location.hash.slice(5)) : "");
  if (shared && input) {
    input.value = shared.trim();
    var box = document.getElementById("verify");
    if (box) box.scrollIntoView({ block: "start" });
    verify();
  }

  var example = document.getElementById("tryExample");
  if (example) {
    example.addEventListener("click", function (e) {
      e.preventDefault();
      input.value = "did:key:z6Mkq2w8fJHnRES8sLV8ZC9YeiRG2eBJnLsqbvhyvg3zU1qs";
      verify();
    });
  }

  // ---------------------------------------------------------------- tip
  /*
    The same Solana Pay link the app builds, so the site and the app behave identically.
    On a phone this hands off to whichever wallet registered the solana: scheme; on a
    desktop nothing will claim it, which is why the address is printed underneath.
  */
  var TIP_NAME = "kosa.skr";
  var TIP_WALLET = "BmJaEmaEURBDpj91GUTvJcpKy2MAu8ZtRFRPaMpEuuax";
  var SKR_MINT = "SKRbvo6Gf7GondiT3BbTfuRDPqLWei4j2Qy2NPGZhW3";

  var tipUri =
    "solana:" + TIP_WALLET +
    "?spl-token=" + encodeURIComponent(SKR_MINT) +
    "&label=" + encodeURIComponent("FLOP Passport for Seeker") +
    "&message=" + encodeURIComponent("Thanks for building this");

  var tipBtn = document.getElementById("tipBtn");
  var tipAddr = document.getElementById("tipAddr");
  var copyAddr = document.getElementById("copyAddr");

  if (tipBtn) tipBtn.href = tipUri;
  if (tipAddr) tipAddr.textContent = TIP_WALLET;
  if (copyAddr) {
    copyAddr.addEventListener("click", function () {
      navigator.clipboard.writeText(TIP_WALLET).then(
        function () {
          copyAddr.textContent = T("Copied");
          setTimeout(function () { copyAddr.textContent = T("Copy address"); }, 1800);
        },
        function () {
          // Clipboard access can be refused; saying so beats a button that silently
          // does nothing and leaves someone tapping it.
          copyAddr.textContent = T("Copy blocked - select it below");
        }
      );
    });
  }
  // The language menu is a <details>, so it opens with scripts switched off. What a
  // <details> will not do on its own is close when you click somewhere else, and a menu
  // that stays open behind the page you are reading is indistinguishable from a stuck one.
  var langs = document.querySelector("details.langs");
  if (langs) {
    document.addEventListener("click", function (event) {
      if (langs.open && !langs.contains(event.target)) langs.open = false;
    });
    document.addEventListener("keydown", function (event) {
      if (event.key === "Escape" && langs.open) {
        langs.open = false;
        var summary = langs.querySelector("summary");
        if (summary) summary.focus();
      }
    });
  }
})();
