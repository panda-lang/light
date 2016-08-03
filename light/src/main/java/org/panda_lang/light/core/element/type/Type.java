package org.panda_lang.light.core.element.type;

import java.io.IOException;

public interface Type<T> {

    void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, T object) throws IOException;

    T deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException;

    String toString(T object);

}
