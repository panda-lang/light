# Light [![Build Status](https://travis-ci.org/panda-lang/light.svg?branch=master)](https://travis-ci.org/panda-lang/light)

Light is an English-like programming language built on the top of the Panda Framework and Panda Programming Language.
<br>
<br>
Website: [light.panda-lang.org](https://light.panda-lang.org/)
<br>
Panda Programming Language: [panda-lang.org](https://panda-lang.org/)
<br>
#### Example
```javascript
module ExampleProject

import light by dzikoysk > 1.0.0
import bukkit by dzikoysk > 2.0.0
import lib-utils by lily > *

command /version {
    send "ExampleProject {version of ExampleProject}" to player
}

on player join {
    if player has played before {
        send "Hello {player's name}!" to player and end
    }

    set <:account:balance> to {configuration:default balance}
}

phraseme 'version of ExampleProject' {
    return version of project
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
    <version>indev-18.10.6</version>
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
Repository: [repo.panda-lang.org](https://repo.panda-lang.org/)
```xml
<repositories>
    <repository>
        <id>panda-repository</id>
        <name>Panda Repository</name>
        <url>https://repo.panda-lang.org/</url>
    </repository>
</repositories>
```
