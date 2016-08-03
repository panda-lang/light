package org.panda_lang.light;

import java.io.File;
import java.io.FileFilter;

public class LightLauncher {

    public static void main(String[] args) {
        LightCore light = new LightCore();
        light.initializeDefaultElements();

        org.panda_lang.light.core.memory.Variables variables = light.getVariables();
        variables.getFollowed().getStorage().initializeDatabase(new File("database"));
        variables.load();

        File currentDirectory = new File(".");
        File[] scripts = currentDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".lightmc");
            }
        });

        if (scripts == null || scripts.length < 1) {
            System.out.println("File '*.lightmc' not found");
            return;
        }

        LightLoader lightLoader = light.getLightLoader();
        for (File lightFile : scripts) {
            LightScript lightScript = lightLoader.load(lightFile);
            light.registerScript(lightScript);
            lightScript.callEvent("load", null);
        }

        light.getVariables().save();
    }

}
