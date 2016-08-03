package org.panda_lang.light;

import java.io.File;

public class ExampleTest {

    public static void main(String[] args) {
        LightCore light = new LightCore();
        light.initializeDefaultElements();

        org.panda_lang.light.core.memory.Variables variables = light.getVariables();
        variables.getFollowed().getStorage().initializeDatabase(new File("database"));
        variables.load();

        File script = new File("examples/arguments.lightmc");
        LightScript lightScript = light.getLightLoader().load(script);

        lightScript.callEvent("load", null);
        light.getVariables().save();
    }

}
