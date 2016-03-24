#Moonlight

Moonlight is a English-like programming language built on the core of the Panda Programming Language.
<br>
<br>
Website: https://moonlight.panda-lang.org/
<br>
Panda Language: https://panda-lang.org/
<br>
#### Example
```javascript
// Event 'on load' called when the script starts
on load {
    // Display 'Hello Moonlight' in console
    send "Hello Moonlight" to console

    // If-statement
    if true {
        // Set <var> variable to text
        set <var> to "Variable Test"
        // Display content of <var> variable in console
        send <var> to console

        // Delete <var> variable
        delete <var>
        // Display content of <var> variable in console
        send <var> to console
    }

    // Loop once
    loop 1 time {
        // Call function named 'pandaInfo'
        call "pandaInfo"
    }

    // Set <int> variable to 0
    set <int> to 0
    // Loop when <int> variable is less than 1
    while <int> is less than 1 {
        // Display expression
        send 5 is greater than 10 to console
        // Set <int> variable to 1 (This will complete the loop)
        set <int> to 1
    }
}

// Function 'pandaInfo'
function pandaInfo {
    // Display text in console
    send "Hello Panda" to console
    // Display Panda's version in console
    send panda version to console
}
```
#####Goals:
- [x] Blocks
  - [x] Event
  - [x] Function
  - [x] Command
  - [x] Loop
  - [x] While
  - [x] If-then
  - [x] Else-then
  - [x] Runnable
- [x] Types
  - [x] Classes
  - [x] API
- [x] Phrases
  - [x] Classes
  - [x] Parser
  - [x] API
- [x] Expressions
  - [x] Classes
  - [x] Parser
  - [x] Assistant
  - [x] Others
  - [x] API
- [ ] Arguments
  - [x] Classes
  - [ ] Parser
  - [ ] Assistant
  - [ ] Others
  - [ ] API
- [x] Structures
  - [x] Classes
  - [x] API
- [x] Variable system
  - [x] Classes
  - [x] Global
  - [x] Followed
  - [x] Storage
  - [x] Others
- [x] Registration system
  - [x] Phrases
  - [x] Expressions
  - [x] Types
  - [x] Events
  - [x] Commands
  - [x] Functions
  - [ ] Arguments
  - [x] Structures
- [ ] Libraries
- [ ] Repositories
<br>
<br>
- Other goals
  - Access to the Panda
  - Develop API
<br>
<br>

#####Goals::Bukkit:
- [ ] Basic Types
- [ ] Basic Phrases
- [ ] Basic Expressions
- [ ] Events
- [ ] Commands
- [ ] Tasks
- [ ] Extensions API
