package org.panda_lang.light.lang;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.util.LightElements;
import org.panda_lang.panda.lang.StringInst;

public class Types implements LightElements {

    private final LightCore lightCore;

    public Types(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    @Override
    public void registerDefaultElements() {
        org.panda_lang.light.core.element.type.TypeRepresentation typeRepresentation = new org.panda_lang.light.core.element.type.TypeRepresentation(StringInst.class, new org.panda_lang.light.lang.type.StringType());
        lightCore.registerType(typeRepresentation);
    }

}
