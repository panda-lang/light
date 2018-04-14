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

import org.panda_lang.light.design.architecture.LightApplication;
import org.panda_lang.light.design.architecture.LightScript;
import org.panda_lang.light.design.interpreter.LightInterpreter;
import org.panda_lang.light.design.interpreter.parser.LightComponents;
import org.panda_lang.light.design.interpreter.source.LightSourceStream;
import org.panda_lang.panda.design.interpreter.parser.PandaParserInfo;
import org.panda_lang.panda.framework.design.interpreter.parser.Parser;
import org.panda_lang.panda.framework.design.interpreter.parser.ParserInfo;
import org.panda_lang.panda.framework.design.interpreter.source.Source;
import org.panda_lang.panda.framework.design.interpreter.source.SourceSet;

public class ApplicationParser implements Parser {

    private final LightInterpreter interpreter;

    public ApplicationParser(LightInterpreter interpreter) {
        this.interpreter = interpreter;
    }

    public LightApplication parse(SourceSet sources) {
        LightApplication application = new LightApplication();

        ParserInfo baseInfo = new PandaParserInfo();
        baseInfo.setComponent(LightComponents.APPLICATION, application);
        baseInfo.setComponent(LightComponents.INTERPRETER, interpreter);

        for (Source source : sources) {
            ParserInfo delegatedInfo = baseInfo.fork();

            LightScript script = new LightScript(source.getTitle());
            delegatedInfo.setComponent(LightComponents.SCRIPT, script);

            LightSourceStream stream = new LightSourceStream(source.getContent());
            delegatedInfo.setComponent(LightComponents.SOURCE, stream);

            application.addScript(script);
        }

        return application;
    }

}
