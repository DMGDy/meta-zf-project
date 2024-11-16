FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://stm32mp157f-dk2.dts"

PACKAGE_ARCH = "${MACHINE_ARCH}"
do_configure:append() {
   cp ${WORKDIR}/stm32mp157f-dk2.dts ${S}/arch/arm/boot/dts/
}

KERNEL_CONFIG_FRAGMENTS += "${WORKDIR}/fragments/${LINUX_VERSION}/fragment-07-can.config"

SRC_URI += "file://${LINUX_VERSION}/fragment-07-can.config;subdir=fragments"
