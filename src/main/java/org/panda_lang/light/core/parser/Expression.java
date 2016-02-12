package org.panda_lang.light.core.parser;

import org.panda_lang.light.core.Ray;
import org.panda_lang.panda.core.syntax.Essence;

public interface Expression {

    Essence run(Ray ray);

}
