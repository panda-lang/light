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

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.PhrasemeCallback;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phrasemes;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticCandidate;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPattern;
import org.panda_lang.panda.language.runtime.ExecutableBranch;

import java.util.Arrays;

public class DefaultLightPhrasemes {

    public Phrasemes generate() {
        Phraseme phraseme = new Phraseme(
                LinguisticPattern.builder()
                        .compile("send * to console")
                        .setWildcardProcessor((context, wildcard, previousCandidate) -> {
                            LinguisticCandidate<LinguisticAct> candidate = context.find(wildcard, previousCandidate);
                            return candidate.isMatched() ? candidate.getMatchedElement() : null;
                        })
                        .build(),
                new PhrasemeCallback() {
                    @Override
                    public Object call(ExecutableBranch branch, Object[] convertedParameters) {
                        System.out.println(Arrays.toString(convertedParameters));
                        return null;
                    }
                }
        );

        Phrasemes defaultPhrasemes = new Phrasemes();
        defaultPhrasemes.registerElement(phraseme);

        return defaultPhrasemes;
    }

}
