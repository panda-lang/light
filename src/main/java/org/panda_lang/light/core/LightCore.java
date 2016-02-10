package org.panda_lang.light.core;

import org.panda_lang.light.Light;
import org.panda_lang.light.LightBasis;
import org.panda_lang.light.core.parser.PhraseCenter;
import org.panda_lang.light.core.parser.util.PhraseRepresentation;
import org.panda_lang.light.core.phrase.Phrases;
import org.panda_lang.panda.Panda;

public class LightCore {

    private final Panda panda;
    private final Light light;
    private final PhraseCenter phraseCenter;

    public LightCore(Panda panda, Light light) {
        this.panda = panda;
        this.light = light;
        this.phraseCenter = new PhraseCenter();
    }

    public void initialize() {
        LightBasis lightBasis = light.getLightBasis();
        lightBasis.loadParsers();
        lightBasis.loadBlocks();

        Phrases phrases = new Phrases(this);
        phrases.registerDefaultPhrases();
    }

    public void registerPhrase(PhraseRepresentation phrase) {
        phraseCenter.registerPhrase(phrase);
    }

    public PhraseCenter getPhraseCenter() {
        return phraseCenter;
    }

    public Light getLight() {
        return light;
    }

    public Panda getPanda() {
        return panda;
    }

}
