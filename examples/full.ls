// Event 'on load' called when the script starts
on load {
    // Display 'Hello Light' in console
    send "Hello Light" to console

    // If-statement
    if true {
        // Set [var] variable to text
        set <var> to "Variable Test"
        // Display content of [var] variable in console
        send [var] to console

        // Delete [var] variable
        delete [var]
        // Display content of [var] variable in console
        send [var] to console
    }

    // Loop once
    loop 1 time {
        // Call function named 'pandaInfo'
        call "pandaInfo"
    }

    // Set [int] variable to 0
    set [int] to 0
    // Loop when [int] variable is less than 1
    while [int] is less than 1 {
        // Display expression
        send 5 is greater than 10 to console
        // Set [int] variable to 1 (This will complete the loop)
        set [int] to 1
    }
}

// Function 'pandaInfo'
function pandaInfo {
    // Display text in console
    send "Hello Panda" to console
    // Display Panda's version in console
    send panda version to console
}


