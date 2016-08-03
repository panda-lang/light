package org.panda_lang.light.core.element.argument;

public interface ArgumentInitializer<T> {

    Object get(org.panda_lang.light.core.Ray ray, T object);

}
