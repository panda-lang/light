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

import org.panda_lang.light.language.interpreter.parser.phrase.Phraseme;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.LexicalPattern;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.processed.WildcardProcessor;

public class PhrasemePatternBuilder {

    private LexicalPattern<Phraseme> pattern;
    private PhrasemeWildcardProcessor wildcardProcessor;

    public PhrasemePatternBuilder compile(String pattern) {
        PhrasemePatternCompiler compiler = new PhrasemePatternCompiler(pattern);
        compiler.compile();

        this.pattern = compiler.getLexicalPattern();
        return this;
    }

    public PhrasemePatternBuilder setWildcardProcessor(WildcardProcessor<Phraseme> wildcardProcessor) {
        pattern.setWildcardProcessor(wildcardProcessor);
        return this;
    }

    public PhrasemePatternBuilder setWildcardProcessor(PhrasemeWildcardProcessor wildcardProcessor) {
        this.wildcardProcessor = wildcardProcessor;
        return this;
    }

    public PhrasemePattern build() {
        return new PhrasemePattern(pattern, wildcardProcessor);
    }

}
