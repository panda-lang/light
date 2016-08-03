package org.panda_lang.light.lang;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.lang.phrase.*;
import org.panda_lang.light.util.LightElements;

public class Phrases implements LightElements {

    private final LightCore lightCore;

    public Phrases(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    @Override
    public void registerDefaultElements() {
        org.panda_lang.light.core.element.phrase.PhraseRepresentation declarationPhrase = new org.panda_lang.light.core.element.phrase.PhraseRepresentation(new DeclarationPhrase());
        declarationPhrase.pattern("follow *");
        declarationPhrase.pattern("global *");
        lightCore.registerPhrase(declarationPhrase);

        org.panda_lang.light.core.element.phrase.PhraseRepresentation functionPhrase = new org.panda_lang.light.core.element.phrase.PhraseRepresentation(new FunctionPhrase());
        functionPhrase.pattern("call * with *");
        functionPhrase.pattern("call *");
        functionPhrase.disableTranslation(1);
        lightCore.registerPhrase(functionPhrase);

        org.panda_lang.light.core.element.phrase.PhraseRepresentation returnPhrase = new org.panda_lang.light.core.element.phrase.PhraseRepresentation(new ReturnPhrase());
        returnPhrase.pattern("return");
        returnPhrase.pattern("return *");
        lightCore.registerPhrase(returnPhrase);

        org.panda_lang.light.core.element.phrase.PhraseRepresentation modificationPhrase = new org.panda_lang.light.core.element.phrase.PhraseRepresentation(new ModificationPhrase());
        modificationPhrase.pattern("add * to *");
        modificationPhrase.pattern("set * to *");
        modificationPhrase.pattern("remove * from *");
        modificationPhrase.pattern("delete *");
        lightCore.registerPhrase(modificationPhrase);

        org.panda_lang.light.core.element.phrase.PhraseRepresentation benchmarkPhrase = new org.panda_lang.light.core.element.phrase.PhraseRepresentation(new BenchmarkPhrase());
        benchmarkPhrase.pattern("initialize benchmark");
        benchmarkPhrase.pattern("benchmark point");
        benchmarkPhrase.pattern("stop benchmark");
        lightCore.registerPhrase(benchmarkPhrase);

        org.panda_lang.light.core.element.phrase.PhraseRepresentation sendPhrase = new org.panda_lang.light.core.element.phrase.PhraseRepresentation(new PrintPhrase());
        sendPhrase.pattern("print *");
        lightCore.registerPhrase(sendPhrase);
    }

}
