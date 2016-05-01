package org.panda_lang.moonlight.lang.type;

import org.panda_lang.moonlight.core.element.type.Type;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.panda.lang.StringInst;

import java.io.IOException;

public class StringType implements Type<StringInst> {

    @Override
    public void serialize(DataSerializer dataSerializer, StringInst essence) throws IOException {
        dataSerializer.writeUTF(essence.toString());
    }

    @Override
    public StringInst deserialize(DataSerializer dataSerializer) throws IOException {
        return new StringInst(dataSerializer.readUTF());
    }

    @Override
    public String toString(StringInst object) {
        return object.toString();
    }

}
