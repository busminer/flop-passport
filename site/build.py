"""Assemble the site's pages from parts and the official brand SVGs.

The marks are inlined rather than linked so the page renders them with no second request
and no chance of a broken image where a logo should be. Path data is copied byte for byte
out of the supplied files; only the wrapping `<svg>` attributes are touched, and only to
size and scope them.

    python site/build.py

Eleven languages, the same eleven the app offers, each at its own address: `/` is English
and `/ru/`, `/zh/` and the rest sit beside it. Built pages rather than a script that swaps
text after loading, for three reasons that all point the same way: a search engine can
read a page it is served, a reader on a slow connection never watches English turn into
their own language, and a page with no JavaScript still works.

The translated prose comes from `i18n/apply.py`, which writes `_body.ru.html` and friends.
This file only assembles; it needs nothing installed beyond Python itself, so the machine
that deploys the site can never be the reason a language goes missing.
"""
from __future__ import annotations

import json
import re
import hashlib

import quotes
from pathlib import Path

SITE = Path(__file__).parent
ASSETS = SITE / "assets"
I18N = SITE / "i18n"

ORIGIN = "https://flop.alexkosa.dev"

# Each language named the way its own speakers write it: people scan for their own script,
# not for the English name of their language. Same list and same order as the app's picker.
# The short code shown on the header button, and the name shown inside the menu. The
# button has no room for eleven native names; the menu has room for nothing else.
CODES: dict[str, str] = {
    "en": "EN", "ru": "RU", "zh": "ZH", "es": "ES", "pt": "PT", "de": "DE",
    "tr": "TR", "vi": "VI", "id": "ID", "ko": "KO", "ja": "JA",
}

LANGS: list[tuple[str, str]] = [
    ("en", "English"),
    ("ru", "Русский"),
    ("zh", "中文"),
    ("es", "Español"),
    ("pt", "Português"),
    ("de", "Deutsch"),
    ("tr", "Türkçe"),
    ("vi", "Tiếng Việt"),
    ("id", "Indonesia"),
    ("ko", "한국어"),
    ("ja", "日本語"),
]

# What each translation of a page's own title and summary says. These live outside the
# body, so they are not segments; they are the line a search result and a shared link show,
# which makes them the first sentence most people ever read.
META: dict[str, dict[str, str]] = (
    json.loads((I18N / "meta.json").read_text(encoding="utf-8"))
    if (I18N / "meta.json").exists()
    else {}
)

EN_META = {
    "index_title": "FLOP Passport for Seeker",
    "index_description": (
        "Create a Technocore did:key identity from your Solana wallet, publish it where "
        "anyone can verify it, and keep the receipts. Open source, no account, no server."
    ),
    "privacy_title": "Privacy — FLOP Passport for Seeker",
    "privacy_description": (
        "FLOP Passport has no account, no analytics and no server of its own. What the app "
        "stores, what leaves your phone, and how to delete everything."
    ),
    "switcher_label": "Language",
}


def meta(lang: str, key: str) -> str:
    return META.get(lang, {}).get(key) or EN_META[key]


def svg(name: str, *, class_prefix: str | None = None) -> str:
    """Inline an SVG, optionally renaming its CSS classes so two marks can share a page."""
    text = (ASSETS / name).read_text(encoding="utf-8")
    text = re.sub(r"<\?xml[^>]*\?>\s*", "", text)
    text = re.sub(r"<!--.*?-->", "", text, flags=re.S)
    if class_prefix:
        # Both official files use .st0/.st1. Inlined together, the second would repaint the
        # first: the wordmark would take the Chip's accent, which is exactly the mistake the
        # brand guide calls out.
        text = re.sub(r"\.st(\d)", rf".{class_prefix}\1", text)
        text = re.sub(r'class="st(\d)"', rf'class="{class_prefix}\1"', text)
    return text.strip()


def cachebust(name: str) -> str:
    """Append a content hash so a redeploy cannot serve a stale stylesheet.

    Learned the boring way: an edited stylesheet kept rendering the old layout in a
    browser that had cached it, which reads exactly like a CSS rule that did not work.
    """
    digest = hashlib.sha256((SITE / name).read_bytes()).hexdigest()[:8]
    return f"/{name}?v={digest}"


def part(name: str, lang: str) -> str:
    """A partial in one language, falling back to English rather than to nothing."""
    if lang != "en":
        translated = SITE / name.replace(".html", f".{lang}.html")
        if translated.exists():
            return translated.read_text(encoding="utf-8")
    return (SITE / name).read_text(encoding="utf-8")


