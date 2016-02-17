package org.panda_lang.light.lang;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.core.parser.assistant.PhraseRepresentation;
import org.panda_lang.light.core.parser.pattern.LightPattern;
import org.panda_lang.light.lang.phrase.FunctionPhrase;
import org.panda_lang.light.lang.phrase.ModificationPhrase;
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
                .basis("call")
                .hollow()
                .basis("with")
                .hollow()
                .build(0));
        functionPhrase.pattern(LightPattern.builder()
                .basis("call")
                .hollow()
                .build(1));
        lightCore.registerPhrase(functionPhrase);

        PhraseRepresentation modificationPhrase = new PhraseRepresentation(new ModificationPhrase());
        modificationPhrase.pattern("add * to *");
        modificationPhrase.pattern("set * to *");
        modificationPhrase.pattern("remove * from *");
        modificationPhrase.pattern("delete *");
        lightCore.registerPhrase(modificationPhrase);
    }

}
