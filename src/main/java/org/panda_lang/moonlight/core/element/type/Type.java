package org.panda_lang.moonlight.core.element.type;

import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;

import java.io.IOException;

public interface Type<T> {

    void serialize(DataSerializer dataSerializer, T object) throws IOException;

    T deserialize(DataSerializer dataSerializer) throws IOException;

}