def home(lang: str) -> str:
    return "/" if lang == "en" else f"/{lang}/"


GLOBE = (
    '<svg class="langs-globe" viewBox="0 0 16 16" width="14" height="14" aria-hidden="true" '
    'fill="none" stroke="currentColor" stroke-width="1.3">'
    '<circle cx="8" cy="8" r="6.2"/><path d="M1.8 8h12.4"/>'
    '<path d="M8 1.8c1.7 1.7 2.6 3.9 2.6 6.2S9.7 12.5 8 14.2C6.3 12.5 5.4 10.3 5.4 8'
    'S6.3 3.5 8 1.8z"/></svg>'
)

CHEVRON = (
    '<svg class="langs-chev" viewBox="0 0 10 6" width="9" height="6" aria-hidden="true" '
    'fill="none" stroke="currentColor" stroke-width="1.4" stroke-linecap="round" '
    'stroke-linejoin="round"><path d="M1 1l4 4 4-4"/></svg>'
)


def switcher(lang: str, page_name: str) -> str:
    """A globe, the current language's code, and eleven names one click away.

    It was eleven links, always open, on the theory that a reader in Jakarta should not
    have to open anything to learn their language is here. On the page that theory cost a
    whole second row of the header and read as debris rather than as a control, so the set
    moved behind a button that every site on the internet has taught people to recognise.

    A `<details>` element, not a script: it opens with the page's JavaScript switched off,
    and all eleven links stay in the document, so a crawler sees the same set it saw when
    they were laid out in the open. The names inside stay in their own scripts - a person
    scanning for their language is scanning for the shape of their own writing, not for a
    two-letter code they may never have seen applied to it.
    """
    items = []
    for code, label in LANGS:
        href = home(code) if page_name == "index" else f"{home(code)}privacy"
        current = ' aria-current="page"' if code == lang else ""
        items.append(f'<a href="{href}" hreflang="{code}" lang="{code}"{current}>{label}</a>')
    label = meta(lang, "switcher_label")
    return (
        '<details class="langs">'
        f'<summary aria-label="{label}" title="{label}">'
        f'{GLOBE}<span class="langs-code">{CODES[lang]}</span>{CHEVRON}'
        "</summary>"
        f'<div class="langs-menu">{"".join(items)}</div>'
        "</details>"
    )


def localize_links(body: str, lang: str) -> str:
    """Point the site's own links at the same language the reader is already in."""
    if lang == "en":
        return body.replace('href="/privacy.html"', 'href="/privacy"')
    body = body.replace('href="/privacy.html"', f'href="/{lang}/privacy"')
    body = body.replace('href="/#', f'href="/{lang}/#')
    body = body.replace('href="/"', f'href="/{lang}/"')
    return body


def alternates(page_name: str) -> str:
    """Tell a search engine that these eleven pages are one page in eleven languages.

    Without this each translation competes with the others for the same subject and the set
    reads as duplicated content. `x-default` names the one to show a reader whose language
    is not among them.
    """
    lines = []
    for code, _ in LANGS:
        href = ORIGIN + (home(code) if page_name == "index" else f"{home(code)}privacy")
        lines.append(f'<link rel="alternate" hreflang="{code}" href="{href}" />')
    default = ORIGIN + ("/" if page_name == "index" else "/privacy")
    lines.append(f'<link rel="alternate" hreflang="x-default" href="{default}" />')
    return "\n".join(lines)


OG_LOCALE = {
    "en": "en_US", "ru": "ru_RU", "zh": "zh_CN", "es": "es_ES", "pt": "pt_BR",
    "de": "de_DE", "tr": "tr_TR", "vi": "vi_VN", "id": "id_ID", "ko": "ko_KR", "ja": "ja_JP",
}


def software_jsonld(lang: str) -> str:
    """What the app is, in the vocabulary a search engine already parses.

    Deliberately modest: name, what it runs on, that it costs nothing, and who made it.
    No rating and no review count - inventing either is the kind of small lie that gets a
    site's structured data ignored wholesale, and this one is worth being believed.
    """
    data = {
        "@context": "https://schema.org",
        "@type": "SoftwareApplication",
        "name": "FLOP Passport for Seeker",
        "applicationCategory": "UtilitiesApplication",
        "operatingSystem": "Android 14+, Solana Mobile Seeker",
        "inLanguage": [code for code, _ in LANGS],
        "url": ORIGIN + home(lang),
        "description": meta(lang, "index_description"),
        "isAccessibleForFree": True,
        "offers": {"@type": "Offer", "price": "0", "priceCurrency": "USD"},
        "author": {"@type": "Person", "name": "Alex Kosa", "url": "https://alexkosa.dev"},
    }
    return json.dumps(data, ensure_ascii=False, separators=(",", ":"))


