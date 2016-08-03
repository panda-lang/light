package org.panda_lang.light.lang.phrase;

import org.panda_lang.light.LightCore;
import org.panda_lang.panda.core.memory.Global;

public class DeclarationPhrase implements org.panda_lang.light.core.element.phrase.Phrase {

    @Override
    public void run(org.panda_lang.light.core.Ray ray) {
        LightCore lightCore = ray.getLightScript().getLight();
        org.panda_lang.light.core.element.expression.ExpressionRuntime expressionRuntime = ray.getExpressionRuntimes().get(0);
        org.panda_lang.light.core.element.expression.Expression expression = expressionRuntime.getExpression();

        if (expression instanceof org.panda_lang.light.lang.expression.VariableExpression) {
            org.panda_lang.light.lang.expression.VariableExpression variableExpression = (org.panda_lang.light.lang.expression.VariableExpression) expression;
            String variableName = variableExpression.getVariableName();

            if (!Global.COMMON_MEMORY.containsKey(variableName)) {
                Global.COMMON_MEMORY.put(variableName, null);
            }

            if (ray.getPattern().getIndex() == 0) {
                lightCore.getVariables().getFollowed().add(variableName);
            }

        }
    }

}
