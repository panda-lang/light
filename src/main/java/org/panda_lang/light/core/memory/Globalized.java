package org.panda_lang.light.core.memory;

import java.util.HashMap;
import java.util.Map;

public class Globalized {

    private final Variables variables;
    private final Map<String, Variable> commonVariables;

    public Globalized(Variables variables) {
        this.variables = variables;
        this.commonVariables = new HashMap<>();
    }

    public Map<String, Variable> getCommonVariables() {
        return commonVariables;
    }

    public Variables getVariables() {
        return variables;
    }

}
