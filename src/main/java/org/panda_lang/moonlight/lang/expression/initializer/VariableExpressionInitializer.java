package org.panda_lang.moonlight.lang.expression.initializer;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.ExpressionInitializer;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.lang.expression.VariableExpression;
import org.panda_lang.panda.core.parser.ParserInfo;

public class VariableExpressionInitializer implements ExpressionInitializer {

    @Override
    public ExpressionRuntime initialize(ParserInfo parserInfo) {
        Ray ray = new Ray();
        String expression = parserInfo.getSourceCode();
        String variableName = expression.substring(1, expression.length() - 1);
        VariableExpression variableExpression = new VariableExpression(variableName);
        return new ExpressionRuntime(variableExpression, ray);
    }

    @Override
    public boolean match(String expression) {
        return expression.charAt(0) == '<';
    }

}
