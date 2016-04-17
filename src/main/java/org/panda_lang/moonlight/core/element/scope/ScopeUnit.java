package org.panda_lang.moonlight.core.element.scope;

import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.argument.ArgumentRepresentation;

import java.util.ArrayList;
import java.util.Collection;

public class ScopeUnit {

    private final String eventName;
    private final Collection<ArgumentRepresentation> argumentRepresentations;

    public ScopeUnit(String eventName) {
        this.eventName = eventName;
        this.argumentRepresentations = new ArrayList<>();
    }

    public void registerArgument(String pattern, ArgumentInitializer argumentInitializer) {
        ArgumentRepresentation argumentRepresentation = new ArgumentRepresentation();
        argumentRepresentation.name(pattern);
        argumentRepresentation.pattern(pattern);
        argumentRepresentation.initializer(argumentInitializer);
        registerArgument(argumentRepresentation);
    }

    public void registerArgument(ArgumentRepresentation argumentRepresentation) {
        argumentRepresentations.add(argumentRepresentation);
    }

    public boolean contains(ArgumentRepresentation element) {
        for (ArgumentRepresentation argumentRepresentation : argumentRepresentations) {
            if (argumentRepresentation.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public Collection<ArgumentRepresentation> getArgumentRepresentations() {
        return argumentRepresentations;
    }

    public String getEventName() {
        return eventName;
    }

    @Override
    public String toString() {
        return "ScopeUnit{" +
                "eventName='" + eventName + '\'' +
                ", argumentRepresentations=" + argumentRepresentations +
                '}';
    }

}
