package org.panda_lang.light.lang.expression;

import org.panda_lang.light.core.Expression;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.util.Modification;
import org.panda_lang.panda.core.memory.Memory;
import org.panda_lang.panda.core.syntax.Essence;

public class VariableExpression extends Expression {

    private final String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public void modify(Modification modification) {
        Ray ray = modification.getRay();
        Memory memory = ray.getMemory();
        Essence value = modification.getValue() != null ? modification.getValue().run(ray) : null;

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
    public Essence getValue(Ray ray) {
        return ray.getMemory().get(variableName);
    }

}
