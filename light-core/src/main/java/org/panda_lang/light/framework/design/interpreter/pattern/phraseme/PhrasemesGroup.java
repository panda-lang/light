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

package org.panda_lang.light.framework.design.interpreter.pattern.phraseme;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashSet;

public class PhrasemesGroup {

    private final Collection<Phrasemes> group;

    private PhrasemesGroup(Collection<Phrasemes> group) {
        this.group = new HashSet<>(group);
    }

    public PhrasemesGroup() {
        this(new HashSet<>());
    }

    public PhrasemeCandidate find(String sentence, @Nullable PhrasemeCandidate previousResult) {
        for (Phrasemes phrasemes : group) {
            PhrasemeCandidate candidate = phrasemes.find(this, sentence, previousResult);

            if (candidate.isMatched()) {
                return candidate;
            }
        }

        return new PhrasemeCandidate();
    }

    public void importPhrasemes(Phrasemes phrasemes) {
        group.add(phrasemes);
    }

    public PhrasemesGroup fork() {
        return new PhrasemesGroup(group);
    }

    public Collection<? extends Phrasemes> getPhrasemes() {
        return group;
    }

}
