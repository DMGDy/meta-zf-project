SUMMARY = "Prepackaged Trunk bundler for Rust"
HOMEPAGE = "https://github.com/thedodd/trunk"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"
SRC_URI = "https://github.com/trunk-rs/trunk/releases/download/v0.21.0-rc.3/trunk-x86_64-unknown-linux-gnu.tar.gz"
SRC_URI[sha256sum] = "540a1c8b44f3970fa2120897a98421793e1143810906b5cfde44854583ae487d"

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${WORKDIR}/trunk ${D}${bindir}/trunk
}

BBCLASSEXTEND = "native"

