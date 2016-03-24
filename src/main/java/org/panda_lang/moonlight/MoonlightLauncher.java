package org.panda_lang.moonlight;

import org.panda_lang.moonlight.core.memory.Variables;

import java.io.File;
import java.io.FileFilter;

public class MoonlightLauncher {

    public static void main(String[] args) {
        MoonlightCore moonlight = new MoonlightCore();
        moonlight.initializeDefaultElements();

        Variables variables = moonlight.getVariables();
        variables.getFollowed().getStorage().initializeDatabase(new File("database"));
        variables.load();

        File currentDirectory = new File(".");
        File[] scripts = currentDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".moonlight");
            }
        });

        if (scripts == null || scripts.length < 1) {
            System.out.println("File '*.moonlight' not found");
            return;
        }

        MoonlightLoader moonlightLoader = moonlight.getMoonlightLoader();
        for (File moonlightFile : scripts) {
            MoonlightScript moonlightScript = moonlightLoader.load(moonlightFile);
            moonlight.registerScript(moonlightScript);
            moonlightScript.callEvent("load", null);
        }

        moonlight.getVariables().save();
    }

}
