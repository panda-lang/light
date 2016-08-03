package org.panda_lang.light.core.element.expression;

import org.panda_lang.panda.core.parser.ParserInfo;
import org.panda_lang.panda.core.parser.util.match.Matcher;

public interface ExpressionInitializer extends Matcher {

    ExpressionRuntime initialize(ParserInfo parserInfo);

}
