#Light

Light is a English-like programming language built on the core of the Panda Programming Language.
<br>
<br>
Website: https://light.panda-lang.org/
<br>
Panda Programming Language: https://panda-lang.org/
<br>
#### Example
```javascript
// Event 'on load' called when the script starts
on load {
    // Display 'Hello Light' in console
    send "Hello Light" to console

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
        call pandaInfo
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

#### Repository structure

```
light/
+--examples/                 Example scripts written in Light.
+--light/                    Light module
   +----/src                 All sources of Panda
   +----pom.xml              The main maven build script for Light module
+--lightmc/                  LightMC module
   +------/docs              Temporary documentation for LightMC
   +------/src               All sources of LightMC
   +------pom.xml            The main maven build script for LightMC module
+--pom.xml                   The main maven build script
```

#### Maven

Latest build of Light. Remember, API is not stable yet :o:
```xml
<dependency>
    <groupId>org.panda_lang</groupId>
    <artifactId>light</artifactId>
    <version>indev-0.0.1-SNAPSHOT</version>
</dependency>
```
Latest build of LightMC:
```xml
<dependency>
    <groupId>net.dzikoysk</groupId>
    <artifactId>lightmc</artifactId>
    <version>indev-0.0.1-SNAPSHOT</version>
</dependency>
```
The latest build of the previous edition. Remember, this is deprecated!
```xml
<dependency>
    <groupId>org.panda_lang</groupId>
    <artifactId>light</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```
Repository: https://repo.panda-lang.org/
```xml
<repositories>
    <repository>
        <id>panda-repo</id>
        <className>Panda Repository</className>
        <url>https://repo.panda-lang.org/</url>
    </repository>
</repositories>
```
