package org.panda_lang.light.core.element.phrase;

import org.panda_lang.light.core.util.Representation;

public class PhraseRepresentation extends Representation<Phrase> {

    private final Phrase phrase;

    public PhraseRepresentation(Phrase phrase) {
        this.phrase = phrase;
    }

    public Phrase getPhrase() {
        return phrase;
    }

}
