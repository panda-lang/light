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

package org.panda_lang.light.design.architecture.phraseme;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.design.interpreter.pattern.phraseme.PhrasemePattern;
import org.panda_lang.light.design.interpreter.pattern.phraseme.PhrasemePatternResult;

import java.util.Collection;
import java.util.HashSet;

public class Phrasemes {

    private final Collection<PhrasemeRepresentation> phrasemeRepresentations = new HashSet<>();

    public void registerPhraseme(PhrasemeRepresentation phraseme) {
        phrasemeRepresentations.add(phraseme);
    }

    public PhrasemeCandidate find(PhrasemesGroup group, String sentence, @Nullable PhrasemeCandidate previousResult) {
        for (PhrasemeRepresentation representation : phrasemeRepresentations) {
            PhrasemeCandidate candidate = this.match(representation, sentence, group, previousResult);

            if (candidate.isMatched()) {
                return candidate;
            }
        }

        return new PhrasemeCandidate();
    }

    private PhrasemeCandidate match(PhrasemeRepresentation representation, String sentence, PhrasemesGroup group, @Nullable PhrasemeCandidate previousResult) {
        PhrasemePattern pattern = representation.getPattern();
        PhrasemePatternResult result = pattern.match(sentence, group, previousResult);

        if (result == null || !result.isMatched()) {
            return new PhrasemeCandidate();
        }

        return new PhrasemeCandidate(representation, result);
    }

}
