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

package org.panda_lang.light.design.interpreter;

import org.panda_lang.light.design.architecture.*;
import org.panda_lang.light.design.interpreter.parser.defaults.*;
import org.panda_lang.panda.framework.design.interpreter.*;
import org.panda_lang.panda.framework.design.interpreter.messenger.*;
import org.panda_lang.panda.framework.design.interpreter.source.*;
import org.panda_lang.panda.framework.language.interpreter.*;

public class LightInterpreter implements Interpreter {

    private final LightEnvironment environment;

    public LightInterpreter(LightEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public LightApplication interpret(SourceSet sources) {
        Interpretation interpretation = new PandaInterpretation(environment, this, environment.getLanguage());

        ApplicationParser parser = new ApplicationParser(interpretation);
        LightApplication application = parser.parse(sources);

        if (!interpretation.isHealthy()) {
            interpretation.getMessenger().sendMessage(MessengerMessage.Level.FAILURE, "Interpretation failed, cannot parse specified sources");
            return null;
        }

        return application;
    }

    public LightEnvironment getEnvironment() {
        return environment;
    }

}
