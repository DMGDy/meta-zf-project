# Auto-Generated by cargo-bitbake 0.3.16
#

inherit cargo_bin
do_compile[network] = "1"

# If this is git based prefer versioned ones if they exist
# DEFAULT_PREFERENCE = "-1"

# how to get zf-server could be as easy as but default to a git checkout:
# SRC_URI += "crate://crates.io/zf-server/0.1.0"
SRC_URI += "git://git@github.com/DMGDy/zf-webserver-app;protocol=ssh;nobranch=1;branch=main"
SRCREV = "0c4a1ccdb8e7925702c1e55f2e96bb574527c3ab"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""
PV:append = ".AUTOINC+0c4a1ccdb8"

# please note if you have entries that do not begin with crate://
# you must change them to how that package can be fetched
SRC_URI += " \
    crate://crates.io/addr2line/0.22.0 \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/autocfg/1.3.0 \
    crate://crates.io/backtrace/0.3.73 \
    crate://crates.io/base64/0.21.7 \
    crate://crates.io/bitflags/2.6.0 \
    crate://crates.io/block-buffer/0.10.4 \
    crate://crates.io/byteorder/1.5.0 \
    crate://crates.io/bytes/1.7.1 \
    crate://crates.io/cc/1.1.15 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/cpufeatures/0.2.13 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/data-encoding/2.6.0 \
    crate://crates.io/digest/0.10.7 \
    crate://crates.io/encoding_rs/0.8.34 \
    crate://crates.io/equivalent/1.0.1 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/form_urlencoded/1.2.1 \
    crate://crates.io/futures-channel/0.3.30 \
    crate://crates.io/futures-core/0.3.30 \
    crate://crates.io/futures-sink/0.3.30 \
    crate://crates.io/futures-task/0.3.30 \
    crate://crates.io/futures-util/0.3.30 \
    crate://crates.io/generic-array/0.14.7 \
    crate://crates.io/getrandom/0.2.15 \
    crate://crates.io/gimli/0.29.0 \
    crate://crates.io/h2/0.3.26 \
    crate://crates.io/hashbrown/0.14.5 \
    crate://crates.io/headers-core/0.2.0 \
    crate://crates.io/headers/0.3.9 \
    crate://crates.io/hermit-abi/0.3.9 \
    crate://crates.io/http-body/0.4.6 \
    crate://crates.io/http/0.2.12 \
    crate://crates.io/http/1.1.0 \
    crate://crates.io/httparse/1.9.4 \
    crate://crates.io/httpdate/1.0.3 \
    crate://crates.io/hyper/0.14.30 \
    crate://crates.io/idna/0.5.0 \
    crate://crates.io/indexmap/2.4.0 \
    crate://crates.io/itoa/1.0.11 \
    crate://crates.io/libc/0.2.158 \
    crate://crates.io/lock_api/0.4.12 \
    crate://crates.io/log/0.4.22 \
    crate://crates.io/memchr/2.7.4 \
    crate://crates.io/mime/0.3.17 \
    crate://crates.io/mime_guess/2.0.5 \
    crate://crates.io/miniz_oxide/0.7.4 \
    crate://crates.io/mio/1.0.2 \
    crate://crates.io/multer/2.1.0 \
    crate://crates.io/object/0.36.3 \
    crate://crates.io/once_cell/1.19.0 \
    crate://crates.io/parking_lot/0.12.3 \
    crate://crates.io/parking_lot_core/0.9.10 \
    crate://crates.io/percent-encoding/2.3.1 \
    crate://crates.io/pin-project-internal/1.1.5 \
    crate://crates.io/pin-project-lite/0.2.14 \
    crate://crates.io/pin-project/1.1.5 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/ppv-lite86/0.2.20 \
    crate://crates.io/proc-macro2/1.0.86 \
    crate://crates.io/quote/1.0.37 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/redox_syscall/0.5.3 \
    crate://crates.io/rustc-demangle/0.1.24 \
    crate://crates.io/ryu/1.0.18 \
    crate://crates.io/scoped-tls/1.0.1 \
    crate://crates.io/scopeguard/1.2.0 \
    crate://crates.io/serde/1.0.209 \
    crate://crates.io/serde_derive/1.0.209 \
    crate://crates.io/serde_json/1.0.127 \
    crate://crates.io/serde_urlencoded/0.7.1 \
    crate://crates.io/sha1/0.10.6 \
    crate://crates.io/shlex/1.3.0 \
    crate://crates.io/signal-hook-registry/1.4.2 \
    crate://crates.io/slab/0.4.9 \
    crate://crates.io/smallvec/1.13.2 \
    crate://crates.io/socket2/0.5.7 \
    crate://crates.io/spin/0.9.8 \
    crate://crates.io/syn/2.0.76 \
    crate://crates.io/thiserror-impl/1.0.63 \
    crate://crates.io/thiserror/1.0.63 \
    crate://crates.io/tinyvec/1.8.0 \
    crate://crates.io/tinyvec_macros/0.1.1 \
    crate://crates.io/tokio-macros/2.4.0 \
    crate://crates.io/tokio-tungstenite/0.21.0 \
    crate://crates.io/tokio-util/0.7.11 \
    crate://crates.io/tokio/1.39.3 \
    crate://crates.io/tower-service/0.3.3 \
    crate://crates.io/tracing-core/0.1.32 \
    crate://crates.io/tracing/0.1.40 \
    crate://crates.io/try-lock/0.2.5 \
    crate://crates.io/tungstenite/0.21.0 \
    crate://crates.io/typenum/1.17.0 \
    crate://crates.io/unicase/2.7.0 \
    crate://crates.io/unicode-bidi/0.3.15 \
    crate://crates.io/unicode-ident/1.0.12 \
    crate://crates.io/unicode-normalization/0.1.23 \
    crate://crates.io/url/2.5.2 \
    crate://crates.io/utf-8/0.7.6 \
    crate://crates.io/version_check/0.9.5 \
    crate://crates.io/want/0.3.1 \
    crate://crates.io/warp/0.3.7 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/windows-sys/0.52.0 \
    crate://crates.io/windows-targets/0.52.6 \
    crate://crates.io/windows_aarch64_gnullvm/0.52.6 \
    crate://crates.io/windows_aarch64_msvc/0.52.6 \
    crate://crates.io/windows_i686_gnu/0.52.6 \
    crate://crates.io/windows_i686_gnullvm/0.52.6 \
    crate://crates.io/windows_i686_msvc/0.52.6 \
    crate://crates.io/windows_x86_64_gnu/0.52.6 \
    crate://crates.io/windows_x86_64_gnullvm/0.52.6 \
    crate://crates.io/windows_x86_64_msvc/0.52.6 \
    crate://crates.io/zerocopy-derive/0.7.35 \
    crate://crates.io/zerocopy/0.7.35 \
"



# FIXME: update generateme with the real MD5 of the license file
LIC_FILES_CHKSUM = " \
    "

SUMMARY = "zf-server"
HOMEPAGE = "git@github.com:DMGDy/zf-webserver-app.git"
LICENSE = "CLOSED"

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include zf-server-${PV}.inc
include zf-server.inc
