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

package org.panda_lang.light.design.interpreter.token.lexical.elements;

public interface LexicalPatternElement {

    int getId();

    boolean isOptional();

    Isolation getIsolationType();

    void setIsolationType(Isolation isolationType);

    default boolean hasId() {
        return getId() != -1;
    }

    default boolean isVariant() {
        return this.isNode() && this.toNode().isVariant();
    }

    default boolean isWildcard() {
        return this instanceof LexicalPatternWildcard;
    }

    default boolean isNode() {
        return this instanceof LexicalPatternNode;
    }

    default boolean isUnit() {
        return this instanceof LexicalPatternUnit;
    }

    default LexicalPatternWildcard toWildcard() {
        return (LexicalPatternWildcard) this;
    }

    default LexicalPatternNode toNode() {
        return (LexicalPatternNode) this;
    }

    default LexicalPatternUnit toUnit() {
        return (LexicalPatternUnit) this;
    }

    enum Isolation {

        NONE(false, false),
        START(true, false),
        END(false, true),
        BOTH(true, true);

        private final boolean start, end;

        Isolation(boolean start, boolean end) {
            this.start = start;
            this.end = end;
        }

        public boolean isStart() {
            return start;
        }

        public boolean isEnd() {
            return end;
        }

        public static LexicalPatternUnit.Isolation of(boolean start, boolean end) {
            for (LexicalPatternUnit.Isolation isolation : values()) {
                if (isolation.start == start && isolation.end == end) {
                    return isolation;
                }
            }

            return LexicalPatternUnit.Isolation.NONE;
        }

    }

}
