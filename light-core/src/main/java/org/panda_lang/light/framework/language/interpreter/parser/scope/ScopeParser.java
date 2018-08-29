/*
 * Copyright (c) 2016-2018 Dzikoysk
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

package org.panda_lang.light.framework.language.interpreter.parser.scope;

import org.panda_lang.light.framework.design.interpreter.source.LightSourceStream;
import org.panda_lang.light.framework.language.interpreter.parser.LightPipelines;
import org.panda_lang.light.framework.language.interpreter.parser.defaults.ContentParser;
import org.panda_lang.panda.framework.design.architecture.Script;
import org.panda_lang.panda.framework.design.architecture.statement.Scope;
import org.panda_lang.panda.framework.design.interpreter.parser.ParserData;
import org.panda_lang.panda.framework.design.interpreter.parser.UnifiedParser;
import org.panda_lang.panda.framework.design.interpreter.parser.component.UniversalComponents;
import org.panda_lang.panda.framework.design.interpreter.parser.component.UniversalPipelines;
import org.panda_lang.panda.framework.design.interpreter.parser.generation.casual.GenerationLayer;
import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.ParserPipeline;
import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.registry.PipelineRegistry;
import org.panda_lang.panda.framework.design.interpreter.token.stream.SourceStream;
import org.panda_lang.panda.framework.language.interpreter.parser.PandaParserFailure;
import org.panda_lang.panda.framework.language.interpreter.parser.pipeline.ParserRegistration;
import org.panda_lang.panda.framework.language.interpreter.pattern.abyss.AbyssPattern;
import org.panda_lang.panda.framework.language.interpreter.pattern.abyss.redactor.AbyssRedactor;
import org.panda_lang.panda.framework.language.interpreter.pattern.abyss.utils.AbyssPatternAssistant;
import org.panda_lang.panda.framework.language.interpreter.pattern.abyss.utils.AbyssPatternBuilder;
import org.panda_lang.panda.framework.language.resource.PandaSyntax;

@ParserRegistration(target = UniversalPipelines.OVERALL, parserClass = ScopeParser.class, handlerClass = ScopeParserHandler.class)
public class ScopeParser implements UnifiedParser {

    protected static final AbyssPattern PATTERN = new AbyssPatternBuilder()
            .compile(PandaSyntax.getInstance(), "+* { +* }")
            .build();

    @Override
    public boolean parse(ParserData data, GenerationLayer nextLayer) {
        AbyssRedactor redactor = AbyssPatternAssistant.traditionalMapping(PATTERN, data, "scope-declaration", "scope-content");

        data.setComponent(ScopeComponents.DECLARATION, redactor.get("scope-declaration"));
        data.setComponent(ScopeComponents.CONTENT, redactor.get("scope-content"));

        PipelineRegistry pipelineRegistry = data.getComponent(UniversalComponents.PIPELINE);
        ParserPipeline pipeline = pipelineRegistry.getPipeline(LightPipelines.SCOPE);

        SourceStream declarationSignatureStream = new LightSourceStream(data.getComponent(ScopeComponents.DECLARATION));
        UnifiedParser scopeParser = pipeline.handle(declarationSignatureStream);

        scopeParser.parse(data, nextLayer);
        Scope scope = data.getComponent(ScopeComponents.SCOPE);

        if (scope == null) {
            throw new PandaParserFailure("Unknown scope signature", data);
        }

        SourceStream contentStream = new LightSourceStream(data.getComponent(ScopeComponents.CONTENT));
        ParserData contentData = data.fork().setComponent(UniversalComponents.SOURCE_STREAM, contentStream);

        ContentParser contentParser = new ContentParser();
        contentParser.parse(contentData, nextLayer);

        Script script = data.getComponent(UniversalComponents.SCRIPT);
        script.getStatements().add(scope);
        return true;
    }

}
