package org.panda_lang.light.core.parser;

import org.panda_lang.light.core.parser.assistant.PhraseRepresentation;

import java.util.ArrayList;
import java.util.Collection;

public class PhraseCenter {

    private final Collection<PhraseRepresentation> phrases;

    public PhraseCenter() {
        this.phrases = new ArrayList<>();
    }

    public void registerPhrase(PhraseRepresentation phrase) {
        this.phrases.add(phrase);
    }

    public Collection<PhraseRepresentation> getPhrases() {
        return phrases;
    }

}
