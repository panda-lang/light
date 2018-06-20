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

package org.panda_lang.light.design.interpreter.token.lexical;

import org.jetbrains.annotations.*;

import java.util.*;

public class LexicalExtractor {

    private final LexicalPattern pattern;

    public LexicalExtractor(LexicalPattern pattern) {
        this.pattern = pattern;
    }

    public @Nullable List<String> extract(String phrase) {
        List<String> matches = new ArrayList<>();
        LexicalPatternElement mainElement = pattern.getPattern();

        if (mainElement.isUnit()) {
            return mainElement.toUnit().getValue().equals(phrase) ? matches : null;
        }

        String currentPhrase = phrase;
        LexicalPatternNode mainNode = mainElement.toNode();
        int currentIndex = 0;

        for (LexicalPatternElement nodeElement : mainNode.getElements()) {
            if (nodeElement.isUnit()) {
                LexicalPatternUnit unit = nodeElement.toUnit();

                if (unit.isStatic()) {
                    int index = phrase.indexOf(unit.getValue(), currentIndex);

                    if (index == -1) {
                        return null;
                    }

                    currentIndex = index;
                }
            }
        }

        return matches;
    }

}
