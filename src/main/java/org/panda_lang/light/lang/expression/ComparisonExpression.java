package org.panda_lang.light.lang.expression;

import org.panda_lang.light.core.element.expression.Expression;
import org.panda_lang.light.core.Ray;
import org.panda_lang.panda.core.parser.essential.util.Numeric;
import org.panda_lang.panda.core.parser.essential.util.NumericUtils;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.lang.BooleanEssence;

public class ComparisonExpression extends Expression {

    @Override
    public Essence getValue(Ray ray) {
        boolean flag;
        switch (ray.getPattern().getIndex()) {
            case 0:
                BooleanEssence andA = ray.getValueOfFactor(0);
                BooleanEssence andB = ray.getValueOfFactor(1);
                flag = andA.getBoolean() && andB.getBoolean();
                break;
            case 1:
                BooleanEssence orA = ray.getValueOfFactor(0);
                BooleanEssence orB = ray.getValueOfFactor(1);
                flag = orA.getBoolean() || orB.getBoolean();
                break;
            case 2:
                Essence notEqualsA = ray.getValueOfFactor(0);
                Essence notEqualsB = ray.getValueOfFactor(1);
                flag = !notEqualsA.equals(notEqualsB);
                break;
            case 3:
                Numeric greaterThanOrEqualsA = ray.getValueOfFactor(0);
                Numeric greaterThanOrEqualsB = ray.getValueOfFactor(1);
                return NumericUtils.isGreaterThanOrEquals(greaterThanOrEqualsA, greaterThanOrEqualsB);
            case 4:
                Numeric greaterThanA = ray.getValueOfFactor(0);
                Numeric greaterThanB = ray.getValueOfFactor(1);
                return NumericUtils.isGreaterThan(greaterThanA, greaterThanB);
            case 5:
                Numeric lessThanOrEqualsA = ray.getValueOfFactor(0);
                Numeric lessThanOrEqualsB = ray.getValueOfFactor(1);
                return NumericUtils.isLessThanOrEquals(lessThanOrEqualsA, lessThanOrEqualsB);
            case 6:
                Numeric lessThanA = ray.getValueOfFactor(0);
                Numeric lessThanB = ray.getValueOfFactor(1);
                return NumericUtils.isLessThan(lessThanA, lessThanB);
            case 7:
                Essence equalsA = ray.getValueOfFactor(0);
                Essence equalsB = ray.getValueOfFactor(1);
                flag = equalsA.equals(equalsB);
                break;
            default:
                flag = false;
                break;
        }

        return new BooleanEssence(flag);
    }

}
