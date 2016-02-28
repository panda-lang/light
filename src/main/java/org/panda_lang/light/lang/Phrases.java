package org.panda_lang.light.lang;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.core.parser.assistant.PhraseRepresentation;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.light.lang.phrase.*;

public class Phrases {

    private final LightCore lightCore;

    public Phrases(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void registerDefaultPhrases() {
        PhraseRepresentation declarationPhrase = new PhraseRepresentation(new DeclarationPhrase());
        declarationPhrase.pattern("follow *");
        declarationPhrase.pattern("global *");
        lightCore.registerPhrase(declarationPhrase);

        PhraseRepresentation functionPhrase = new PhraseRepresentation(new FunctionPhrase());
        functionPhrase.pattern(HollowPattern.builder()
                .basis("call")
                .hollow()
                .basis("with")
                .hollow()
                .build(0));
        functionPhrase.pattern(HollowPattern.builder()
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

        PhraseRepresentation benchmarkPhrase = new PhraseRepresentation(new BenchmarkPhrase());
        benchmarkPhrase.pattern("initialize benchmark");
        benchmarkPhrase.pattern("benchmark point");
        benchmarkPhrase.pattern("stop benchmark");
        lightCore.registerPhrase(benchmarkPhrase);

        PhraseRepresentation sendPhrase = new PhraseRepresentation(new PrintPhrase());
        sendPhrase.pattern("send * to console");
        lightCore.registerPhrase(sendPhrase);
    }

}
