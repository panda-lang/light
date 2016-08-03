package org.panda_lang.light.core.element.argument;

public class ArgumentRepresentation extends org.panda_lang.light.core.util.Representation<Argument> {

    private String argumentName;
    private Class<?> returnedClass;
    private ArgumentInitializer argumentInitializer;

    public void name(String argumentName) {
        this.argumentName = argumentName;
    }

    public void clazz(Class<?> returnedClass) {
        this.returnedClass = returnedClass;
    }

    public void initializer(ArgumentInitializer argumentInitializer) {
        this.argumentInitializer = argumentInitializer;
    }

    @SuppressWarnings("unchecked")
    public Object get(org.panda_lang.light.core.Ray ray) {
        return argumentInitializer.get(ray, ray.getScopeObject());
    }

    public ArgumentInitializer getArgumentInitializer() {
        return argumentInitializer;
    }

    public Class<?> getReturnedClass() {
        return returnedClass;
    }

    public String getArgumentName() {
        return argumentName;
    }

}
