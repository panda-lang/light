package org.panda_lang.light.core.element.phrase;

public class PhraseRepresentation extends org.panda_lang.light.core.util.Representation<Phrase> {

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
