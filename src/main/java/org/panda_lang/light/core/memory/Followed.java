package org.panda_lang.light.core.memory;

import org.panda_lang.light.LightCore;

import java.util.HashMap;
import java.util.Map;

public class Followed {

    private final Variables variables;
    private final Map<String, Variable> followedVariables;
    private final Storage storage;

    public Followed(Variables variables) {
        this.variables = variables;
        this.followedVariables = new HashMap<>();
        this.storage = new Storage(this);
    }

    public Storage getStorage() {
        return storage;
    }

    public Map<String, Variable> getFollowedVariables() {
        return followedVariables;
    }

    public LightCore getPandaCore() {
        return variables.getLightCore();
    }

}
