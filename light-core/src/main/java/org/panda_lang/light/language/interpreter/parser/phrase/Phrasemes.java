package org.panda_lang.light.language.interpreter.parser.phrase;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.language.interpreter.pattern.phraseme.PhrasemePattern;
import org.panda_lang.light.language.interpreter.pattern.phraseme.PhrasemePatternResult;

import java.util.Collection;
import java.util.HashSet;

public class Phrasemes {

    private final Collection<Phraseme> phrasemes = new HashSet<>();

    public void registerPhraseme(Phraseme phraseme) {
        phrasemes.add(phraseme);
    }

    public PhrasemesCandidate find(PhrasemesGroup group, String sentence, @Nullable PhrasemesCandidate previousResult) {
        for (Phraseme phraseme : phrasemes) {
            PhrasemesCandidate candidate = this.match(phraseme, sentence, group, previousResult);

            if (candidate.isMatched()) {
                return candidate;
            }
        }

        return new PhrasemesCandidate();
    }

    private PhrasemesCandidate match(Phraseme phraseme, String sentence, PhrasemesGroup group, @Nullable PhrasemesCandidate previousResult) {
        PhrasemePattern pattern = phraseme.getPattern();
        PhrasemePatternResult result = pattern.match(sentence, group, previousResult);

        if (result == null || !result.isMatched()) {
            return new PhrasemesCandidate();
        }


        return new PhrasemesCandidate(phraseme, result);
    }

}
