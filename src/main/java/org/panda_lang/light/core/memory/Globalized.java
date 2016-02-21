package org.panda_lang.light.core.memory;

import java.util.HashMap;
import java.util.Map;

public class Globalized {

    private final Map<String, Variable> commonVariables;

    public Globalized() {
        this.commonVariables = new HashMap<>();
    }

    public Map<String, Variable> getCommonVariables() {
        return commonVariables;
    }

}
