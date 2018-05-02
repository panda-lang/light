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

package org.panda_lang.light.design.interpreter.parser.defaults;

import org.panda_lang.light.design.architecture.*;
import org.panda_lang.light.design.interpreter.*;
import org.panda_lang.light.design.interpreter.lexer.*;
import org.panda_lang.light.design.interpreter.parser.*;
import org.panda_lang.light.design.interpreter.source.*;
import org.panda_lang.light.language.*;
import org.panda_lang.light.language.interpreter.parsers.*;
import org.panda_lang.panda.design.interpreter.parser.*;
import org.panda_lang.panda.design.interpreter.parser.defaults.*;
import org.panda_lang.panda.design.interpreter.parser.generation.*;
import org.panda_lang.panda.framework.design.interpreter.parser.*;
import org.panda_lang.panda.framework.design.interpreter.parser.component.*;
import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.*;
import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.registry.*;
import org.panda_lang.panda.framework.design.interpreter.source.*;
import org.panda_lang.panda.framework.design.interpreter.token.*;

public class ApplicationParser implements Parser {

    private final LightInterpreter interpreter;

    public ApplicationParser(LightInterpreter interpreter) {
        this.interpreter = interpreter;
    }

    public LightApplication parse(SourceSet sources) {
        ParserData baseInfo = new PandaParserData();
        baseInfo.setComponent(LightComponents.INTERPRETER, interpreter);

        LightEnvironment environment = interpreter.getEnvironment();
        baseInfo.setComponent(UniversalComponents.ENVIRONMENT, environment);

        LightApplication application = new LightApplication();
        baseInfo.setComponent(UniversalComponents.APPLICATION, application);

        PandaCasualParserGeneration generation = new PandaCasualParserGeneration();
        baseInfo.setComponent(UniversalComponents.GENERATION, generation);

        LightLanguage language = environment.getLanguage();
        PipelineRegistry pipelineRegistry = language.getParserPipelineRegistry();
        baseInfo.setComponent(UniversalComponents.PIPELINE, pipelineRegistry);

        for (Source source : sources) {
            ParserData delegatedInfo = baseInfo.fork();

            LightScript script = new LightScript(source.getTitle());
            delegatedInfo.setComponent(UniversalComponents.SCRIPT, script);

            LightLexer lexer = new LightLexer(source.getContent());
            TokenizedSource tokenizedSource = lexer.convert();

            LightSourceStream stream = new LightSourceStream(tokenizedSource);
            delegatedInfo.setComponent(UniversalComponents.SOURCE_STREAM, stream);

            ParserPipeline pipeline = pipelineRegistry.getPipeline(LightPipelines.OVERALL);
            OverallParser parser = new OverallParser(pipeline, generation, stream);

            while (parser.hasNext()) {
                parser.next(delegatedInfo);
            }

            application.addScript(script);
        }

        generation.execute(baseInfo);

        return application;
    }

}
