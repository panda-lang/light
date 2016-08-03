package org.panda_lang.light.lang.scope;

public class ElseThenScope extends org.panda_lang.light.core.element.scope.Scope {

    public ElseThenScope() {
        super.setName("else::" + blockIDAssigner.incrementAndGet());
    }

}
