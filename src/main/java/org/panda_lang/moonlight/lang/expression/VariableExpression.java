package org.panda_lang.moonlight.lang.expression;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.util.Modification;
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
        Memory memory = ray.getAlice().getMemory();
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
        return ray.getAlice().getMemory().get(variableName);
    }

    public String getVariableName() {
        return variableName;
    }

}
