package org.panda_lang.moonlight.core.element.argument;

import org.panda_lang.moonlight.core.Ray;

public interface ArgumentInitializer {

    Object get(Ray ray, Object object);

}
