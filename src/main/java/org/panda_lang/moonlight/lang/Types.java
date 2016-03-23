package org.panda_lang.moonlight.lang;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.element.type.TypeRepresentation;
import org.panda_lang.moonlight.lang.type.StringType;
import org.panda_lang.panda.lang.StringEssence;

public class Types {

    private final MoonlightCore moonlightCore;

    public Types(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    public void registerDefaultTypes() {
        TypeRepresentation typeRepresentation = new TypeRepresentation(StringEssence.class, new StringType());
        moonlightCore.registerType(typeRepresentation);
    }

}
