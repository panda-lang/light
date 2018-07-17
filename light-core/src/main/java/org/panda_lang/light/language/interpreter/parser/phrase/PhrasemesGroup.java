package org.panda_lang.light.language.interpreter.parser.phrase;

import java.util.Collection;
import java.util.HashSet;

public class PhrasemesGroup {

    private final Collection<Phrasemes> group = new HashSet<>();

    public void importPhrasemes(Phrasemes phrasemes) {
        group.add(phrasemes);
    }

    public Collection<? extends Phrasemes> getPhrasemes() {
        return group;
    }

}
