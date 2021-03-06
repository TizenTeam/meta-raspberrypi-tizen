include conf/machine/include/rpi-default-settings.inc
include conf/machine/include/rpi-default-versions.inc
include conf/machine/include/rpi-default-providers.inc

SOC_FAMILY = "rpi"
include conf/machine/include/soc-family.inc

IMAGE_FSTYPES ?= "tar.bz2 ext3 rpi-sdimg"

SERIAL_CONSOLE = "115200 ttyAMA0"

XSERVER = " \
    xserver-xorg \
    xf86-input-evdev \
    xf86-input-mouse \
    xf86-input-keyboard \
    xf86-video-fbdev \
    "

# Really supported starting from linux-raspberrypi 3.18.y only
KERNEL_DEVICETREE ?= " \
    bcm2708-rpi-b.dtb \
    bcm2708-rpi-b-plus.dtb \
    bcm2709-rpi-2-b.dtb \
    \
    overlays/hifiberry-amp-overlay.dtb \
    overlays/hifiberry-dac-overlay.dtb \
    overlays/hifiberry-dacplus-overlay.dtb \
    overlays/hifiberry-digi-overlay.dtb \
    overlays/i2c-rtc-overlay.dtb \
    overlays/iqaudio-dac-overlay.dtb \
    overlays/iqaudio-dacplus-overlay.dtb \
    overlays/lirc-rpi-overlay.dtb \
    overlays/pps-gpio-overlay.dtb \
    overlays/w1-gpio-overlay.dtb \
    overlays/w1-gpio-pullup-overlay.dtb \
    "
KERNEL_IMAGETYPE ?= "Image"

MACHINE_FEATURES = "kernel26 apm usbhost keyboard vfat ext2 screen touchscreen alsa bluetooth wifi sdio"

# Raspberry Pi has no hardware clock
MACHINE_FEATURES_BACKFILL_CONSIDERED = "rtc"

MACHINE_EXTRA_RRECOMMENDS += " kernel-modules"

# Set Raspberrypi splash image
SPLASH = "psplash-raspberrypi"

IMAGE_BOOT_FILES ?= "bcm2835-bootfiles/* ${KERNEL_IMAGETYPE};${SDIMG_KERNELIMAGE}"

# Set preferred providers
PREFERRED_PROVIDER_virtual/egl ?= "userland"
PREFERRED_PROVIDER_virtual/libgles2 ?= "userland"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa-gl"
PREFERRED_PROVIDER_virtual/mesa ?= "mesa-gl"
PREFERRED_PROVIDER_jpeg ?= "jpeg"

PREFERRED_PROVIDER_vconf ?= "vconf"
PREFERRED_PROVIDER_vconf-native ?= "vconf-native"
PREFERRED_PROVIDER_libpam-native ?= "libpam-native"

#DISTRO_FEATURES_remove ?= "wayland-egl mesa mesa-megadriver"

