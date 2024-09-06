SUMMARY = "ZF Webapp RS"
HOMEPAGE = "https://github.com/DMGDy/zf-webapp-rs"
LICENSE = "CLOSED"

SRC_URI += "git://git@github.com/DMGDy/zf-webapp-rs.git;protocol=ssh;nobranch=1;branch=main"

SRCREV = "${AUTOREV}"

DEPENDS += "trunk-bin-native openssl-native cargo-bin-native gcc "
DEPENDS += "virtual/libc virtual/${TARGET_PREFIX}compilerlibs llvm-native clang-native"

TOOLCHAIN = "clang"
TOOLCHAIN:pn-${PN} = "clang"


CARGO_TARGET_WASM32_UNKNOWN_UNKNOWN_LINKER = "${STAGING_BINDIR_NATIVE}/wasm-ld"

do_compile[network] = "1"
do_fetch_wasm32_target[network] = "1"
inherit cargo_bin
TARGET_CC = "${CC}"
do_fetch_wasm32_target() {
    wget https://static.rust-lang.org/dist/rust-std-1.80.0-wasm32-unknown-unknown.tar.gz -O ${WORKDIR}/rust-std-wasm32-unknown-unknown.tar.gz
}
addtask fetch_wasm32_target after do_fetch before do_unpack

do_unpack_wasm32_target() {
    tar -xzf ${WORKDIR}/rust-std-wasm32-unknown-unknown.tar.gz -C ${WORKDIR}
}
addtask unpack_wasm32_target after do_unpack before do_configure

do_install_wasm32_target() {
    RUSTC_SYSROOT=$(rustc --print sysroot)
    RUSTC_VERSION=$(rustc --version | awk '{print $2}')
    mkdir -p ${RUSTC_SYSROOT}/lib/rustlib/
    cp -r ${WORKDIR}/rust-std-${RUSTC_VERSION}-wasm32-unknown-unknown/rust-std-wasm32-unknown-unknown/lib/rustlib/wasm32-unknown-unknown ${RUSTC_SYSROOT}/lib/rustlib/
}
addtask install_wasm32_target after do_configure before do_compile

do_compile() {
    
    export CC="${STAGING_BINDIR_NATIVE}/clang"
    export LD="${STAGING_BINDIR_NATIVE}/ld.lld"
    export PATH="${STAGING_BINDIR_NATIVE}:$PATH"

    bbplain "CC: ${CC}"
    bbplain "LD: ${LD}"
    bbplain "PATH: $PATH"
    which clang
    clang --version

    export LD_LIBRARY_PATH=${STAGING_LIBDIR_NATIVE}:$LD_LIBRARY_PATH
    export PATH="${STAGING_BINDIR_TOOLCHAIN}:${STAGING_BINDIR_NATIVE}:$PATH"
    export RUSTFLAGS="${RUSTFLAGS} -C linker=${STAGING_BINDIR_NATIVE}/wasm-ld"
    export CC_wasm32_unknown_unknown="${STAGING_BINDIR_NATIVE}/clang"
    export AR_wasm32_unknown_unknown="${STAGING_BINDIR_NATIVE}/llvm-ar"
    export CARGO_TARGET_WASM32_UNKNOWN_UNKNOWN_LINKER="${STAGING_BINDIR_NATIVE}/wasm-ld"
    export CROSS_COMPILE="${TARGET_PREFIX}"
    cd ${WORKDIR}/git
    trunk build --release --verbose
}


do_install() {
    install -d ${D}/var/www/html
    cp -R ${WORKDIR}/git/dist/* ${D}/var/www/html/
}

FILES:${PN} += "/var/www/html"
