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

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.ContextComponent;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticCandidate;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPatternResult;

import java.util.Collection;
import java.util.HashSet;

public class Phrasemes implements ContextComponent<Phraseme> {

    private final Collection<Phraseme> phrasemes = new HashSet<>();

    @Override
    public LinguisticCandidate<LinguisticAct> recognize(Context context, String sentence, @Nullable LinguisticCandidate<LinguisticAct> previousCandidate) {
        for (Phraseme phraseme : phrasemes) {
            LinguisticPatternResult<LinguisticAct> result = phraseme.getPattern().match(sentence, context, previousCandidate);

            if (result == null || !result.isMatched()) {
                return new LinguisticCandidate<>(false);
            }

            LinguisticCandidate<LinguisticAct> candidate = new LinguisticCandidate<>(phraseme.getAct(), result);

            if (candidate.isMatched()) {
                return candidate;
            }
        }

        return new LinguisticCandidate<>(false);
    }

    @Override
    public void registerElement(Phraseme phraseme) {
        phraseme.getPattern().setWildcardProcessor(PhrasemesWildcardProcessor.getInstance());
        phrasemes.add(phraseme);
    }

    @Override
    public Collection<? extends Phraseme> getElements() {
        return phrasemes;
    }

    @Override
    public Class<?> getComponentType() {
        return Phraseme.class;
    }

}
