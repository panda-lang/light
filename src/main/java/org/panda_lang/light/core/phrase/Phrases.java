package org.panda_lang.light.core.phrase;

import org.panda_lang.light.core.LightCore;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.parser.Phrase;
import org.panda_lang.light.core.parser.util.PhraseRepresentation;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.lang.ArrayEssence;

public class Phrases {

    private final LightCore lightCore;

    public Phrases(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void registerDefaultPhrases() {
        PhraseRepresentation sendPhrase = new PhraseRepresentation(new Phrase() {
            @Override
            public Essence run(Ray ray) {
                String message = ray.getValueOfFactor(0).toString();
                System.out.println(message);
                return null;
            }
        });
        sendPhrase.registerPattern("send * to console");
        lightCore.registerPhrase(sendPhrase);

        PhraseRepresentation functionPhrase = new PhraseRepresentation(new Phrase() {
            @Override
            public Essence run(Ray ray) {
                String functionName = ray.getValueOfFactor(0).toString();
                if (ray.getPattern().getID() == 0) {
                    ArrayEssence arrayEssence = ray.getValueOfFactor(1);

                }
                return ray.getLightScript().callFunction(functionName, ray.getFactors());
            }
        });
        functionPhrase.registerPattern("invoke * with *");
        functionPhrase.registerPattern("invoke *");
        lightCore.registerPhrase(functionPhrase);
    }

}
