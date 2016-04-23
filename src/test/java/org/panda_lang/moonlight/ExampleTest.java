package org.panda_lang.moonlight;

import org.panda_lang.moonlight.core.memory.Variables;

import java.io.File;

public class ExampleTest {

    public static void main(String[] args) {
        MoonlightCore moonlight = new MoonlightCore();
        moonlight.initializeDefaultElements();

        Variables variables = moonlight.getVariables();
        variables.getFollowed().getStorage().initializeDatabase(new File("database"));
        variables.load();

        File script = new File("examples/arguments.moonlight");
        MoonlightScript moonlightScript = moonlight.getMoonlightLoader().load(script);

        moonlightScript.callEvent("load", null);
        moonlight.getVariables().save();
    }

}
