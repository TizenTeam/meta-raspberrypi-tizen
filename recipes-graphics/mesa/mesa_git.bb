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

# Enabling gallium-llvm creates a dependency on llvm.
# meta-openembedded provides that.

PACKAGECONFIG_append = " gallium"
PACKAGECONFIG_append = " gallium-egl"
PACKAGECONFIG_append = " gallium-gbm"
PACKAGECONFIG_append = " gallium-llvm"

DRIDRIVERSTIZEN = "swrast"
PACKAGECONFIG[dri] = "--enable-dri --with-dri-drivers=${DRIDRIVERSTIZEN}, --disable-dri, dri2proto libdrm"

GALLIUMDRIVERSTIZEN = "swrast"
GALLIUMDRIVERSTIZEN_append_raspberrypi2 = ",vc4"

GALLIUMDRIVERSTIZEN_LLVM33 = ""
GALLIUMDRIVERSTIZEN_LLVM33_ENABLED = "${@base_version_less_or_equal('MESA_LLVM_RELEASE', '3.2', False, len('${GALLIUMDRIVERSTIZEN_LLVM33}') > 0, d)}"
GALLIUMDRIVERSTIZEN_LLVM = "svga,"
