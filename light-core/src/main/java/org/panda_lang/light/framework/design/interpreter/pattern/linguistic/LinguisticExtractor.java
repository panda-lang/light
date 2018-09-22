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
import org.panda_lang.light.LightException;
import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticGroup;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractor;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorWorker;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.processed.WildcardProcessor;

class LinguisticExtractor implements LexicalExtractor<LinguisticGroup> {

    private final Context context;
    private final LinguisticPattern pattern;
    private final @Nullable LinguisticCandidate<LinguisticGroup> previousCandidate;

    LinguisticExtractor(Context context, LinguisticPattern pattern, @Nullable LinguisticCandidate<LinguisticGroup> previousResult) {
        this.pattern = pattern;
        this.context = context;
        this.previousCandidate = previousResult;
    }

    @Override
    public LexicalExtractorResult<LinguisticGroup> extract(String phrase) {
        WildcardProcessor<LinguisticGroup> wildcardProcessor = null;

        if (pattern.getWildcardProcessor() != null) {
            wildcardProcessor = (details, wildcard) -> {
                if (details == null) {
                    throw new LightException("Invalid type, details are not specified for the '" + wildcard + "' wildcard");
                }

                return pattern.getWildcardProcessor().handle(context, details, wildcard, previousCandidate);
            };
        }

        if (wildcardProcessor == null && pattern.getLexicalPattern().hasWildcardProcessor()) {
            wildcardProcessor = pattern.getLexicalPattern().getWildcardProcessor();
        }

        LexicalExtractorWorker<LinguisticGroup> extractorWorker = new LexicalExtractorWorker<>(wildcardProcessor);
        return extractorWorker.extract(pattern.getLexicalPattern().getModel(), phrase);
    }

}
