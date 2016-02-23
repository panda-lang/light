package org.panda_lang.light.lang.phrase;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.core.Expression;
import org.panda_lang.light.core.Phrase;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.util.ExpressionRuntime;
import org.panda_lang.light.lang.expression.VariableExpression;
import org.panda_lang.panda.core.memory.Global;

public class DeclarationPhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        LightCore lightCore = ray.getLightScript().getLight().getLightCore();
        ExpressionRuntime expressionRuntime = ray.getExpressionRuntimes().get(0);
        Expression expression = expressionRuntime.getExpression();

        if (expression instanceof VariableExpression) {
            VariableExpression variableExpression = (VariableExpression) expression;
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
