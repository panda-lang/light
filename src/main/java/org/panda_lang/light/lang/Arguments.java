package org.panda_lang.light.lang;

import org.panda_lang.light.LightCore;

public class Arguments {

    private final LightCore lightCore;

    public Arguments(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void registerDefaultElements() {

    }

    public LightCore getLightCore() {
        return lightCore;
    }

}
