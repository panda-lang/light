package org.panda_lang.light.lang.expression;

import org.panda_lang.light.core.Expression;
import org.panda_lang.light.core.Ray;
import org.panda_lang.panda.core.syntax.Essence;

public class VariableExpression extends Expression {

    @Override
    public void setValue(Ray ray) {
        switch (ray.getModificationType()) {
            case ADD:
            case SET:
                //variable.setValue(ray.getValueOfFactor(0));
                break;
            case REMOVE:
            case DELETE:
                //variable.setValue(null);
                break;
        }
    }

    @Override
    public Essence getValue(Ray ray) {
        return null;
    }

}
