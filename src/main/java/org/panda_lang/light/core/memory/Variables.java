package org.panda_lang.light.core.memory;

import java.util.HashMap;
import java.util.Map;

public class Variables {

    private final Map<String, Variable> commonVariables;
    private final Storage storage;

    public Variables() {
        this.commonVariables = new HashMap<>();
        this.storage = new Storage();
    }

    public void load() {
        storage.load();
    }

    public void save() {
        storage.save();
    }

    public Storage getStorage() {
        return storage;
    }

    public Map<String, Variable> getCommonVariables() {
        return commonVariables;
    }

}
