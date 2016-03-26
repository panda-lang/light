package org.panda_lang.moonlight.lang;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.element.expression.ExpressionRepresentation;
import org.panda_lang.moonlight.lang.expression.ComparisonExpression;
import org.panda_lang.moonlight.lang.expression.PandaVersionExpression;
import org.panda_lang.moonlight.lang.expression.SystemExpression;
import org.panda_lang.moonlight.lang.expression.initializer.VariableExpressionInitializer;
import org.panda_lang.moonlight.util.MoonlightElements;

public class Expressions implements MoonlightElements {

    private final MoonlightCore moonlightCore;

    public Expressions(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    @Override
    public void registerDefaultElements() {
        ExpressionRepresentation variableExpression = new ExpressionRepresentation(new VariableExpressionInitializer());
        moonlightCore.registerExpression(variableExpression);

        ExpressionRepresentation comparisonExpression = new ExpressionRepresentation(new ComparisonExpression());
        comparisonExpression.pattern("* and *");
        comparisonExpression.pattern("* or *");
        comparisonExpression.pattern("* is not *");
        comparisonExpression.pattern("* is greater than or equals to *");
        comparisonExpression.pattern("* is greater than *");
        comparisonExpression.pattern("* is less than or equals to *");
        comparisonExpression.pattern("* is less than *");
        comparisonExpression.pattern("* is *");
        moonlightCore.registerExpression(comparisonExpression);

        ExpressionRepresentation pandaVersionExpression = new ExpressionRepresentation(new PandaVersionExpression());
        pandaVersionExpression.pattern("panda version");
        moonlightCore.registerExpression(pandaVersionExpression);

        ExpressionRepresentation systemExpression = new ExpressionRepresentation(new SystemExpression());
        systemExpression.pattern("current time milliseconds");
        systemExpression.pattern("nano time");
        moonlightCore.registerExpression(systemExpression);
    }

}
