package org.panda_lang.light.lang.scope;

import org.panda_lang.light.core.element.scope.Scope;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;
import org.panda_lang.panda.lang.BooleanEssence;

public class IfThenScope extends Scope {

    private final Factor factor;
    private ElseThenScope elseThenScope;

    public IfThenScope(Factor factor) {
        this.factor = factor;
    }

    @Override
    public Essence run(Particle particle) {
        if (factor.<BooleanEssence> getValue(particle).isTrue()) {
            return super.run(particle);
        }
        else if (elseThenScope != null) {
            elseThenScope.run(particle);
        }
        return null;
    }

    public ElseThenScope getElseThenScope() {
        return elseThenScope;
    }

    public void setElseThenScope(ElseThenScope elseThenScope) {
        this.elseThenScope = elseThenScope;
    }

}
