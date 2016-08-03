package org.panda_lang.light.lang.expression.initializer;

import org.panda_lang.panda.core.parser.ParserInfo;

public class VariableExpressionInitializer implements org.panda_lang.light.core.element.expression.ExpressionInitializer {

    @Override
    public org.panda_lang.light.core.element.expression.ExpressionRuntime initialize(ParserInfo parserInfo) {
        org.panda_lang.light.core.Ray ray = new org.panda_lang.light.core.Ray();
        String expression = parserInfo.getSourceCode();
        String variableName = expression.substring(1, expression.length() - 1);
        org.panda_lang.light.lang.expression.VariableExpression variableExpression = new org.panda_lang.light.lang.expression.VariableExpression(variableName);
        return new org.panda_lang.light.core.element.expression.ExpressionRuntime(variableExpression, ray);
    }

    @Override
    public boolean match(String expression) {
        return expression.charAt(0) == '<';
    }

}
