package org.panda_lang.light.lang.scope;

import org.panda_lang.light.core.element.scope.Scope;

public class ElseThenScope extends Scope {

    public ElseThenScope() {
        super.setName("else::" + atomicInteger.incrementAndGet());
    }

}
