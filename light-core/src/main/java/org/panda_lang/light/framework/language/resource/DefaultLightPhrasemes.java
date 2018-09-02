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

package org.panda_lang.light.framework.language.resource;

import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPattern;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.PhrasemeCallback;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.Phrasemes;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

import java.util.Arrays;

public class DefaultLightPhrasemes {

    public Phrasemes generate() {
        Phrasemes defaultPhrasemes = new Phrasemes();

        defaultPhrasemes.registerElement(new Phraseme(
                LinguisticPattern.builder()
                        .compile("send <string> to console")
                        .build(),
                new PhrasemeCallback() {
                    @Override
                    public Object call(ExecutableBranch branch, Object[] convertedParameters) {
                        System.out.println(Arrays.toString(convertedParameters));
                        return null;
                    }
                }
        ));

        defaultPhrasemes.registerElement(new Phraseme(
                LinguisticPattern.builder()
                        .compile("send <boolean> to console")
                        .build(),
                new PhrasemeCallback() {
                    @Override
                    public Object call(ExecutableBranch branch, Object[] convertedParameters) {
                        System.out.println("bool: " + Arrays.toString(convertedParameters));
                        return null;
                    }
                }
        ));

        return defaultPhrasemes;
    }

}
