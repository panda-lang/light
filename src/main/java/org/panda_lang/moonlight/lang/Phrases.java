package org.panda_lang.moonlight.lang;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.element.phrase.PhraseRepresentation;
import org.panda_lang.moonlight.lang.phrase.*;
import org.panda_lang.moonlight.util.MoonlightElements;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;

public class Phrases implements MoonlightElements {

    private final MoonlightCore moonlightCore;

    public Phrases(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    @Override
    public void registerDefaultElements() {
        PhraseRepresentation declarationPhrase = new PhraseRepresentation(new DeclarationPhrase());
        declarationPhrase.pattern("follow *");
        declarationPhrase.pattern("global *");
        moonlightCore.registerPhrase(declarationPhrase);

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
        moonlightCore.registerPhrase(functionPhrase);

        PhraseRepresentation modificationPhrase = new PhraseRepresentation(new ModificationPhrase());
        modificationPhrase.pattern("add * to *");
        modificationPhrase.pattern("set * to *");
        modificationPhrase.pattern("remove * from *");
        modificationPhrase.pattern("delete *");
        moonlightCore.registerPhrase(modificationPhrase);

        PhraseRepresentation benchmarkPhrase = new PhraseRepresentation(new BenchmarkPhrase());
        benchmarkPhrase.pattern("initialize benchmark");
        benchmarkPhrase.pattern("benchmark point");
        benchmarkPhrase.pattern("stop benchmark");
        moonlightCore.registerPhrase(benchmarkPhrase);

        PhraseRepresentation sendPhrase = new PhraseRepresentation(new PrintPhrase());
        sendPhrase.pattern("send * to console");
        moonlightCore.registerPhrase(sendPhrase);
    }

}
