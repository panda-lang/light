package org.panda_lang.light.language.interpreter.pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.panda_lang.light.language.interpreter.parser.phrase.*;
import org.panda_lang.light.language.interpreter.pattern.phraseme.PhrasemePattern;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

public class PhrasemePatternTest {

    @Test
    public void testPhrasemePattern() {
        PhrasemePattern pattern = PhrasemePattern.builder()
                .compile("add <string> to <string>")
                .build();

        Phraseme phraseme = new Phraseme(pattern, new PhrasemeCallback() {
            @Override
            public void execute(ExecutableBranch branch) {
                // nvm
            }
        });

        Phrasemes phrasemes = new Phrasemes();
        phrasemes.registerPhraseme(phraseme);

        PhrasemesGroup group = new PhrasemesGroup();
        group.importPhrasemes(phrasemes);

        PhrasemesCandidate candidate = group.find("add \"abc\" to \"def\"", null);

        Assertions.assertTrue(candidate.isMatched());
        Assertions.assertEquals(phraseme, candidate.getPhraseme());
    }

}
