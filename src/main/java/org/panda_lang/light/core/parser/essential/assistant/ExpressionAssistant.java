package org.panda_lang.light.core.parser.essential.assistant;

import org.panda_lang.panda.lang.StringEssence;

public class ExpressionAssistant {

    public static StringEssence parseString(String expression) {
        return new StringEssence(expression.substring(1, expression.length() - 1));
    }

}
