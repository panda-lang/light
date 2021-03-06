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
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;

public class LinguisticPatternResult {

    private final boolean matched;
    private LexicalExtractorResult<? extends LinguisticAct> lexicalResult;

    LinguisticPatternResult(boolean matched) {
        this.matched = matched;
    }

    LinguisticPatternResult(LexicalExtractorResult<? extends LinguisticAct> result) {
        this.matched = result.isMatched();
        this.lexicalResult = result;
    }

    public boolean isMatched() {
        return matched;
    }

    public LexicalExtractorResult<? extends LinguisticAct> getLexicalResult() {
        return lexicalResult;
    }

}
