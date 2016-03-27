package org.panda_lang.moonlight.core.element.phrase;

import org.panda_lang.moonlight.core.util.Representation;

public class PhraseRepresentation extends Representation<Phrase> {

    private final Phrase phrase;
    private int raw;

    public PhraseRepresentation(Phrase phrase) {
        this.phrase = phrase;
        this.raw = 0;
    }

    public void disableTranslation(int i) {
        this.raw = i;
    }

    public int getRaw() {
        return raw;
    }

    public Phrase getPhrase() {
        return phrase;
    }

}
