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
    ["heroLockup", "heroFor"].forEach(function (id) {
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
        el("span", text ? "badge green" : "badge grey", text ? "note published" : "no note found")
      );
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

      var note = el("p", null,
        text
          ? "The note above was written by whoever holds this key — but note addresses are " +
            "world-writable, so treat its content as a claim, not as proof. The proof is a " +
            "signature on a message."
          : "This key is well formed, but nothing is published at its note address yet. " +
            "That is what step 03 in the app does."
      );
      note.style.fontSize = "14px";
      note.style.marginTop = "16px";
      nodes.push(note);

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

  var example = document.getElementById("tryExample");
  if (example) {
    example.addEventListener("click", function (e) {
      e.preventDefault();
      input.value = "did:key:z6Mkw1JAVEwLgronRpuuzvHTyiiUgdoQGqkHG8VXH847dqcJ";
      verify();
    });
  }
})();
