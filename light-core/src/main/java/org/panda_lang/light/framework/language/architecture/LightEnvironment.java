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

package org.panda_lang.light.framework.language.architecture;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.framework.language.LightLanguage;
import org.panda_lang.light.framework.language.interpreter.LightInterpreter;
import org.panda_lang.panda.framework.design.architecture.Environment;
import org.panda_lang.panda.framework.design.architecture.module.ModulePath;

public class LightEnvironment implements Environment {

    private final LightLanguage language;
    private final LightInterpreter interpreter;

    public LightEnvironment(LightCore lightCore) {
        this.language = lightCore.getLanguage();
        this.interpreter = new LightInterpreter(this);
    }

    @Override
    public ModulePath getModulePath() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public LightInterpreter getInterpreter() {
        return interpreter;
    }

    public LightLanguage getLanguage() {
        return language;
    }

}
