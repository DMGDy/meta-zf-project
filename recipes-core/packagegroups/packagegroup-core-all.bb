inherit packagegroup
PROVIDES = "${PACKAGES}"

PACKAGES = "\
    packagegroup-zf-base \
    packagegroup-zf-networking \
    packagegroup-zf-wireless \
    packagegroup-zf-system \
    packagegroup-zf-utils \
    packagegroup-zf-proj \
"

RDEPENDS:packagegroup-zf-base = "\
    openssl \
    kernel-modules \
    linux-firmware-bcm43430 \
"

RDEPENDS:packagegroup-zf-networking = "\
    dhcpcd \
    nginx \
"

RDEPENDS:packagegroup-zf-wireless = "\
    wireless-regdb \
    iw \
    wpa-supplicant \
    curl \
"

RDEPENDS:packagegroup-zf-system = "\
    systemd \
    systemd-analyze \
    systemd-bash-completion \
    tzdata \
    ntp \
"

RDEPENDS:packagegroup-zf-utils = "\
    vim \
"
RDEPENDS:packagegroup-zf-ipc = "\
    open-amp \
    rpmsg-examples \
"
RDEPENDS:packagegroup-zf-proj = "\
    nginx-cfg \
    auto-set-time \
    rust-hello-world \
    zf-server \
    wasm-app-files \
    wifi-con \
"
