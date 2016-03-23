package org.panda_lang.moonlight;

import org.panda_lang.moonlight.core.memory.Variables;

import java.io.File;

public class ExampleTest {

    public static void main(String[] args) {
        Moonlight moonlight = new Moonlight();
        moonlight.initializeDefaultElements();

        Variables variables = moonlight.getMoonlightCore().getVariables();
        variables.getFollowed().getStorage().initializeDatabase(new File("database"));
        variables.load();

        File script = new File("examples/full_example.luminosity");
        MoonlightScript moonlightScript = moonlight.getMoonlightLoader().load(script);

        moonlightScript.callEvent("load");
        moonlight.getMoonlightCore().getVariables().save();
    }

}
