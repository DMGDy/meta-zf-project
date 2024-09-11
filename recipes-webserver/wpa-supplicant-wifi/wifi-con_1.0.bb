SUMMARY = "Quick Wifi Connection to Mobile Hotspot for Testing"
LICENSE = "CLOSED"

SRC_URI = "file://wpa_supplicant.conf"

do_install () {
    install -d ${D}/etc/
    install -m 0644 ${WORKDIR}/wpa_supplicant.conf ${D}/etc/
}

FILES:${PN} += "/etc/wpa_supplicant.conf"

