package org.panda_lang.moonlight.lang;

import org.panda_lang.moonlight.core.element.type.TypeRepresentation;
import org.panda_lang.moonlight.util.MoonlightElements;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.lang.type.StringType;
import org.panda_lang.panda.lang.StringInst;

public class Types implements MoonlightElements {

    private final MoonlightCore moonlightCore;

    public Types(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    @Override
    public void registerDefaultElements() {
        TypeRepresentation typeRepresentation = new TypeRepresentation(StringInst.class, new StringType());
        moonlightCore.registerType(typeRepresentation);
    }

}
