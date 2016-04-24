package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.core.statement.RuntimeValue;
import org.panda_lang.panda.lang.BooleanEssence;

public class WhileScope extends Scope {

    private final RuntimeValue runtimeValue;

    public WhileScope(RuntimeValue runtimeValue) {
        this.runtimeValue = runtimeValue;
        this.setName("while::" + blockIDAssigner.incrementAndGet());
    }

    @Override
    public Essence execute(Alice alice) {
        while (runtimeValue.<BooleanEssence>getValue(alice).isTrue()) {
            final Essence essence = super.execute(alice);
            if (essence != null) {
                return essence;
            }
        }
        return null;
    }

}
