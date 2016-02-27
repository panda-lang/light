package org.panda_lang.light;

import org.panda_lang.light.core.memory.Variables;

import java.io.File;

public class ExampleTest {

    public static void main(String[] args) {
        Light light = new Light();
        light.initializeDefaultElements();

        Variables variables = light.getLightCore().getVariables();
        variables.getFollowed().getStorage().initializeDatabase(new File("database"));
        variables.load();

        File script = new File("examples/full_example.light");
        LightScript lightScript = light.getLightLoader().load(script);

        lightScript.callEvent("load");
        light.getLightCore().getVariables().save();
    }

}
