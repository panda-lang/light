package org.panda_lang.light.language.interpreter.parsers.scope.main;

import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.*;
import org.panda_lang.panda.framework.design.interpreter.token.reader.*;

public class MainScopeParserHandler implements ParserHandler {

    @Override
    public boolean handle(TokenReader reader) {
        return reader.read().getTokenValue().equals("main");
    }

}
