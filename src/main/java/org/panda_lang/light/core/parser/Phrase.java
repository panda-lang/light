package org.panda_lang.light.core.parser;

import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.syntax.Essence;

public interface Phrase {

    Essence run(Particle particle);

}
