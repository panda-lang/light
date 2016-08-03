package org.panda_lang.light.lang;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.util.LightElements;

public class Expressions implements LightElements {

    private final LightCore lightCore;

    public Expressions(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    @Override
    public void registerDefaultElements() {
        org.panda_lang.light.core.element.expression.ExpressionRepresentation variableExpression = new org.panda_lang.light.core.element.expression.ExpressionRepresentation(new org.panda_lang.light.lang.expression.initializer.VariableExpressionInitializer());
        lightCore.registerExpression(variableExpression);

        org.panda_lang.light.core.element.expression.ExpressionRepresentation comparisonExpression = new org.panda_lang.light.core.element.expression.ExpressionRepresentation(new org.panda_lang.light.lang.expression.ComparisonExpression());
        comparisonExpression.pattern("* and *");
        comparisonExpression.pattern("* or *");
        comparisonExpression.pattern("* is not *");
        comparisonExpression.pattern("* is greater than or equals to *");
        comparisonExpression.pattern("* is greater than *");
        comparisonExpression.pattern("* is less than or equals to *");
        comparisonExpression.pattern("* is less than *");
        comparisonExpression.pattern("* is *");
        lightCore.registerExpression(comparisonExpression);

        org.panda_lang.light.core.element.expression.ExpressionRepresentation pandaVersionExpression = new org.panda_lang.light.core.element.expression.ExpressionRepresentation(new org.panda_lang.light.lang.expression.PandaVersionExpression());
        pandaVersionExpression.pattern("panda version");
        lightCore.registerExpression(pandaVersionExpression);

        org.panda_lang.light.core.element.expression.ExpressionRepresentation systemExpression = new org.panda_lang.light.core.element.expression.ExpressionRepresentation(new org.panda_lang.light.lang.expression.SystemExpression());
        systemExpression.pattern("current time milliseconds");
        systemExpression.pattern("nano time");
        lightCore.registerExpression(systemExpression);

        org.panda_lang.light.core.element.expression.ExpressionRepresentation arrayExpression = new org.panda_lang.light.core.element.expression.ExpressionRepresentation(new org.panda_lang.light.lang.expression.ArrayExpression());
        arrayExpression.pattern("* element of *");
        lightCore.registerExpression(arrayExpression);
    }

}
