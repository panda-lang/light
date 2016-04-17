package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.core.statement.Factor;
import org.panda_lang.panda.lang.BooleanEssence;

public class IfThenScope extends Scope {

    private final Factor factor;
    private ElseThenScope elseThenScope;

    public IfThenScope(Factor factor) {
        this.factor = factor;
    }

    @Override
    public Essence execute(Alice alice) {
        if (factor.<BooleanEssence>getValue(alice).isTrue()) {
            return super.execute(alice);
        }
        else if (elseThenScope != null) {
            elseThenScope.execute(alice);
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
