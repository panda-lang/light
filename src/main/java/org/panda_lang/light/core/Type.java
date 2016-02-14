package org.panda_lang.light.core;

import org.panda_lang.panda.core.syntax.Essence;

public interface Type<T extends Essence> {

    String serialize(T essence);

    T deserialize(String data);

}
