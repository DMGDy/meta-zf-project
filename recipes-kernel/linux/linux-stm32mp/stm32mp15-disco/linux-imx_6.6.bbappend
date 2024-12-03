FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://imx8dxl-rivian-ccu.dts \
            file://ccu_defconfig \
            file://0001-Add-ccu-dtb-to-freescale-Makefile.patch \
            file://0001-remove-extra-2-channels-not-found-on-ccu-board.patch \
            file://0001-Enable-imx_rpmsg_tty-by-default.patch \
            file://lp586x.patch \
            file://0001-linux-imx-disable-dma-on-lpuart1-as-it-will-now-become-serial-debug-uart.patch \
            "

inherit kernel-devicetree

KERNEL_DEVICETREE:append = " freescale/imx8dxl-rivian-ccu.dtb"

do_copy_defconfig:append() {
   cp ${WORKDIR}/ccu_defconfig ${WORKDIR}/defconfig
   cp ${WORKDIR}/ccu_defconfig ${B}/.config
}

do_configure:append() {
   cp ${WORKDIR}/imx8dxl-rivian-ccu.dts ${S}/arch/arm64/boot/dts/freescale
}
