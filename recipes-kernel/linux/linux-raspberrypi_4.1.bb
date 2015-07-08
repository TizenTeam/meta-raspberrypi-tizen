LINUX_VERSION ?= "4.1.0"

SRCREV = "07009cab090ade3dd180e8a55d590b1a00072eed"
SRC_URI = "git://github.com/anholt/linux.git;protocol=git;branch=vc4-kms-v3d-rpi2 \
           file://0001-rpi2-setup.patch \
           file://0002-drm-vc4-Use-the-fbdev_cma-helpers.patch \
           file://0003-drm-vc4-Allow-vblank-to-be-disabled.patch \
           file://rpi2-defconfig.patch \
           file://HULK_SMASH.patch \
          "

require linux-raspberrypi.inc
