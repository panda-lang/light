package org.panda_lang.moonlight.lang;

import org.panda_lang.moonlight.MoonlightCore;

public class Arguments {

    private final MoonlightCore moonlightCore;

    public Arguments(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    public void registerDefaultElements() {

    }

    public MoonlightCore getMoonlightCore() {
        return moonlightCore;
    }

}
