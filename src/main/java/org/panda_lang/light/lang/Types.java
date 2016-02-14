package org.panda_lang.light.lang;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.core.parser.assistant.TypeRepresentation;
import org.panda_lang.light.lang.type.StringType;
import org.panda_lang.panda.lang.StringEssence;

public class Types {

    private final LightCore lightCore;

    public Types(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void registerDefaultTypes() {
        TypeRepresentation typeRepresentation = new TypeRepresentation(StringEssence.class, new StringType());
        lightCore.registerType(typeRepresentation);
    }

}