FAQ_ITEM = re.compile(r'<div class="reveal">\s*<h3>(.*?)</h3>(.*?)(?=<div class="reveal">)', re.S)


def faq_jsonld(body: str) -> str | None:
    """The FAQ, offered to search in the shape it can quote directly.

    Built from the page rather than kept in a second list on purpose: a structured answer
    that no longer matches the visible one is worse than none, and there is no way to keep
    two hand-written copies in step across eleven languages.
    """
    block = re.search(r'<div class="faq">(.*?)\n      </div>', body, re.S)
    if not block:
        return None
    items = []
    for m in FAQ_ITEM.finditer(block.group(1) + '<div class="reveal">'):
        question = " ".join(re.sub(r"<[^>]+>", "", m.group(1)).split())
        answer = " ".join(re.sub(r"<[^>]+>", " ", m.group(2)).split())
        if not question or len(answer) < 20:
            continue
        items.append({
            "@type": "Question",
            "name": question,
            "acceptedAnswer": {"@type": "Answer", "text": answer[:1200]},
        })
    if not items:
        return None
    return json.dumps(
        {"@context": "https://schema.org", "@type": "FAQPage", "mainEntity": items},
        ensure_ascii=False, separators=(",", ":"),
    )


def page(
    *, lang: str, page_name: str, title: str, description: str, body: str,
    strings: str, extra_head: str = "",
) -> str:
    canonical = ORIGIN + (home(lang) if page_name == "index" else f"{home(lang)}privacy")
    return f"""<!doctype html>
<html lang="{lang}">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>{title}</title>
<meta name="description" content="{description}" />
<meta name="color-scheme" content="dark" />
<meta name="theme-color" content="#0A1128" />
<link rel="canonical" href="{canonical}" />
{alternates(page_name)}

<meta property="og:title" content="{title}" />
<meta property="og:description" content="{description}" />
<meta property="og:type" content="website" />
<meta property="og:url" content="{canonical}" />
<meta property="og:site_name" content="FLOP Passport for Seeker" />
<meta property="og:locale" content="{OG_LOCALE[lang]}" />
<meta property="og:image" content="{ORIGIN}/assets/og.png" />
<meta property="og:image:width" content="1200" />
<meta property="og:image:height" content="630" />
<meta name="twitter:card" content="summary_large_image" />
<meta name="twitter:site" content="@AlexKosa1" />
<meta name="twitter:creator" content="@AlexKosa1" />
<meta name="twitter:image" content="{ORIGIN}/assets/og.png" />

<link rel="icon" href="/assets/flop-chip-favicon.svg" type="image/svg+xml" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Space+Mono:wght@400;700&family=Inter:wght@400;500&display=swap" />
<link rel="stylesheet" href="{cachebust("styles.css")}" />
{extra_head}
</head>
<body>
{body}
<script>window.FLOP_I18N={strings};</script>
<script src="{cachebust("app.js")}" defer></script>
</body>
</html>
"""


def js_strings(lang: str) -> str:
    """The verifier's own sentences, written into the page rather than fetched.

    A second request for a dictionary would mean the verifier answers in English for as
    long as that request takes, on exactly the connection where it takes longest.
    """
    path = I18N / f"{lang}.js.json"
    if lang == "en" or not path.exists():
        return "{}"
    table = json.loads(path.read_text(encoding="utf-8"))
    return json.dumps(table, ensure_ascii=False, separators=(",", ":"))


