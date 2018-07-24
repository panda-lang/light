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

package org.panda_lang.light.language.interpreter.pattern.phraseme;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.language.interpreter.parser.phrase.Phraseme;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesCandidate;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesGroup;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.LexicalExtractor;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.LexicalExtractorWorker;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.processed.WildcardProcessor;

public class PhrasemeExtractor implements LexicalExtractor<Phraseme> {

    private final PhrasemePattern pattern;
    private final PhrasemesGroup group;
    private final @Nullable PhrasemesCandidate previousCandidate;

    public PhrasemeExtractor(PhrasemePattern pattern, PhrasemesGroup group, @Nullable PhrasemesCandidate previousResult) {
        this.pattern = pattern;
        this.group = group;
        this.previousCandidate = previousResult;
    }

    @Override
    public LexicalExtractorResult<Phraseme> extract(String phrase) {
        WildcardProcessor<Phraseme> wildcardProcessor = null;

        if (pattern.getWildcardProcessor() != null) {
            wildcardProcessor = wildcard -> pattern.getWildcardProcessor().handle(group, wildcard, previousCandidate);
        }

        if (wildcardProcessor == null && pattern.getLexicalPattern().hasWildcardProcessor()) {
            wildcardProcessor = pattern.getLexicalPattern().getWildcardProcessor();
        }

        LexicalExtractorWorker<Phraseme> extractorWorker = new LexicalExtractorWorker<>(wildcardProcessor);
        return extractorWorker.extract(pattern.getLexicalPattern().getModel(), phrase);
    }

}
