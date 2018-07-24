package org.panda_lang.light.language.interpreter.pattern.phraseme;

import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.panda_lang.light.language.interpreter.parser.phrase.Phraseme;
import org.panda_lang.light.language.interpreter.parser.phrase.Phrasemes;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesCandidate;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesGroup;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.processed.WildcardProcessor;

public class PhrasemeMatcherTest {

    @Test
    public void testPhrasemePattern() {
        PhrasemePattern pattern = PhrasemePattern.builder()
                // add "x" to "y"
                .compile("add <string> to <string>")
                .addWildcardProcessor(new PhrasemeWildcardProcessor() {
                    @Override
                    public Phraseme handle(PhrasemesGroup group, String wildcard, @Nullable PhrasemesCandidate previousCandidate) {
                        return null;
                    }
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
