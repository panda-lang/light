package org.panda_lang.light.lang.type;

import org.panda_lang.panda.lang.StringInst;

import java.io.IOException;

public class StringType implements org.panda_lang.light.core.element.type.Type<StringInst> {

    @Override
    public void serialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer, StringInst essence) throws IOException {
        dataSerializer.writeUTF(essence.toString());
    }

    @Override
    public StringInst deserialize(org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer) throws IOException {
        return new StringInst(dataSerializer.readUTF());
    }

    @Override
    public String toString(StringInst object) {
        return object.toString();
    }

}
