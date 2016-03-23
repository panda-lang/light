package org.panda_lang.moonlight.core.memory;

import org.panda_lang.panda.core.syntax.Essence;

public class Variable {

    private final String variableName;
    private Essence value;

    public Variable(String variableName) {
        this.variableName = variableName;
    }

    public Essence getValue() {
        return value;
    }

    public void setValue(Essence value) {
        this.value = value;
    }

    public String getVariableName() {
        return variableName;
    }

}
