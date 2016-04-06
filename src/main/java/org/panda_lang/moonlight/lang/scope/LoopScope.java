package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.memory.Cache;
import org.panda_lang.panda.core.memory.Memory;
import org.panda_lang.panda.core.parser.essential.util.Numeric;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.core.statement.Factor;

public class LoopScope extends Scope {

    private final Factor factor;

    public LoopScope(Factor factor) {
        this.factor = factor;
        this.setName("loop::" + blockIDAssigner.incrementAndGet());
    }

    @Override
    public Essence execute(Alice alice) {
        final Memory memory = alice.getMemory();
        final Cache cache = memory.getCache();
        final Numeric numeric = factor.getValue(alice);
        final int count = numeric.getInt();

        for (int i = 0; i < count; i++) {
            cache.slotA = i;
            super.execute(alice);
        }

        return null;
    }

}
