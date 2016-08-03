package org.panda_lang.light;

import org.panda_lang.panda.core.parser.essential.BlockParser;

public class LightBasis {

    private final LightCore lightCore;

    public LightBasis(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void loadParsers() {
        BlockParser.initialize(lightCore.getPanda());
        org.panda_lang.light.core.parser.NativeParser.initialize(lightCore);
        org.panda_lang.light.core.parser.PhraseParser.initialize(lightCore);
    }

    public LightCore getLightCore() {
        return lightCore;
    }

}
