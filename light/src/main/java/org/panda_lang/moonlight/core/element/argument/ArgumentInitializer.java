package org.panda_lang.moonlight.core.element.argument;

import org.panda_lang.moonlight.core.Ray;

public interface ArgumentInitializer<T> {

    Object get(Ray ray, T object);

}
