package org.panda_lang.light.lang.expression;

import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.lang.LongInst;

public class SystemExpression extends org.panda_lang.light.core.element.expression.Expression {

    @Override
    public Inst getValue(org.panda_lang.light.core.Ray ray) {
        switch (ray.getPattern().getIndex()) {
            case 0:
                return new LongInst(System.currentTimeMillis());
            case 1:
                return new LongInst(System.nanoTime());
        }
        return null;
    }

}
