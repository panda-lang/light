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
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractor;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorWorker;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.processed.WildcardProcessor;

public class LinguisticExtractor implements LexicalExtractor<LinguisticAct> {

    private final Context context;
    private final LinguisticPattern pattern;
    private final @Nullable LinguisticCandidate<LinguisticAct> previousCandidate;

    public LinguisticExtractor(Context context, LinguisticPattern pattern, @Nullable LinguisticCandidate<LinguisticAct> previousResult) {
        this.pattern = pattern;
        this.context = context;
        this.previousCandidate = previousResult;
    }

    @Override
    public LexicalExtractorResult<LinguisticAct> extract(String phrase) {
        WildcardProcessor<LinguisticAct> wildcardProcessor = null;

        if (pattern.getWildcardProcessor() != null) {
            wildcardProcessor = wildcard -> pattern.getWildcardProcessor().handle(context, wildcard, previousCandidate);
        }

        if (wildcardProcessor == null && pattern.getLexicalPattern().hasWildcardProcessor()) {
            wildcardProcessor = pattern.getLexicalPattern().getWildcardProcessor();
        }

        LexicalExtractorWorker<LinguisticAct> extractorWorker = new LexicalExtractorWorker<>(wildcardProcessor);
        return extractorWorker.extract(pattern.getLexicalPattern().getModel(), phrase);
    }

}
