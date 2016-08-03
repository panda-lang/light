package org.panda_lang.light.core.element.scope;

import java.util.ArrayList;
import java.util.Collection;

public class ScopeUnit {

    private final String eventName;
    private final Collection<org.panda_lang.light.core.element.argument.ArgumentRepresentation> argumentRepresentations;

    public ScopeUnit(String eventName) {
        this.eventName = eventName;
        this.argumentRepresentations = new ArrayList<>();
    }

    public void registerArgument(String pattern, org.panda_lang.light.core.element.argument.ArgumentInitializer argumentInitializer) {
        org.panda_lang.light.core.element.argument.ArgumentRepresentation argumentRepresentation = new org.panda_lang.light.core.element.argument.ArgumentRepresentation();
        argumentRepresentation.name(pattern);
        argumentRepresentation.pattern(pattern);
        argumentRepresentation.initializer(argumentInitializer);
        registerArgument(argumentRepresentation);
    }

    public void registerArgument(org.panda_lang.light.core.element.argument.ArgumentRepresentation argumentRepresentation) {
        argumentRepresentations.add(argumentRepresentation);
    }

    public boolean contains(org.panda_lang.light.core.element.argument.ArgumentRepresentation element) {
        for (org.panda_lang.light.core.element.argument.ArgumentRepresentation argumentRepresentation : argumentRepresentations) {
            if (argumentRepresentation.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public Collection<org.panda_lang.light.core.element.argument.ArgumentRepresentation> getArgumentRepresentations() {
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
