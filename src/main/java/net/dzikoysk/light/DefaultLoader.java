package net.dzikoysk.light;

import java.io.File;

public class DefaultLoader {

    private final File directory;

    public DefaultLoader(File directory) {
        this.directory = directory;
    }

    public void load() {

    }

    public File getDirectory() {
        return directory;
    }

}
