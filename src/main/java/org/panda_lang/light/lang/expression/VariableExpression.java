package org.panda_lang.light.lang.expression;

import org.panda_lang.light.core.Expression;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.util.Modification;
import org.panda_lang.panda.core.syntax.Essence;

public class VariableExpression extends Expression {

    @Override
    public void modify(Modification modification) {
        super.modify(modification);
    }

    @Override
    public Essence getValue(Ray ray) {
        return super.getValue(ray);
    }

}