def build_index(lang: str) -> Path:
    body = part("_body.html", lang)
    lockup = svg("flop-lockup-reverse.svg", class_prefix="fl")
    seeker = svg("seeker_solana_mobile_lockup_white.svg", class_prefix="sk")

    small = lockup.replace("<svg ", '<svg style="height:20px;width:auto" ', 1)

    body = body.replace("<!--LOCKUP_SMALL-->", small)
    body = body.replace("<!--LOCKUP-->", lockup)
    body = body.replace("<!--SEEKER-->", seeker)
    body = body.replace("<!--TWEETS-->", quotes.render(lang))
    # A second copy for the platform plate: an SVG cannot be in two places at
    # once, and its classes are scoped again so the two do not share a rule.
    body = body.replace(
        "<!--SEEKER_PLATE-->",
        svg("seeker_solana_mobile_lockup_white.svg", class_prefix="sp"),
    )
    body = localize_links(body, lang)
    # After localize_links, never before it. The switcher's hrefs are already the exact
    # per-language addresses, and localize_links rewrites every `href="/"` on the page into
    # `href="/<lang>/"` - which turned the switcher's own English entry into a link back to
    # the page you were already on. Ten languages, and no way out of any of them.
    body = body.replace("<!--LANGS-->", switcher(lang, "index"))

    faq = faq_jsonld(body)
    head = f'<script type="application/ld+json">{software_jsonld(lang)}</script>'
    if faq:
        head += f'\n<script type="application/ld+json">{faq}</script>'

    out = page(
        lang=lang, page_name="index",
        title=meta(lang, "index_title"),
        description=meta(lang, "index_description"),
        body=body, strings=js_strings(lang), extra_head=head,
    )
    target = SITE / "index.html" if lang == "en" else SITE / lang / "index.html"
    target.parent.mkdir(parents=True, exist_ok=True)
    target.write_text(out, encoding="utf-8")
    return target


def build_privacy(lang: str) -> Path:
    body = part("_privacy.html", lang)
    small = svg("flop-lockup-reverse.svg", class_prefix="fl").replace(
        "<svg ", '<svg style="height:20px;width:auto" ', 1
    )
    body = body.replace("<!--LOCKUP_SMALL-->", small)
    body = localize_links(body, lang)
    body = body.replace("<!--LANGS-->", switcher(lang, "privacy"))
    out = page(
        lang=lang, page_name="privacy",
        title=meta(lang, "privacy_title"),
        description=meta(lang, "privacy_description"),
        body=body, strings=js_strings(lang),
    )
    target = SITE / "privacy.html" if lang == "en" else SITE / lang / "privacy.html"
    target.parent.mkdir(parents=True, exist_ok=True)
    target.write_text(out, encoding="utf-8")
    return target


def build_sitemap() -> None:
    """Every page in every language, each one naming the other ten.

    A plain list of twenty-two URLs would leave a crawler to work out for itself that they
    are translations of each other, and it usually gets that wrong.
    """
    rows = []
    for page_name in ("index", "privacy"):
        for code, _ in LANGS:
            loc = ORIGIN + (home(code) if page_name == "index" else f"{home(code)}privacy")
            links = "".join(
                '<xhtml:link rel="alternate" hreflang="{c}" href="{h}"/>'.format(
                    c=other,
                    h=ORIGIN + (home(other) if page_name == "index" else f"{home(other)}privacy"),
                )
                for other, _ in LANGS
            )
            default = ORIGIN + ("/" if page_name == "index" else "/privacy")
            links += f'<xhtml:link rel="alternate" hreflang="x-default" href="{default}"/>'
            priority = (
                "1.0" if page_name == "index" and code == "en"
                else "0.8" if page_name == "index"
                else "0.3"
            )
            rows.append(
                f"  <url><loc>{loc}</loc>{links}"
                f"<changefreq>weekly</changefreq><priority>{priority}</priority></url>"
            )
    xml = (
        '<?xml version="1.0" encoding="UTF-8"?>\n'
        '<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"\n'
        '        xmlns:xhtml="http://www.w3.org/1999/xhtml">\n'
        + "\n".join(rows)
        + "\n</urlset>\n"
    )
    (SITE / "sitemap.xml").write_text(xml, encoding="utf-8")
    print(f"wrote sitemap.xml — {len(rows)} URLs")


def build_robots() -> None:
    text = (
        "# FLOP Passport for Seeker. Everything here is meant to be read and indexed.\n"
        "User-agent: *\n"
        "Allow: /\n"
        "\n"
        f"Sitemap: {ORIGIN}/sitemap.xml\n"
    )
    (SITE / "robots.txt").write_text(text, encoding="utf-8")
    print("wrote robots.txt")


if __name__ == "__main__":
    for code, _ in LANGS:
        a = build_index(code)
        b = build_privacy(code)
        size = (a.stat().st_size + b.stat().st_size) // 1024
        print(f"{code}: {a.relative_to(SITE)}, {b.relative_to(SITE)} — {size} KB")
    build_sitemap()
    build_robots()
