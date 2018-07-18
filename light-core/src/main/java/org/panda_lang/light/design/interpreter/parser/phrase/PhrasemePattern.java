/*
 * Copyright (c) 2015-2018 Dzikoysk
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

package org.panda_lang.light.design.interpreter.parser.phrase;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesCandidate;
import org.panda_lang.light.language.interpreter.pattern.phrasem.PhrasemePatternResult;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.LexicalPattern;

public class PhrasemePattern {

    private final LexicalPattern pattern;

    public PhrasemePattern(LexicalPattern pattern) {
        this.pattern = pattern;
    }

    public PhrasemePatternResult match(String sentence, @Nullable PhrasemesCandidate previousResult) {
        return null;
    }

}
