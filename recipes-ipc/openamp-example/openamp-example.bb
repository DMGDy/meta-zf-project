LICENSE = "CLOSED"

do_install[nostamp] = "1"
do_deploy[nostamp] = "1"

SRC_URI:append ="\
    file://fw_cortex_m4.sh\
    file://OpenAMP-Example.elf\
"

do_install:append() {
    install -d ${D}/home/root/OpenAMP-Example
    install -m 0744 ${WORKDIR}/fw_cortex_m4.sh ${D}/home/root/OpenAMP-Example

    install -d ${D}/home/root/OpenAMP-Example/lib/firmware
    install -m 0744 ${WORKDIR}/OpenAMP-Example.elf ${D}/home/root/OpenAMP-Example/lib/firmware
}

FILES:${PN} += "\
    /home/root/OpenAMP-Example/fw_cortex_m4.sh \
    /home/root/OpenAMP-Example/lib/firmware/OpenAMP-Example.elf \
"
