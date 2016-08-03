package org.panda_lang.light.core.memory;

import org.panda_lang.panda.core.Inst;

public class Variable {

    private final String variableName;
    private Inst value;

    public Variable(String variableName) {
        this.variableName = variableName;
    }

    public Inst getValue() {
        return value;
    }

    public void setValue(Inst value) {
        this.value = value;
    }

    public String getVariableName() {
        return variableName;
    }

}
