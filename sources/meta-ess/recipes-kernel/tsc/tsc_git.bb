DESCRIPTION = "Tosca FPGA kernel driver"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=b9b7c84bed8ea6fab5a6e3ee89e6fe0e"

SRC_URI = "git://git@gitlab.esss.lu.se/ioxos/tsc;branch=master;protocol=ssh \
           file://0001-Adapt-Makefile-for-Yocto.patch \
           file://0001-Add-license-file.patch \
           file://tsc.conf"
SRCREV = "80bdb02b654fbc0da05dd2c9d8ed5543e1cdf8c5"

S = "${WORKDIR}/git/driver"

inherit module qoriq_build_64bit_kernel

RPROVIDES_${PN} += "kernel-module-tsc"

do_install_append () {
	install -d ${D}${sysconfdir}/modules-load.d
	install -m 0644 ${WORKDIR}/tsc.conf ${D}${sysconfdir}/modules-load.d
}

