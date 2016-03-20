package org.panda_lang.light.core.element.argument;

import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.util.Representation;

public class ArgumentRepresentation extends Representation<Argument> {

    private ArgumentInitializer argumentInitializer;

    public void initializer(ArgumentInitializer argumentInitializer) {
        this.argumentInitializer = argumentInitializer;
    }

    public Argument initialize(Ray ray, Object object) {
        Object argument = argumentInitializer.get(ray, object);
        return new Argument(argument);
    }

    public ArgumentInitializer getArgumentInitializer() {
        return argumentInitializer;
    }

}
