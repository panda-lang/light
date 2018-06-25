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

import org.panda_lang.panda.utilities.commons.objects.*;

public class LexicalPatternUnit extends DefaultLexicalPatternElement {

    private final String value;

    public LexicalPatternUnit(String element, boolean optional, boolean soft) {
        super.optional = optional;

        if (soft) {
            boolean start = CharacterUtils.isWhitespace(element.charAt(0));
            boolean end = CharacterUtils.isWhitespace(element.charAt(element.length() - 1));
            this.isolationType = Isolation.of(start, end);
        }
        else {
            this.isolationType = Isolation.NONE;
        }

        this.value = soft ? element.trim() : element;
    }

    public String getValue() {
        return value;
    }

}
