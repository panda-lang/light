/*
 * Copyright (c) 2015-2018 Dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.light.language.interpreter.parsers.scope;

import org.panda_lang.light.design.interpreter.parser.defaults.*;
import org.panda_lang.light.design.interpreter.source.*;
import org.panda_lang.light.language.interpreter.parsers.*;
import org.panda_lang.panda.design.interpreter.parser.pipeline.registry.*;
import org.panda_lang.panda.framework.design.interpreter.parser.*;
import org.panda_lang.panda.framework.design.interpreter.parser.component.*;
import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.*;
import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.registry.*;
import org.panda_lang.panda.framework.design.interpreter.token.*;
import org.panda_lang.panda.framework.design.interpreter.token.distributor.*;
import org.panda_lang.panda.utilities.redact.match.text.*;

@ParserRegistration(target = UniversalPipelines.OVERALL, parserClass = ScopeParser.class, handlerClass = ScopeParserHandler.class)
public class ScopeParser implements UnifiedParser {

    private static final TextHollowPattern PATTERN = TextHollowPattern.builder()
            .compile("* { * }")
            .build();

    @Override
    public void parse(ParserData data) {
        SourceStream sourceStream = data.getComponent(UniversalComponents.SOURCE_STREAM);

        TokenRepresentation declarationSignature = sourceStream.read();
        data.setComponent(ScopeComponents.DECLARATION, declarationSignature);

        PipelineRegistry pipelineRegistry = data.getComponent(UniversalComponents.PIPELINE);
        ParserPipeline pipeline = pipelineRegistry.getPipeline(LightPipelines.SCOPE);

        SourceStream declarationSignatureStream = new LightSourceStream(declarationSignature);
        UnifiedParser scopeParser = pipeline.handle(declarationSignatureStream);

        ContentParser contentParser = new ContentParser();
        TokenRepresentation[] content = contentParser.parse(data);
        data.setComponent(ScopeComponents.CONTENT, content);

        scopeParser.parse(data);
    }

}
