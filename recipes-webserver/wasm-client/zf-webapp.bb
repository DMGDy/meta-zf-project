SUMMARY = "ZF Webapp RS"
HOMEPAGE = "https://github.com/DMGDy/zf-webapp-rs"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/DMGDy/zf-webapp-rs.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"

# We need rust-native for compilation
DEPENDS += "rust-native"

inherit cargo_bin

# Install Trunk using Cargo
do_configure() {
    cargo fetch
    cargo install --root ${WORKDIR} trunk
}

do_compile() {
    export PATH="${WORKDIR}/bin:$PATH"
    trunk build --release
}

do_install() {
    install -d ${D}/var/www/html
    cp -R ${S}/dist/* ${D}/var/www/html/
}

FILES:${PN} += "/var/www/html"
