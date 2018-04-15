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

package org.panda_lang.light.design.interpreter;

import org.panda_lang.light.design.architecture.LightApplication;
import org.panda_lang.light.design.interpreter.parser.defaults.ApplicationParser;
import org.panda_lang.light.language.LightLanguage;
import org.panda_lang.panda.framework.design.interpreter.Interpreter;
import org.panda_lang.panda.framework.design.interpreter.source.SourceSet;

public class LightInterpreter implements Interpreter {

    private final LightLanguage language;

    public LightInterpreter(LightLanguage language) {
        this.language = language;
    }

    @Override
    public LightApplication interpret(SourceSet sources) {
        ApplicationParser parser = new ApplicationParser(this);
        return parser.parse(sources);
    }

    public LightLanguage getLanguage() {
        return language;
    }

}
