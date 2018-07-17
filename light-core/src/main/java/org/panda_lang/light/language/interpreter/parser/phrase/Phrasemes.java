package org.panda_lang.light.language.interpreter.parser.phrase;

import java.util.Collection;
import java.util.HashSet;

public class Phrasemes {

    private final Collection<Phraseme> phrasemes = new HashSet<>();


    public void registerPhraseme(Phraseme phraseme) {
        phrasemes.add(phraseme);
    }



}
