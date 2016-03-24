package org.panda_lang.moonlight.core.element.argument;

import org.panda_lang.moonlight.core.util.Representation;

public class ArgumentRepresentation extends Representation<Argument> {

    private ArgumentInitializer argumentInitializer;

    public void initializer(ArgumentInitializer argumentInitializer) {
        this.argumentInitializer = argumentInitializer;
    }

    public ArgumentInitializer getArgumentInitializer() {
        return argumentInitializer;
    }

}
