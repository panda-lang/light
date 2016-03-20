package org.panda_lang.light.core.element.argument;

import org.panda_lang.light.core.Ray;

public interface ArgumentInitializer {

    Object get(Ray ray, Object object);

}
