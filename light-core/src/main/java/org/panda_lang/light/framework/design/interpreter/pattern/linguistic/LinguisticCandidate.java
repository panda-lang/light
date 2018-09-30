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

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;

public class LinguisticCandidate {

    private static final LinguisticCandidate NOT_MATCHED = new LinguisticCandidate(null, null);

    private final LinguisticAct matchedElement;
    private final LinguisticPatternResult linguisticResult;

    public LinguisticCandidate(LinguisticAct matchedElement, LinguisticPatternResult linguisticResult) {
        this.matchedElement = matchedElement;
        this.linguisticResult = linguisticResult;
    }
    public boolean isMatched() {
        return matchedElement != null;
    }

    public LinguisticAct[] getMatchedParameters() {
        if (linguisticResult == null || linguisticResult.getLexicalResult() == null) {
            return new LinguisticAct[0];
        }

        LinguisticAct[] matchedParameters = new LinguisticAct[linguisticResult.getLexicalResult().getProcessedValues().size()];

        for (int i = 0; i < matchedParameters.length; i++) {
            matchedParameters[i] = linguisticResult.getLexicalResult().getProcessedValues().get(i).getValue();
        }

        return matchedParameters;
    }

    public LinguisticPatternResult getLinguisticResult() {
        return linguisticResult;
    }

    public LinguisticAct getMatchedElement() {
        return matchedElement;
    }

    public static LinguisticCandidate notMatched() {
        return NOT_MATCHED;
    }

}
