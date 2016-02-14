package org.panda_lang.light.core;

import org.panda_lang.panda.core.syntax.Essence;

public interface Expression {

    Essence run(Ray ray);

}
