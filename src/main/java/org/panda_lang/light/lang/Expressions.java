package org.panda_lang.light.lang;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.core.element.expression.ExpressionRepresentation;
import org.panda_lang.light.lang.expression.ComparisonExpression;
import org.panda_lang.light.lang.expression.PandaVersionExpression;
import org.panda_lang.light.lang.expression.SystemExpression;
import org.panda_lang.light.lang.expression.initializer.VariableExpressionInitializer;

public class Expressions {

    private final LightCore lightCore;

    public Expressions(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void registerDefaultExpressions() {
        ExpressionRepresentation variableExpression = new ExpressionRepresentation(new VariableExpressionInitializer());
        lightCore.registerExpression(variableExpression);

        ExpressionRepresentation comparisonExpression = new ExpressionRepresentation(new ComparisonExpression());
        comparisonExpression.pattern("* and *");
        comparisonExpression.pattern("* or *");
        comparisonExpression.pattern("* is not *");
        comparisonExpression.pattern("* is greater than or equals to *");
        comparisonExpression.pattern("* is greater than *");
        comparisonExpression.pattern("* is less than or equals to *");
        comparisonExpression.pattern("* is less than *");
        comparisonExpression.pattern("* is *");
        lightCore.registerExpression(comparisonExpression);

        ExpressionRepresentation pandaVersionExpression = new ExpressionRepresentation(new PandaVersionExpression());
        pandaVersionExpression.pattern("panda version");
        lightCore.registerExpression(pandaVersionExpression);

        ExpressionRepresentation systemExpression = new ExpressionRepresentation(new SystemExpression());
        systemExpression.pattern("current time milliseconds");
        systemExpression.pattern("nano time");
        lightCore.registerExpression(systemExpression);
    }

}
