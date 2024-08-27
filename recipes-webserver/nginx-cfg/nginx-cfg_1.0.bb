SUMMARY = "Base nginx webserver configuration"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"


SRC_URI = "file://nginx.conf"

do_install () {
    install -d ${D}/etc/nginx
    install -m 0644 ${WORKDIR}/nginx.conf ${D}/etc/nginx
}

FILES:${PN} += "/etc/nginx/nginx.conf"
