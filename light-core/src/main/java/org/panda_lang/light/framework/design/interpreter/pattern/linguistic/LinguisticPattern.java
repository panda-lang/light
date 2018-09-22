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
import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.LexicalPattern;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;

public class LinguisticPattern {

    private final LexicalPattern<LinguisticAct> lexicalPattern;
    private @Nullable LinguisticWildcardProcessor wildcardProcessor;

    public LinguisticPattern(LexicalPattern<LinguisticAct> lexicalPattern, @Nullable LinguisticWildcardProcessor wildcardProcessor) {
        this.lexicalPattern = lexicalPattern;
        this.wildcardProcessor = wildcardProcessor;
    }

    public LinguisticPatternResult match(String sentence, Context context, @Nullable LinguisticCandidate<LinguisticAct> previousResult) {
        LinguisticExtractor extractor = new LinguisticExtractor(context, this, previousResult);
        LexicalExtractorResult<LinguisticAct> result = lexicalPattern.extract(extractor, sentence);

        return new LinguisticPatternResult(result);
    }

    public void setWildcardProcessor(@Nullable LinguisticWildcardProcessor wildcardProcessor) {
        this.wildcardProcessor = wildcardProcessor;
    }

    public boolean hasWildcardProcessor() {
        return wildcardProcessor != null;
    }

    public @Nullable LinguisticWildcardProcessor getWildcardProcessor() {
        return wildcardProcessor;
    }

    public LexicalPattern<LinguisticAct> getLexicalPattern() {
        return lexicalPattern;
    }

    public static LinguisticPatternBuilder builder() {
        return new LinguisticPatternBuilder();
    }

}
