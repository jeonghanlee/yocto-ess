DESCRIPTION = "Tosca FPGA kernel driver tool"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://COPYING;md5=b7fb7d87d0bc8c4c871ab8499e28463d"

INSANE_SKIP_${PN} = "ldflags"
RDEPENDS_${PN} = " bash tsc"

SRC_URI = "git://git@gitlab.esss.lu.se/ioxos/tsc;branch=master;protocol=ssh \
           file://0001-Run-command-and-exit.patch \
           file://0001-Enable-FMCs-before-exiting.patch \
           file://0001-Add-license-file.patch"
SRCREV = "e0a9b52b186797f3abd179a381f52ed0617755b2"

S = "${WORKDIR}/git/src/TscMon"

do_compile_prepend() {
    cd ../../lib
    make
    cd ../src/TscMon
}

do_install() {
    install -d ${D}/usr/bin

    cp ${S}/TscMon ${D}/usr/bin/TscMon
    ln -sf TscMon ${D}/usr/bin/tscmon
}

