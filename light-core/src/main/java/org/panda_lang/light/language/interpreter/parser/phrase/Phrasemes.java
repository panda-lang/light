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

package org.panda_lang.light.language.interpreter.parser.phrase;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.language.interpreter.pattern.phraseme.PhrasemePattern;
import org.panda_lang.light.language.interpreter.pattern.phraseme.PhrasemePatternResult;

import java.util.Collection;
import java.util.HashSet;

public class Phrasemes {

    private final Collection<Phraseme> phrasemes = new HashSet<>();

    public void registerPhraseme(Phraseme phraseme) {
        phrasemes.add(phraseme);
    }

    public PhrasemeCandidate find(PhrasemesGroup group, String sentence, @Nullable PhrasemeCandidate previousResult) {
        for (Phraseme phraseme : phrasemes) {
            PhrasemeCandidate candidate = this.match(phraseme, sentence, group, previousResult);

            if (candidate.isMatched()) {
                return candidate;
            }
        }

        return new PhrasemeCandidate();
    }

    private PhrasemeCandidate match(Phraseme phraseme, String sentence, PhrasemesGroup group, @Nullable PhrasemeCandidate previousResult) {
        PhrasemePattern pattern = phraseme.getPattern();
        PhrasemePatternResult result = pattern.match(sentence, group, previousResult);

        if (result == null || !result.isMatched()) {
            return new PhrasemeCandidate();
        }


        return new PhrasemeCandidate(phraseme, result);
    }

}
