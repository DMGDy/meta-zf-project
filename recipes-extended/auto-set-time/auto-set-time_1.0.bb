SUMMARY = "Automatic Time Configuration"
DESCRIPTION = "Automatically sets timezone and configures time synchronization"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

inherit systemd

SRC_URI = "file://timesyncd.conf \
           file://set-timezone.service \
           file://set-timezone.sh"

S = "${WORKDIR}"

RDEPENDS_${PN} += "systemd-timesyncd tzdata"

do_install() {
    install -d ${D}${sysconfdir}/systemd
    install -m 0644 ${WORKDIR}/timesyncd.conf ${D}${sysconfdir}/systemd/

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/set-timezone.service ${D}${systemd_system_unitdir}

    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/set-timezone.sh ${D}${bindir}
}

SYSTEMD_SERVICE_${PN} = "set-timezone.service"
SYSTEMD_AUTO_ENABLE = "enable"

FILES:${PN} += "${sysconfdir}/systemd/timesyncd.conf \
                ${systemd_system_unitdir}/set-timezone.service \
                ${bindir}/set-timezone.sh"
FILES_${PN} += "${systemd_system_unitdir}/*"
FILES_${PN}-dev += "${systemd_system_unitdir}/* ${includedir}"

