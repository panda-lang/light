package org.panda_lang.moonlight.lang.expression;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.parser.essential.util.Numeric;
import org.panda_lang.panda.core.parser.essential.util.NumericUtils;
import org.panda_lang.panda.lang.BooleanInst;

public class ComparisonExpression extends Expression {

    @Override
    public Inst getValue(Ray ray) {
        final boolean flag;
        switch (ray.getPattern().getIndex()) {
            case 0:
                BooleanInst andA = ray.getDefaultExpressionValue(0);
                BooleanInst andB = ray.getDefaultExpressionValue(1);
                flag = andA.getBoolean() && andB.getBoolean();
                break;
            case 1:
                BooleanInst orA = ray.getDefaultExpressionValue(0);
                BooleanInst orB = ray.getDefaultExpressionValue(1);
                flag = orA.getBoolean() || orB.getBoolean();
                break;
            case 2:
                Inst notEqualsA = ray.getDefaultExpressionValue(0);
                Inst notEqualsB = ray.getDefaultExpressionValue(1);
                flag = !notEqualsA.equals(notEqualsB);
                break;
            case 3:
                Numeric greaterThanOrEqualsA = ray.getDefaultExpressionValue(0);
                Numeric greaterThanOrEqualsB = ray.getDefaultExpressionValue(1);
                return NumericUtils.isGreaterThanOrEquals(greaterThanOrEqualsA, greaterThanOrEqualsB);
            case 4:
                Numeric greaterThanA = ray.getDefaultExpressionValue(0);
                Numeric greaterThanB = ray.getDefaultExpressionValue(1);
                return NumericUtils.isGreaterThan(greaterThanA, greaterThanB);
            case 5:
                Numeric lessThanOrEqualsA = ray.getDefaultExpressionValue(0);
                Numeric lessThanOrEqualsB = ray.getDefaultExpressionValue(1);
                return NumericUtils.isLessThanOrEquals(lessThanOrEqualsA, lessThanOrEqualsB);
            case 6:
                Numeric lessThanA = ray.getDefaultExpressionValue(0);
                Numeric lessThanB = ray.getDefaultExpressionValue(1);
                return NumericUtils.isLessThan(lessThanA, lessThanB);
            case 7:
                Inst equalsA = ray.getDefaultExpressionValue(0);
                Inst equalsB = ray.getDefaultExpressionValue(1);
                flag = equalsA.equals(equalsB);
                break;
            default:
                flag = false;
                break;
        }

        return new BooleanInst(flag);
    }

}
