on load {

    set panda version to "0.0.1"

    if true {
        send "Hello Light" to console
    }

    loop 1 time {
        call "pandaInfo"
    }

    while true {
        send 5 is greater than 10 to console
    }

}

function pandaInfo {
    send "Hello Panda" to console
    send panda version to console
}

