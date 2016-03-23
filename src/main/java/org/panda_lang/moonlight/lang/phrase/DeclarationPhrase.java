package org.panda_lang.moonlight.lang.phrase;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.element.phrase.Phrase;
import org.panda_lang.moonlight.lang.expression.VariableExpression;
import org.panda_lang.panda.core.memory.Global;

public class DeclarationPhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        MoonlightCore moonlightCore = ray.getMoonlightScript().getMoonlight().getMoonlightCore();
        ExpressionRuntime expressionRuntime = ray.getExpressionRuntimes().get(0);
        Expression expression = expressionRuntime.getExpression();

        if (expression instanceof VariableExpression) {
            VariableExpression variableExpression = (VariableExpression) expression;
            String variableName = variableExpression.getVariableName();

            if (!Global.COMMON_MEMORY.containsKey(variableName)) {
                Global.COMMON_MEMORY.put(variableName, null);
            }

            if (ray.getPattern().getIndex() == 0) {
                moonlightCore.getVariables().getFollowed().add(variableName);
            }

        }
    }

}
