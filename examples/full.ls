on load {
   send "Hello Light" to console

    if true {
        set [var] to "Variable Test"
        send [var] to console
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