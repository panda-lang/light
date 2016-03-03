package org.panda_lang.light.lang.type;

import org.panda_lang.light.core.element.type.Type;
import org.panda_lang.light.core.memory.database.util.DataSerializer;
import org.panda_lang.panda.lang.StringEssence;

import java.io.IOException;

public class StringType implements Type<StringEssence> {

    @Override
    public void serialize(DataSerializer dataSerializer, StringEssence essence) throws IOException {
        dataSerializer.writeUTF(essence.toString());
    }

    @Override
    public StringEssence deserialize(DataSerializer dataSerializer) throws IOException {
        return new StringEssence(dataSerializer.readUTF());
    }

}
