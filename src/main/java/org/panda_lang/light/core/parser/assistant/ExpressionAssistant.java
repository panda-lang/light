package org.panda_lang.light.core.parser.assistant;

import org.panda_lang.panda.lang.PString;

public class ExpressionAssistant {

    public static PString parseString(String expression) {
        return new PString(expression.substring(1, expression.length() - 1));
    }

}
