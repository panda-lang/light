package org.panda_lang.moonlight.core;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.parser.ExpressionParser;
import org.panda_lang.panda.core.parser.ParserInfo;

import java.util.List;

public class Flash {

    private final MoonlightCore moonlight;
    private final ParserInfo parserInfo;

    public Flash(MoonlightCore moonlight, ParserInfo parserInfo) {
        this.moonlight = moonlight;
        this.parserInfo = parserInfo;
    }

    public ExpressionRuntime parseExpression(String expression) {
        ExpressionParser expressionParser = new ExpressionParser(moonlight);
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

    public MoonlightCore getMoonlight() {
        return moonlight;
    }

}
