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

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticGroup;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;

public class LinguisticPatternResult {

    private final boolean matched;
    private LexicalExtractorResult<? extends LinguisticGroup> lexicalResult;

    LinguisticPatternResult(boolean matched) {
        this.matched = matched;
    }

    LinguisticPatternResult(LexicalExtractorResult<? extends LinguisticGroup> result) {
        this.matched = result.isMatched();
        this.lexicalResult = result;
    }

    public LinguisticGroup[] getMatchedParameters() {
        LinguisticGroup[] matchedParameters = new LinguisticGroup[lexicalResult.getProcessedValues().size()];

        for (int i = 0; i < matchedParameters.length; i++) {
            matchedParameters[i] = lexicalResult.getProcessedValues().get(i).getValue();
        }

        return matchedParameters;
    }

    public boolean isMatched() {
        return matched;
    }

    public LexicalExtractorResult<? extends LinguisticGroup> getLexicalResult() {
        return lexicalResult;
    }

}
