package org.panda_lang.light.lang.scope;

import org.panda_lang.light.core.element.scope.Scope;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;
import org.panda_lang.panda.lang.BooleanEssence;

public class WhileScope extends Scope {

    private final Factor factor;

    public WhileScope(Factor factor) {
        this.factor = factor;
        this.setName("while::" + atomicInteger.incrementAndGet());
    }

    @Override
    public Essence run(Particle particle) {
        while (factor.<BooleanEssence> getValue(particle).isTrue()) {
            final Essence essence = super.run(particle);
            if (essence != null) {
                return essence;
            }
        }
        return null;
    }

}
