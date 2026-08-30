NBSP = chr(0x00A0)
ZWSP = chr(0x200B)
ZWJ = chr(0x200D)
BIDI = chr(0x202E)
LSEP = chr(0x2028)
TAB = chr(0x09)
LF = chr(0x0A)
RABBIT = chr(0x1F430)
ROBOT = chr(0x1F916)
MAN, WOMAN, GIRL = chr(0x1F468), chr(0x1F469), chr(0x1F467)

TEXTS = [
    "FLOOP Passport for Seeker. First signed check-in.",
    "  leading and trailing spaces  ",
    "line" + LF + "break" + TAB + "and" + TAB + "tabs",
    "zero" + ZWSP + "width and " + BIDI + "bidi override",
    "emoji survive: " + RABBIT + " " + ROBOT,
    "family flattens: " + MAN + ZWJ + WOMAN + ZWJ + GIRL,
    "nbsp" + NBSP + "edges and" + LSEP + "line sep",
    NBSP + " leading nbsp stripped by python " + NBSP,
]
