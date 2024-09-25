FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI += "\
    file://wifi.cfg \
    file://ipc.cfg \
    "

KERNEL_IMAGETYPE = "uImage"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
