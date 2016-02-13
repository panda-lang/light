package org.panda_lang.light.lang;

import org.panda_lang.light.core.LightCore;
import org.panda_lang.light.core.parser.essential.assistant.PhraseRepresentation;
import org.panda_lang.light.core.parser.essential.pattern.LightPattern;
import org.panda_lang.light.lang.phrase.FunctionPhrase;
import org.panda_lang.light.lang.phrase.PrintPhrase;

public class Phrases {

    private final LightCore lightCore;

    public Phrases(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void registerDefaultPhrases() {
        PhraseRepresentation sendPhrase = new PhraseRepresentation(new PrintPhrase());
        sendPhrase.pattern("send * to console");
        lightCore.registerPhrase(sendPhrase);

        PhraseRepresentation functionPhrase = new PhraseRepresentation(new FunctionPhrase());

        functionPhrase.pattern(LightPattern.builder()
                .basis("invoke").variant("call")
                .hollow()
                .basis("with")
                .hollow()
                .build(0));

        functionPhrase.pattern("invoke *");

        lightCore.registerPhrase(functionPhrase);
    }

}
