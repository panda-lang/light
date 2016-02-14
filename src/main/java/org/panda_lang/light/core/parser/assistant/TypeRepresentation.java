package org.panda_lang.light.core.parser.assistant;

import org.panda_lang.light.core.Type;
import org.panda_lang.light.core.parser.pattern.LightPattern;

import java.util.ArrayList;
import java.util.Collection;

public class TypeRepresentation {

    private final Type type;
    private final Collection<LightPattern> patterns;

    public TypeRepresentation(Type type) {
        this.type = type;
        this.patterns = new ArrayList<>(1);
    }


}
