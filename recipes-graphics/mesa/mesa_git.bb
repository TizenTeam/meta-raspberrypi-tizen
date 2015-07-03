require ${BPN}.inc

SRC_URI = " \
	git://anongit.freedesktop.org/mesa/mesa.git;branch=master \
	file://nir_include_dirs.patch \
	"
SRCREV = "1762568fd39b9be42d963d335e36daea25df7044"
S = "${WORKDIR}/git"
PV="git+"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)/#if ${@bb.utils.contains('DISTRO_FEATURES', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
}
