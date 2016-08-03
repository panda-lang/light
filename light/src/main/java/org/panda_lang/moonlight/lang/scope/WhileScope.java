package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.statement.RuntimeValue;
import org.panda_lang.panda.lang.BooleanInst;

public class WhileScope extends Scope {

    private final RuntimeValue runtimeValue;

    public WhileScope(RuntimeValue runtimeValue) {
        this.runtimeValue = runtimeValue;
        this.setName("while::" + blockIDAssigner.incrementAndGet());
    }

    @Override
    public Inst execute(Alice alice) {
        while (runtimeValue.<BooleanInst>getValue(alice).isTrue()) {
            final Inst inst = super.execute(alice);
            if (inst != null) {
                return inst;
            }
        }
        return null;
    }

}
