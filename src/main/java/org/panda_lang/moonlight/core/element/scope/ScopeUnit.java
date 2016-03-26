package org.panda_lang.moonlight.core.element.scope;

import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.argument.ArgumentRepresentation;

import java.util.ArrayList;
import java.util.Collection;

public class ScopeUnit {

    private final Collection<ArgumentRepresentation> argumentRepresentations;

    public ScopeUnit() {
        this.argumentRepresentations = new ArrayList<>();
    }

    public void registerArgument(String pattern, ArgumentInitializer argumentInitializer) {
        ArgumentRepresentation argumentRepresentation = new ArgumentRepresentation();
        argumentRepresentation.pattern(pattern);
        argumentRepresentation.initializer(argumentInitializer);
        registerArgument(argumentRepresentation);
    }

    public void registerArgument(ArgumentRepresentation argumentRepresentation) {
        argumentRepresentations.add(argumentRepresentation);
    }

    public Collection<ArgumentRepresentation> getArgumentRepresentations() {
        return argumentRepresentations;
    }

}
