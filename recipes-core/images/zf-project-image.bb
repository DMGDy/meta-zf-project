# Image for final deployment to device
require recipes-extended/images/core-image-full-cmdline.bb
PREFERRED_PROVIDER_virtual/kernel = "linux-stm32mp"



IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    packagegroup-zf-base \
    packagegroup-zf-networking \
    packagegroup-zf-wireless \
    packagegroup-zf-system \
    packagegroup-zf-utils \
    packagegroup-zf-proj \
    packagegroup-zf-ipc \
"

PACKAGECONFIG:append:pn-cargo = " nativesdk"
PACKAGECONFIG:append:pn-rust-native = " rust-libstd"
PACKAGECONFIG:append:pn-openssl = " cryptodev-linux"
