package org.panda_lang.light;

import java.io.File;

public class ExampleTest {

    public static void main(String[] args) {
        Light light = new Light();
        light.initializeDefaultElements();

        File script = new File("examples/full_example.light");
        LightScript lightScript = light.getLightLoader().load(script);

        lightScript.callEvent("load");
    }

}
