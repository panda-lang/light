package org.panda_lang.light.lang;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.core.parser.assistant.ExpressionRepresentation;
import org.panda_lang.light.lang.expression.ComparisonExpression;
import org.panda_lang.light.lang.expression.PandaVersionExpression;

public class Expressions {

    private final LightCore lightCore;

    public Expressions(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void registerDefaultExpressions() {
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
    }

}
