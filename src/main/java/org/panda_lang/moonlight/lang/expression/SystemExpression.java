package org.panda_lang.moonlight.lang.expression;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.lang.LongEssence;

public class SystemExpression extends Expression {

    @Override
    public Essence getValue(Ray ray) {
        switch (ray.getPattern().getIndex()) {
            case 0:
                return new LongEssence(System.currentTimeMillis());
            case 1:
                return new LongEssence(System.nanoTime());
        }
        return null;
    }

}