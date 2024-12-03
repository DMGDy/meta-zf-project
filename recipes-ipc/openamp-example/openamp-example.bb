LICENSE = "CLOSED"

# Always install and deploy
do_install[nostamp] = "1"
do_deploy[nostamp] = "1"

SRC_URI:append ="\
    file://fw_cortex_m4.sh\
    file://BST-Firmware.elf\
"

do_install:append() {
    install -d ${D}/home/root/M4_Firmware/BST-Firmware
    install -m 0744 ${WORKDIR}/fw_cortex_m4.sh ${D}/home/root/M4_Firmware/BST-Firmware

    install -d ${D}/home/root/M4_Firmware/BST-Firmware/lib/firmware
    install -m 0744 ${WORKDIR}/BST-Firmware.elf ${D}/home/root/M4_Firmware/BST-Firmware/lib/firmware
}

FILES:${PN} += "\
    /home/root/M4_Firmware/BST-Firmware/fw_cortex_m4.sh \
    /home/root/M4_Firmware/BST-Firmware/lib/firmware/BST-Firmware.elf \
"
