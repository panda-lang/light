package org.panda_lang.light.language.interpreter.parser.phrase;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashSet;

public class PhrasemesGroup {

    private final Collection<Phrasemes> group = new HashSet<>();

    public void importPhrasemes(Phrasemes phrasemes) {
        group.add(phrasemes);
    }

    public PhrasemesCandidate find(String sentence, @Nullable PhrasemesCandidate previousResult) {
        for (Phrasemes phrasemes : group) {
            PhrasemesCandidate candidate = phrasemes.find(this, sentence, previousResult);

            if (candidate.isMatched()) {
                return candidate;
            }
        }

        return new PhrasemesCandidate();
    }

    public Collection<? extends Phrasemes> getPhrasemes() {
        return group;
    }

}
