package org.panda_lang.light.core.phrase;

import org.panda_lang.light.core.LightCore;
import org.panda_lang.light.core.parser.util.PhraseRepresentation;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Executable;

public class Phrases {

    private final LightCore lightCore;

    public Phrases(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void registerDefaultPhrases() {
        PhraseRepresentation sendPhrase = new PhraseRepresentation(new Executable() {
            @Override
            public Essence run(Particle particle) {
                String message = particle.getValueOfFactor(0).toString();
                System.out.println(message);
                return null;
            }
        });
        sendPhrase.registerPattern("send * to console");
        lightCore.registerPhrase(sendPhrase);
    }

}
