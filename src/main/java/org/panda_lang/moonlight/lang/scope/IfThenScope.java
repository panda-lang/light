package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.core.statement.RuntimeValue;
import org.panda_lang.panda.lang.BooleanEssence;

public class IfThenScope extends Scope {

    private final RuntimeValue runtimeValue;
    private ElseThenScope elseThenScope;

    public IfThenScope(RuntimeValue runtimeValue) {
        this.runtimeValue = runtimeValue;
    }

    @Override
    public Essence execute(Alice alice) {
        if (runtimeValue.<BooleanEssence>getValue(alice).isTrue()) {
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
