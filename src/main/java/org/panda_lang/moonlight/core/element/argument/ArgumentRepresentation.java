package org.panda_lang.moonlight.core.element.argument;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.util.Representation;

public class ArgumentRepresentation extends Representation<Argument> {

    private String argumentName;
    private ArgumentInitializer argumentInitializer;

    public void name(String argumentName) {
        this.argumentName = argumentName;
    }

    public void initializer(ArgumentInitializer argumentInitializer) {
        this.argumentInitializer = argumentInitializer;
    }

    @SuppressWarnings("unchecked")
    public Object get(Ray ray) {
        return argumentInitializer.get(ray, ray.getScopeObject());
    }

    public ArgumentInitializer getArgumentInitializer() {
        return argumentInitializer;
    }

    public String getArgumentName() {
        return argumentName;
    }

    @Override
    public String toString() {
        return "ArgumentRepresentation{" +
                "argumentName='" + argumentName + '\'' +
                ", argumentInitializer=" + argumentInitializer +
                '}';
    }

}
