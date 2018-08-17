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

package org.panda_lang.light.framework.language.runtime;

import org.panda_lang.light.framework.design.architecture.phraseme.Phraseme;
import org.panda_lang.light.framework.design.architecture.phraseme.PhrasemeCallback;
import org.panda_lang.light.framework.design.architecture.phraseme.PhrasemeRepresentation;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.phraseme.Phrasemes;
import org.panda_lang.light.framework.design.architecture.value.TypeValue;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPattern;
import org.panda_lang.panda.language.runtime.ExecutableBranch;

public class DefaultLightPhrasemes {

    public Phrasemes generate() {
        PhrasemeRepresentation sendRepresentation = new PhrasemeRepresentation(
                LinguisticPattern.builder()
                    .compile("send * to console")
                    .build(),
                new Phraseme(new PhrasemeCallback(null) {
                    @Override
                    public TypeValue perform(ExecutableBranch branch) {
                        System.out.println("Test val");
                        return null;
                    }
                }));

        Phrasemes defaultPhrasemes = new Phrasemes();
        defaultPhrasemes.registerPhraseme(sendRepresentation);

        return defaultPhrasemes;
    }

}
