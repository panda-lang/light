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

import org.panda_lang.light.design.interpreter.parser.LightComponents;
import org.panda_lang.light.design.interpreter.parser.LightParserException;
import org.panda_lang.light.language.interpreter.parsers.LightPipelines;
import org.panda_lang.panda.framework.design.interpreter.parser.ParserInfo;
import org.panda_lang.panda.framework.design.interpreter.parser.UnifiedParser;
import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.ParserPipeline;
import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.registry.ParserPipelineRegistry;
import org.panda_lang.panda.framework.design.interpreter.token.distributor.SourceStream;

public class OverallParser implements UnifiedParser {

    @Override
    public void parse(ParserInfo info) {
        ParserPipelineRegistry parserPipelineRegistry = info.getComponent(LightComponents.PARSER_PIPELINE);
        ParserPipeline pipeline = parserPipelineRegistry.getPipeline(LightPipelines.OVERALL);

        SourceStream sourceStream = info.getComponent(LightComponents.SOURCE);
        UnifiedParser parser = pipeline.handle(sourceStream);

        if (parser == null) {
            throw new LightParserException("Cannot find parser for source " + sourceStream.toTokenizedSource().toString());
        }


    }

}
