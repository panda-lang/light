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

import java.util.*;

public class LexicalPatternNode extends LexicalPatternElement {

    private final List<LexicalPatternElement> elements;
    private final boolean variant;

    public LexicalPatternNode(List<LexicalPatternElement> elements, boolean optional, boolean variant) {
        super.optional = optional;
        this.elements = elements;
        this.variant = variant;
    }

    public LexicalPatternNode(List<LexicalPatternElement> elements, boolean optional) {
        this(elements, optional, false);
    }

    public LexicalPatternNode(boolean optional, boolean variant) {
        this(new ArrayList<>(), optional, variant);
    }

    public LexicalPatternNode(boolean optional) {
        this(new ArrayList<>(), optional);
    }

    protected void add(LexicalPatternElement element) {
        this.elements.add(element);
    }

    protected void addAll(List<LexicalPatternElement> elements) {
        this.elements.addAll(elements);
    }

    public boolean isVariant() {
        return variant;
    }

    public List<LexicalPatternElement> getElements() {
        return elements;
    }

}
