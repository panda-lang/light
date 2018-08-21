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

package org.panda_lang.light.framework.design.interpreter.pattern.linguistic;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;
import org.panda_lang.panda.language.runtime.ExecutableBranch;

public class LinguisticResultUtils {

    public static @Nullable LinguisticAct assignParameters(LinguisticCandidate<LinguisticAct> candidate) {
        LinguisticAct act = candidate.getMatchedElement();

        if (!candidate.isMatched() || act == null) {
            return null;
        }

        if (candidate.getLinguisticResult() != null) {
            LexicalExtractorResult<LinguisticAct> lexicalResult = candidate.getLinguisticResult().getLexicalResult();
            LinguisticAct[] matchedParameters = new LinguisticAct[lexicalResult.getProcessedValues().size()];

            for (int i = 0; i < matchedParameters.length; i++) {
                matchedParameters[i] = lexicalResult.getProcessedValues().get(i).getValue();
            }

            return new LinguisticAct() {
                @Override
                public Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
                    return act.perform(branch, matchedParameters);
                }

                @Override
                public String getType() {
                    return act.getType();
                }
            };
        }

        return act;
    }

}
