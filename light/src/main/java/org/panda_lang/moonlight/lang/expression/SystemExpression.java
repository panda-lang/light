package org.panda_lang.moonlight.lang.expression;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.lang.LongInst;

public class SystemExpression extends Expression {

    @Override
    public Inst getValue(Ray ray) {
        switch (ray.getPattern().getIndex()) {
            case 0:
                return new LongInst(System.currentTimeMillis());
            case 1:
                return new LongInst(System.nanoTime());
        }
        return null;
    }

}
