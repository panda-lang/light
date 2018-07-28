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

import org.panda_lang.light.design.interpreter.pattern.phraseme.PhrasemePatternResult;

public class PhrasemeCandidate {

    private final boolean matched;
    private PhrasemeRepresentation matchedPhraseme;
    private PhrasemePatternResult patternResult;
    private boolean definite = true; // TODO: lookup

    protected PhrasemeCandidate(boolean matched) {
        this.matched = matched;
    }

    public PhrasemeCandidate(PhrasemeRepresentation matchedPhraseme, PhrasemePatternResult patternResult) {
        this(true);
        this.matchedPhraseme = matchedPhraseme;
        this.patternResult = patternResult;
    }

    public PhrasemeCandidate() {
        this(false);
    }

    public boolean isDefinite() {
        return definite;
    }

    public boolean isMatched() {
        return matched;
    }

    public PhrasemePatternResult getPatternResult() {
        return patternResult;
    }

    public PhrasemeRepresentation getMatchedPhraseme() {
        return matchedPhraseme;
    }

}
