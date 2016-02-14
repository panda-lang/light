package org.panda_lang.light.core.parser;

import org.panda_lang.light.core.parser.assistant.TypeRepresentation;

import java.util.ArrayList;
import java.util.Collection;

public class TypeCenter {

    private final Collection<TypeRepresentation> types;

    public TypeCenter() {
        this.types = new ArrayList<>();
    }

    public void registerType(TypeRepresentation typeRepresentation) {
        this.types.add(typeRepresentation);
    }

    public Collection<TypeRepresentation> getTypes() {
        return types;
    }

}
