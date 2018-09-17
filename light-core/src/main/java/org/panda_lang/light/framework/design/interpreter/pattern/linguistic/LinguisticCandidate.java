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

public class LinguisticCandidate<T> {

    private static final LinguisticCandidate<?> NOT_MATCHED = new LinguisticCandidate<>(null, null);

    private final T matchedElement;
    private final LinguisticPatternResult<T> linguisticResult;

    public LinguisticCandidate(T matchedElement, LinguisticPatternResult<T> linguisticResult) {
        this.matchedElement = matchedElement;
        this.linguisticResult = linguisticResult;
    }
    public boolean isMatched() {
        return matchedElement != null;
    }

    public LinguisticPatternResult<T> getLinguisticResult() {
        return linguisticResult;
    }

    public T getMatchedElement() {
        return matchedElement;
    }

    @SuppressWarnings("unchecked")
    public static <T> LinguisticCandidate<T> notMatched() {
        return (LinguisticCandidate<T>) NOT_MATCHED;
    }

}
