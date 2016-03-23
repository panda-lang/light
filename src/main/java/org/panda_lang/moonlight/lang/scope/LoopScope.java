package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.essential.util.Numeric;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;

public class LoopScope extends Scope {

    private final Factor factor;

    public LoopScope(Factor factor) {
        this.factor = factor;
        this.setName("loop::" + atomicInteger.incrementAndGet());
    }

    @Override
    public Essence run(Particle particle) {
        final Numeric numeric = factor.getValue(particle);
        final int count = numeric.getInt();

        for (int i = 0; i < count; i++) {
            super.run(particle);
        }

        return null;
    }

}
