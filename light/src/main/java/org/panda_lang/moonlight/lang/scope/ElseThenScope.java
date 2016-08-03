package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.core.element.scope.Scope;

public class ElseThenScope extends Scope {

    public ElseThenScope() {
        super.setName("else::" + blockIDAssigner.incrementAndGet());
    }

}
