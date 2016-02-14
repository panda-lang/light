package org.panda_lang.light.core;

import org.panda_lang.panda.core.syntax.Essence;

public interface Type {

    void set(Essence essence);

    Essence get();

}
