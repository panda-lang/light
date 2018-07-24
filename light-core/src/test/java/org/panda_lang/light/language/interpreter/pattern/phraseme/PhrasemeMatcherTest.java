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

package org.panda_lang.light.language.interpreter.pattern.phraseme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.panda_lang.light.language.interpreter.parser.phrase.Phraseme;
import org.panda_lang.light.language.interpreter.parser.phrase.Phrasemes;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesCandidate;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesGroup;

public class PhrasemeMatcherTest {

    @Test
    public void testPhrasemePattern() {
        PhrasemePattern pattern = PhrasemePattern.builder()
                .compile("add <string> to <string>")
                .setWildcardProcessor((group, wildcard, previousCandidate) -> {
                    // Fake phraseme
                    return new Phraseme(null, null);
                })
                .build();

        Phraseme phraseme = new Phraseme(pattern, branch -> System.out.println("D:"));

        Phrasemes phrasemes = new Phrasemes();
        phrasemes.registerPhraseme(phraseme);

        PhrasemesGroup group = new PhrasemesGroup();
        group.importPhrasemes(phrasemes);

        PhrasemesCandidate candidate = group.find("add \"abc\" to \"def\"", null);
        Phraseme matchedPhraseme = candidate.getPhraseme();

        Assertions.assertTrue(candidate.isMatched());
        Assertions.assertNotNull(matchedPhraseme);
        Assertions.assertEquals(phraseme, matchedPhraseme);

        matchedPhraseme.execute(null);
    }

}
