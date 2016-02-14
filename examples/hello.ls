on load {
    send "Hello Light" to console

    loop 1 time {
        invoke "ray"
    }

    while true {
        send 5 > 10 to console
    }

}

function ray {
    send "Hello Panda" to console; send panda version to console // :3
}

