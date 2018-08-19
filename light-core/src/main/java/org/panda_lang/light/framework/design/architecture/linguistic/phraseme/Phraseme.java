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

package org.panda_lang.light.framework.design.architecture.linguistic.phraseme;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.architecture.value.TypeValue;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPattern;
import org.panda_lang.panda.language.runtime.ExecutableBranch;

public class Phraseme {

    private final LinguisticPattern pattern;
    private final LinguisticAct act;

    public Phraseme(LinguisticPattern pattern, LinguisticAct act) {
        this.pattern = pattern;
        this.act = act;
    }

    public Phraseme(LinguisticPattern pattern, PhrasemeCallback callback) {
        this.pattern = pattern;
        this.act = new LinguisticAct() {
            @Override
            public TypeValue perform(ExecutableBranch branch, LinguisticAct... parameters) {
                Object[] convertedParameters = new Object[parameters.length];

                for (int i = 0; i < parameters.length; i++) {
                    convertedParameters[i] = parameters[i].perform(branch).getObject();
                }

                callback.call(branch, convertedParameters);
                return null;
            }

            @Override
            public Type getType() {
                return null;
            }
        };
    }

    public LinguisticAct getAct() {
        return act;
    }

    public LinguisticPattern getPattern() {
        return pattern;
    }

}
