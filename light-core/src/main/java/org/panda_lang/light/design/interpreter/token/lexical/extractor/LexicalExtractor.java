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

package org.panda_lang.light.design.interpreter.token.lexical.extractor;

import org.panda_lang.light.design.interpreter.token.lexical.*;
import org.panda_lang.light.design.interpreter.token.lexical.elements.*;
import org.panda_lang.panda.utilities.commons.objects.*;

import java.util.*;

public class LexicalExtractor {

    private final LexicalPattern pattern;

    public LexicalExtractor(LexicalPattern pattern) {
        this.pattern = pattern;
    }

    public LexicalExtractorResult extract(String phrase) {
        LexicalPatternElement mainElement = pattern.getModel();
        return this.extract(mainElement, phrase);
    }

    private LexicalExtractorResult extract(LexicalPatternElement pattern, String phrase) {
        if (pattern.isUnit()) {
            return new LexicalExtractorResult(phrase.equals(pattern.toUnit().getValue()));
        }

        if (pattern.isWildcard()) {
            return new LexicalExtractorResult(true).addWildcard(this.pattern.hasSoftMatching() ? phrase.trim() : phrase);
        }

        LexicalPatternNode node = pattern.toNode();

        if (node.isVariant()) {
            return this.matchVariant(node, phrase);
        }

        List<LexicalPatternElement> elements = node.getElements();
        String[] dynamic = new String[elements.size()];
        boolean isolation = false;
        int index = 0;

        for (int i = index; i < elements.size(); i++) {
            LexicalPatternElement element = elements.get(i);

            if (!element.isUnit()) {
                continue;
            }

            LexicalPatternUnit unit = element.toUnit();

            if (unit.getIsolationType().isStart() && !isolation) {
                ++index;
            }

            int unitIndex = phrase.indexOf(unit.getValue(), index);

            if (unitIndex == -1) {
                if (unit.isOptional()) {
                    continue;
                }

                return new LexicalExtractorResult(false);
            }

            String before = phrase.substring(index, unitIndex).trim();

            if (unit.isOptional() && i + 1 < elements.size() && !StringUtils.isEmpty(before)) {
                LexicalPatternElement nextElement = elements.get(i + 1);
                LexicalExtractorResult result = this.extract(nextElement, before);

                if (!result.isMatched()) {
                    // TODO: Advanced research
                    unitIndex = -unit.getValue().length() + index;
                    before = null;
                }
            }

            isolation = false;

            if (!StringUtils.isEmpty(before)) {
                if (i - 1 < 0) {
                    return new LexicalExtractorResult(false);
                }

                dynamic[i - 1] = before;
            }

            index = unitIndex + unit.getValue().length();

            if (unit.getIsolationType().isEnd()) {
                isolation = true;
                ++index;
            }
        }

        if (index < phrase.length()) {
            dynamic[dynamic.length - 1] = phrase.substring(index, phrase.length());
        }

        LexicalExtractorResult result = new LexicalExtractorResult(true);

        for (int i = 0; i < elements.size(); i++) {
            LexicalPatternElement nodeElement = elements.get(i);

            if (nodeElement.isUnit()) {
                continue;
            }

            if (dynamic.length == 0 && nodeElement.isOptional()) {
                continue;
            }

            String nodeContent = dynamic[i];
            dynamic[i] = null;

            if (nodeContent == null) {
                return new LexicalExtractorResult(false);
            }

            LexicalExtractorResult nodeElementResult = this.extract(nodeElement, nodeContent);

            if (!nodeElementResult.isMatched()) {
                return new LexicalExtractorResult(false);
            }

            result.merge(nodeElementResult);
        }

        for (String dynamicContent : dynamic) {
            if (!StringUtils.isEmpty(dynamicContent)) {
                return new LexicalExtractorResult(false);
            }
        }

        return result;
    }

    private LexicalExtractorResult matchVariant(LexicalPatternNode variantNode, String phrase) {
        if (!variantNode.isVariant()) {
            throw new RuntimeException("The specified node is not marked as a variant node");
        }

        for (LexicalPatternElement variantElement : variantNode.getElements()) {
            LexicalExtractorResult result = this.extract(variantElement, phrase);

            if (result.isMatched()) {
                return result;
            }
        }

        return new LexicalExtractorResult(false);
    }

}
