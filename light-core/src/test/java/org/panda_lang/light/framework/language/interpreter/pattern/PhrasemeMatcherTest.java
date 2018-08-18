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

package org.panda_lang.light.framework.language.interpreter.pattern;

import org.junit.jupiter.api.Test;

public class PhrasemeMatcherTest {

    @Test
    public void testPhrasemePattern() {
        /*
        PhrasemeRepresentation fakePhraseme = new PhrasemeRepresentation(null, new Phraseme(null, null));

        LinguisticPattern pattern = LinguisticPattern.builder()
                .compile("add <string> to <string>")
                .setWildcardProcessor((group, wildcard, previousCandidate) -> fakePhraseme)
                .build();

        Phraseme phraseme = new Phraseme(null, new LinguisticAct() {
            @Override
            public TypeValue perform(ExecutableBranch branch) {
                System.out.println("D:");
                return null;
            }

            @Override
            public Type getType() {
                return null;
            }
        });
        PhrasemeRepresentation representation = new PhrasemeRepresentation(pattern, phraseme);

        Phrasemes phrasemes = new Phrasemes();
        phrasemes.registerElement(representation);

        LinguisticPatternContext group = new LinguisticPatternContext();
        group.importElement(phrasemes);

        PhrasemeCandidate candidate = group.find("add \"abc\" to \"def\"", null);
        Assertions.assertTrue(candidate.isMatched());

        PhrasemeRepresentation matchedPhraseme = candidate.getMatchedElement();
        Assertions.assertNotNull(matchedPhraseme);
        Assertions.assertEquals(representation, matchedPhraseme);

        LinguisticPatternResult result = candidate.getLinguisticResult();
        Assertions.assertNotNull(result);

        LexicalExtractorResult<PhrasemeRepresentation> originalResult = result.getLexicalResult();
        Assertions.assertTrue(originalResult.isMatched());

        List<ProcessedValue<PhrasemeRepresentation>> processedValues = originalResult.getProcessedValues();
        Assertions.assertNotNull(processedValues);
        Assertions.assertEquals(2, processedValues.size());

        Assertions.assertEquals(fakePhraseme, processedValues.get(0).getValue());
        Assertions.assertEquals(fakePhraseme, processedValues.get(1).getValue());
        */
    }

}
