# Most stuff came from ./meta-tizen/meta-tizen-common-base/recipes-image/images/tizen-core-image-minimal.bb

SUMMARY = "A very basic Wayland image with a terminal"

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs"

LICENSE = "MIT"

inherit core-image distro_features_check

REQUIRED_DISTRO_FEATURES = "wayland pam"

CORE_IMAGE_BASE_INSTALL += "weston weston-init"

DESCRIPTION = "A weston image with Tizen common."

DEPENDS += " tar-replacement-native "

CORE_IMAGE_BASE_INSTALL += "connman"
CORE_IMAGE_BASE_INSTALL += "${WESTONSTARTUP}"

# Profile specific configuration - default is Tizen common
CORE_IMAGE_BASE_INSTALL += "${IMAGECONFIG}"

CORE_IMAGE_BASE_INSTALL += "tlm"
CORE_IMAGE_BASE_INSTALL += "${TLMCONFIG}"


# Removed x86 mesa-specific stuff
CORE_IMAGE_BASE_INSTALL += "mesa-megadriver"
CORE_IMAGE_BASE_INSTALL += "gum-utils"
CORE_IMAGE_BASE_INSTALL += "meta-common"
CORE_IMAGE_BASE_INSTALL += "pam"
CORE_IMAGE_BASE_INSTALL += "user-session-units"
CORE_IMAGE_BASE_INSTALL += "default-ac-domains"
CORE_IMAGE_BASE_INSTALL += "rpm-security-plugin"
CORE_IMAGE_BASE_INSTALL += "config-image"
CORE_IMAGE_BASE_INSTALL += "kernel-modules"
CORE_IMAGE_BASE_INSTALL += "less"
CORE_IMAGE_BASE_INSTALL += "bash"
CORE_IMAGE_BASE_INSTALL += "psmisc"
CORE_IMAGE_BASE_INSTALL += "coreutils"
CORE_IMAGE_BASE_INSTALL += "procps"

# Our specific packages
CORE_IMAGE_BASE_INSTALL += "v4l-utils"

# From meta-tizen/meta-tizen-common-base/recipes-image/images/tizen-common-core-image-minimal.bb
CORE_IMAGE_BASE_INSTALL += "weston-common-tz-launcher"
CORE_IMAGE_BASE_INSTALL += "weston-common-config"
CORE_IMAGE_BASE_INSTALL += "desktop-skin"
CORE_IMAGE_BASE_INSTALL += "packagegroup-tizen-gstreamer"

# Multimedia
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-meta-base"
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-meta-audio"
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-meta-video"
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-meta-debug"
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-plugins-good-meta"
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-plugins-base-meta"
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-plugins-ugly-meta"
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-plugins-bad-meta"
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-libav"

# Fonts
CORE_IMAGE_EXTRA_INSTALL += "packagegroup-tizen-fonts-ttf"
CORE_IMAGE_EXTRA_INSTALL += "packagegroup-tizen-fonts-pango"

export SYSROOT = "${IMAGE_ROOTFS}"

# Set root password to "root"
ROOTFS_POSTPROCESS_COMMAND += "set_root_passwd;"
set_root_passwd() {
   sed 's%^root:[^:]*:%root:wYNffsf6sozwE:%' \
       < ${IMAGE_ROOTFS}/etc/shadow \
       > ${IMAGE_ROOTFS}/etc/shadow.new;
   mv ${IMAGE_ROOTFS}/etc/shadow.new ${IMAGE_ROOTFS}/etc/shadow ;
}
