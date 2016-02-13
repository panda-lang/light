
on load {
    send "Hello Light" to console

    loop 1 time {
        invoke "ray"
    }

    send 10 > 5 to console

}

function ray {
    send "Hello Panda" to console; send panda version to console // :3
}

