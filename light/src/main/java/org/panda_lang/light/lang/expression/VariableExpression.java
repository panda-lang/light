package org.panda_lang.light.lang.expression;

import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.memory.Memory;

public class VariableExpression extends org.panda_lang.light.core.element.expression.Expression {

    private final String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public void modify(org.panda_lang.light.core.util.Modification modification) {
        org.panda_lang.light.core.Ray ray = modification.getRay();
        Memory memory = ray.getAlice().getMemory();
        Inst value = modification.getValue() != null ? modification.getValue().get(ray) : null;

        switch (modification.getType()) {
            case ADD:
                break;
            case SET:
                memory.put(variableName, value);
                break;
            case REMOVE:
                break;
            case DELETE:
                memory.delete(variableName);
                break;
        }
    }

    @Override
    public Inst getValue(org.panda_lang.light.core.Ray ray) {
        return ray.getAlice().getMemory().get(variableName);
    }

    public String getVariableName() {
        return variableName;
    }

}
