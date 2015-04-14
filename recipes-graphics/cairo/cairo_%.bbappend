SECTION = "Graphics/Libraries"
#
PACKAGECONFIG_append = " virtual/egl "
PACKAGECONFIG_append = " virtual/libglesv2 "

CFLAGS_append=" -I${STAGING_INCDIR}/interface/vcos/pthreads/ -I${STAGING_INCDIR}/interface/vmcs_host/linux/"

