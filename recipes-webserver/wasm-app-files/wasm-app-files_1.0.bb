SUMARRY = "WASM application files"

LICENSE = "CLOSED"

SRC_URI:append = "\
    file://index.html \
    file://zf-yew-webapp.js \
    file://zf-yew-webapp_bg.wasm \
"

do_install[nostamp] = "1"

do_deploy[nostamp] = "1"

do_install:append () {
    install -d ${D}/var/www/html
    install -m 0644 ${WORKDIR}/index.html ${D}/var/www/html
    
    install -d ${D}/usr/html/
    install -m 0644 ${WORKDIR}/zf-yew-webapp.js ${D}/usr/html
    install -m 0644 ${WORKDIR}/zf-yew-webapp_bg.wasm ${D}/usr/html
}

FILES:${PN} += "\
    /var/www/html/index.html \
    /usr/html/zf-yew-webapp.js \
    /usr/html/zf-yew-webapp_bg.wasm \
"
