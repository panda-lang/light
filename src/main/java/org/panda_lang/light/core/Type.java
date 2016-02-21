package org.panda_lang.light.core;

import org.panda_lang.light.core.memory.database.util.DataSerializer;
import org.panda_lang.panda.core.syntax.Essence;

import java.io.IOException;

public interface Type<T extends Essence> {

    DataSerializer serialize(DataSerializer dataSerializer, T essence) throws IOException;

    T deserialize(DataSerializer dataSerializer) throws IOException;

}
