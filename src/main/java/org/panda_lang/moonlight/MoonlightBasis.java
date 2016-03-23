package org.panda_lang.moonlight;

import org.panda_lang.moonlight.core.parser.NativeParser;
import org.panda_lang.moonlight.core.parser.PhraseParser;
import org.panda_lang.panda.core.parser.essential.BlockParser;

public class MoonlightBasis {

    private final Moonlight moonlight;

    public MoonlightBasis(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    public void loadParsers() {
        NativeParser.initialize(moonlight);
        PhraseParser.initialize(moonlight);

        BlockParser.initialize(moonlight.getPanda());
    }

    public Moonlight getMoonlight() {
        return moonlight;
    }

}
