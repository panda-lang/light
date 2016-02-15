on load {
    send "Hello Light" to console

    loop 1 time {
        invoke "pandaInfo"
    }

    while true {
        send 5 > 10 to console
    }

}

function pandaInfo {
    send "Hello Panda" to console
    send panda version to console
}

