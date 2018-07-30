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

package org.panda_lang.light.framework.language;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.LightException;
import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.ParserRegistrationLoader;
import org.panda_lang.panda.framework.design.interpreter.token.Syntax;
import org.panda_lang.panda.framework.design.interpreter.parser.pipeline.registry.PipelineRegistry;
import org.panda_lang.panda.framework.language.Language;

public class LightLanguage implements Language {

    private final PipelineRegistry pipelineRegistry;

    public LightLanguage() {
        ParserRegistrationLoader loader = new ParserRegistrationLoader();
        this.pipelineRegistry = loader.load(LightCore.class);
    }

    @Override
    public PipelineRegistry getParserPipelineRegistry() {
        return pipelineRegistry;
    }

    @Override
    public Syntax getSyntax() {
        throw new LightException("Light does not have declared syntax");
    }

}
