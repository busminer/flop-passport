/*
  FLOOP Passport — site behaviour.

  Two jobs: reveal sections as they scroll in, and verify a did:key against the live
  Technocore service entirely in the visitor's browser. There is no backend here, so
  nothing anybody pastes reaches us — which is also the honest reason the verifier can be
  offered at all.
*/

(function () {
  "use strict";

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
      if (value === -1) throw new Error("not base58btc: " + str[i]);
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
    if (did.indexOf("did:key:") !== 0) throw new Error("A did:key starts with did:key:z6Mk");
    var mb = did.slice("did:key:".length);
    if (mb.length !== 48 || mb[0] !== "z") {
      throw new Error("Expected 48 characters starting with z, got " + mb.length);
    }
    var raw = base58Decode(mb.slice(1));
    if (raw.length !== 34 || raw[0] !== 0xed || raw[1] !== 0x01) {
      throw new Error("Only Ed25519 keys (z6Mk…) are accepted");
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
    var response = await fetch(
      "https://technocore.chat/r/" + encodeURIComponent(room) + "?since=0&limit=200&format=json"
    );
    if (!response.ok) return null;
    var body = (await response.text()).replace(/"nonce":\s*(\d+)/g, '"nonce":"$1"');
    return JSON.parse(body).messages || [];
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
    for (var i = 0; i < mine.length; i++) {
      if (!checked || (await verifyRecord(room, mine[i]))) proved.push(mine[i]);
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
      problem("Paste a did:key first.");
      return;
    }

    var key;
    try {
      key = publicKeyOf(did);
    } catch (e) {
      problem("That is not a usable did:key. " + e.message);
      return;
    }

    button.disabled = true;
    button.textContent = "Checking…";
    show([el("p", null, "Asking technocore.chat…")]);

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
      head.appendChild(el("span", "badge cyan", "key is real"));
      head.appendChild(
        el("span", text ? "badge cyan" : "badge grey", text ? "note published" : "no note found")
      );

      // The badge that actually means something. A published note is a claim; a note the
      // key vouched for is evidence; and a note that no longer matches its own signed hash
      // is a warning worth shouting about.
      var vouch = text ? await checkVouch(did, fp, text) : { state: "missing" };
      if (vouch.state === "matches") {
        head.appendChild(el("span", "badge green", "vouched for by the key"));
      } else if (vouch.state === "changed") {
        head.appendChild(el("span", "badge red", "note changed since signing"));
      }
      if (vouch.signed) {
        head.appendChild(
          el("span", "badge green", vouch.signed + (vouch.signed === 1 ? " record" : " records") + " checked here")
        );
      }
      nodes.push(head);

      var list = el("dl", "kv");
      row(list, "identity", did);
      row(list, "public key", Array.from(key).map(function (b) {
        return b.toString(16).padStart(2, "0");
      }).join(""));
      row(list, "fingerprint", fp);
      row(list, "note address", "technocore.chat" + path);
      if (text) row(list, "note content", text);
      nodes.push(list);

      if (vouch.state === "matches") {
        row(list, "vouched by", "did-note in /r/" + vouch.room + ", seq " + vouch.seq);
      } else if (vouch.state === "changed") {
        row(list, "signed hash", vouch.claimed);
        row(list, "actual hash", vouch.actual);
      }
      if (vouch.room && vouch.selfChecked) {
        row(list, "signatures", vouch.signed + " verified in this browser, from /r/" + vouch.room);
        if (vouch.newest) row(list, "most recent", vouch.newest);
      }

      var note = el("p", null,
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
          : "This note is a claim, not a proof: note addresses are world-writable, and no " +
            "signed did-note line was found vouching for this text."
      );
      note.style.fontSize = "14px";
      note.style.marginTop = "16px";
      nodes.push(note);

      // The distinction the whole page turns on, spelled out rather than implied by a
      // badge: a service reporting an author is not the same thing as arithmetic anyone
      // can redo. Before 31 August 2026 only the first was on offer.
      if (vouch.room) {
        var proof = el("p", null,
          vouch.selfChecked
            ? "Nothing above was taken on trust. This page pulled the stored records, " +
              "rebuilt the exact bytes each signature covers, and checked them against " +
              "this key with your browser's own cryptography. technocore.chat served the " +
              "data and was not asked to vouch for it."
            : "Your browser cannot check Ed25519 signatures, so the authorship above is " +
              "technocore.chat's word rather than something proved here. A current " +
              "Chrome, Edge, Firefox or Safari will check it for itself."
        );
        proof.style.fontSize = "14px";
        proof.style.marginTop = "12px";
        proof.style.color = vouch.selfChecked ? "var(--green)" : "var(--muted)";
        nodes.push(proof);
      }

      var link = el("a", null, "Open the note yourself →");
      link.href = "https://technocore.chat" + path;
      link.rel = "noopener";
      link.style.fontFamily = "var(--mono)";
      link.style.fontSize = "13px";
      nodes.push(link);

      show(nodes);
    } catch (e) {
      problem(
        "Could not reach technocore.chat from your browser. That says nothing about this " +
          "identity, only about the connection."
      );
    } finally {
      button.disabled = false;
      button.textContent = "Verify";
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
      input.value = "did:key:z6Mkw1JAVEwLgronRpuuzvHTyiiUgdoQGqkHG8VXH847dqcJ";
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
    "&label=" + encodeURIComponent("FLOOP Passport for Seeker") +
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
          copyAddr.textContent = "Copied";
          setTimeout(function () { copyAddr.textContent = "Copy address"; }, 1800);
        },
        function () {
          // Clipboard access can be refused; saying so beats a button that silently
          // does nothing and leaves someone tapping it.
          copyAddr.textContent = "Copy blocked - select it below";
        }
      );
    });
  }
})();
