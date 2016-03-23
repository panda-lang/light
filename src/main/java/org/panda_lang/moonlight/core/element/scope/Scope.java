package org.panda_lang.moonlight.core.element.scope;

import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.syntax.Block;
import org.panda_lang.panda.core.syntax.Essence;

public class Scope extends Block {

    private Object object;

    public Scope() {
    }

    public Essence run(Particle particle, Object object) {
        this.object = object;
        return super.run(particle);
    }

    public Object getObject() {
        return object;
    }

}
