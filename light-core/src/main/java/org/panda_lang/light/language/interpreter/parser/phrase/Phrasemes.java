package org.panda_lang.light.language.interpreter.parser.phrase;

import org.panda_lang.light.language.interpreter.pattern.phrasem.PhrasemePatternResult;

import java.util.Collection;
import java.util.HashSet;

public class Phrasemes {

    private final Collection<Phraseme> phrasemes = new HashSet<>();

    public void registerPhraseme(Phraseme phraseme) {
        phrasemes.add(phraseme);
    }

    public PhrasemePatternResult find(String sentence) {
        for (Phraseme phraseme : phrasemes) {
            //phraseme.getPattern()
        }

        return null;
    }

}
