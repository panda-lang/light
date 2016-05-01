package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.memory.Cache;
import org.panda_lang.panda.core.memory.Memory;
import org.panda_lang.panda.core.parser.essential.util.Numeric;
import org.panda_lang.panda.core.statement.RuntimeValue;

public class LoopScope extends Scope {

    private final RuntimeValue runtimeValue;

    public LoopScope(RuntimeValue runtimeValue) {
        this.runtimeValue = runtimeValue;
        this.setName("loop::" + blockIDAssigner.incrementAndGet());
    }

    @Override
    public Inst execute(Alice alice) {
        final Memory memory = alice.getMemory();
        final Cache cache = memory.getCache();
        final Numeric numeric = runtimeValue.getValue(alice);
        final int count = numeric.getInt();

        for (int i = 0; i < count; i++) {
            cache.slotA = i;
            super.execute(alice);
        }

        return null;
    }

}
