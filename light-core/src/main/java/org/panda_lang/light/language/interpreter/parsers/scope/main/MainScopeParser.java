package org.panda_lang.light.language.interpreter.parsers.scope.main;


import org.panda_lang.light.language.interpreter.parsers.*;
import org.panda_lang.panda.design.interpreter.parser.pipeline.registry.*;
import org.panda_lang.panda.framework.design.interpreter.parser.*;
import org.panda_lang.panda.framework.design.interpreter.parser.component.*;
import org.panda_lang.panda.framework.design.interpreter.token.distributor.*;

@ParserRegistration(target = LightPipelines.SCOPE, parserClass = MainScopeParser.class, handlerClass = MainScopeParserHandler.class)
public class MainScopeParser implements UnifiedParser {

    @Override
    public void parse(ParserData data) {
        SourceStream sourceStream = data.getComponent(UniversalComponents.SOURCE_STREAM);
        sourceStream.read();
    }

}
