require libdrm.inc

SRC_URI = "git://anongit.freedesktop.org/git/mesa/drm"

S = "${WORKDIR}/git"

DEFAULT_PREFERENCE = "-1"

SRCREV = "97be70b45eccc37e98a1cecf360593f36956ea42"
PV = "2.4.61+git${SRCPV}"
PR = "${INC_PR}.0"

