package org.panda_lang.light.lang.type;

import org.panda_lang.light.core.Type;
import org.panda_lang.panda.lang.StringEssence;

public class StringType implements Type<StringEssence> {

    @Override
    public String serialize(StringEssence essence) {
        return essence.toString();
    }

    @Override
    public StringEssence deserialize(String data) {
        return new StringEssence(data);
    }

}
