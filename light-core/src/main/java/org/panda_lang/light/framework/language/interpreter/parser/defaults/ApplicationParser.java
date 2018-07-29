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

package org.panda_lang.light.framework.language.interpreter.parser.defaults;

import org.panda_lang.light.framework.design.architecture.phraseme.PhrasemesGroup;
import org.panda_lang.light.framework.design.interpreter.lexer.*;
import org.panda_lang.light.framework.design.interpreter.parser.LightComponents;
import org.panda_lang.light.framework.design.interpreter.source.*;
import org.panda_lang.light.framework.language.architecture.LightApplication;
import org.panda_lang.light.framework.language.architecture.LightScript;
import org.panda_lang.light.framework.language.runtime.DefaultLightPhrasemes;
import org.panda_lang.panda.framework.design.interpreter.parser.*;
import org.panda_lang.panda.framework.design.architecture.*;
import org.panda_lang.panda.framework.design.interpreter.*;
import org.panda_lang.panda.framework.design.interpreter.lexer.*;
import org.panda_lang.panda.framework.design.interpreter.parser.component.*;
import org.panda_lang.panda.framework.design.interpreter.parser.generation.casual.*;
import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.registry.*;
import org.panda_lang.panda.framework.design.interpreter.source.*;
import org.panda_lang.panda.framework.design.interpreter.token.*;
import org.panda_lang.panda.framework.design.interpreter.token.distributor.*;
import org.panda_lang.panda.framework.language.*;
import org.panda_lang.panda.framework.language.interpreter.messenger.translators.exception.*;
import org.panda_lang.panda.framework.language.interpreter.parser.PandaParserData;
import org.panda_lang.panda.framework.language.interpreter.parser.defaults.*;
import org.panda_lang.panda.framework.language.interpreter.parser.generation.casual.PandaCasualParserGeneration;

public class ApplicationParser implements Parser {

    private final Interpretation interpretation;

    public ApplicationParser(Interpretation interpretation) {
        this.interpretation = interpretation;
    }

    public LightApplication parse(SourceSet sources) {
        LightApplication application = new LightApplication();

        Language language = interpretation.getLanguage();
        PipelineRegistry pipelineRegistry = language.getParserPipelineRegistry();
        CasualParserGeneration generation = new PandaCasualParserGeneration();

        ParserData baseData = new PandaParserData();
        baseData.setComponent(UniversalComponents.APPLICATION, application);
        baseData.setComponent(UniversalComponents.INTERPRETATION, interpretation);
        baseData.setComponent(UniversalComponents.GENERATION, generation);
        baseData.setComponent(UniversalComponents.PIPELINE, pipelineRegistry);

        ExceptionTranslator exceptionTranslator = new ExceptionTranslator(interpretation);
        interpretation.getMessenger().addMessageTranslator(exceptionTranslator);

        for (Source source : sources) {
            Script script = new LightScript(source.getTitle());
            exceptionTranslator.updateLocation(source.getTitle());

            interpretation.execute(() -> {
                Lexer lexer = new LightLexer(source.getContent());
                TokenizedSource tokenizedSource = lexer.convert();

                // System.out.println(tokenizedSource.toString());

                SourceStream stream = new LightSourceStream(tokenizedSource);
                exceptionTranslator.updateSource(stream);

                ParserData delegatedInfo = baseData.fork();
                delegatedInfo.setComponent(UniversalComponents.SOURCE, tokenizedSource);
                delegatedInfo.setComponent(UniversalComponents.SOURCE_STREAM, stream);
                delegatedInfo.setComponent(UniversalComponents.SCRIPT, script);

                PhrasemesGroup defaultPhrasemes = new PhrasemesGroup();
                defaultPhrasemes.importPhrasemes(new DefaultLightPhrasemes().generate());
                delegatedInfo.setComponent(LightComponents.PHRASEMES, defaultPhrasemes);

                OverallParser parser = new OverallParser(delegatedInfo);
                application.addScript(script);

                while (interpretation.isHealthy() && parser.hasNext()) {
                    parser.parseNext(delegatedInfo);
                }
            });
        }

        return interpretation
                .execute(() -> generation.execute(baseData))
                .execute(() -> application);
    }

}