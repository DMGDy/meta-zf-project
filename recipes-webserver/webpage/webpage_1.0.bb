SUMMARY = "Serves as the base HTML webpage for testers to access and interact \
with"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"


SRC_URI = "file://index.html"
SRC_URI[md5sum] = "5a7b9624da72abce02e66d93abe639e8"

do_install () {
    install -d ${D}/var/www/html
    install -m 0644 ${WORKDIR}/index.html ${D}/var/www/html
}

FILES:${PN} += "/var/www/html/index.html"
