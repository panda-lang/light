package org.panda_lang.light.core;

import org.panda_lang.light.LightCore;
import org.panda_lang.panda.core.parser.ParserInfo;

import java.util.List;

public class Flash {

    private final LightCore light;
    private final ParserInfo parserInfo;

    public Flash(LightCore light, ParserInfo parserInfo) {
        this.light = light;
        this.parserInfo = parserInfo;
    }

    public org.panda_lang.light.core.element.expression.ExpressionRuntime parseExpression(String expression) {
        org.panda_lang.light.core.parser.ExpressionParser expressionParser = new org.panda_lang.light.core.parser.ExpressionParser(light);
        return expressionParser.parse(parserInfo, expression);
    }

    public String getFullPhrase() {
        return parserInfo.getBlockInfo().getSpecifiersAsPhrase();
    }

    public List<String> getSpecifiers() {
        return parserInfo.getBlockInfo().getSpecifiers();
    }

    public ParserInfo getParserInfo() {
        return parserInfo;
    }

    public LightCore getLight() {
        return light;
    }

}
