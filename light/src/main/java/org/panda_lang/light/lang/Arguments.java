package org.panda_lang.light.lang;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.util.LightElements;
import org.panda_lang.panda.lang.IntInst;

public class Arguments implements LightElements {

    private final LightCore lightCore;

    public Arguments(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    @Override
    public void registerDefaultElements() {
        org.panda_lang.light.core.element.scope.ScopeCenter scopeCenter = lightCore.getScopeCenter();

        org.panda_lang.light.core.element.scope.ScopeRepresentation loopScopeRepresentation = scopeCenter.select(org.panda_lang.light.lang.scope.LoopScope.class);
        loopScopeRepresentation.registerArgument("loop-index", new org.panda_lang.light.core.element.argument.ArgumentInitializer() {
            @Override
            public Object get(org.panda_lang.light.core.Ray ray, Object object) {
                int loopIndex = (int) ray.getAlice().getMemory().getCache().slotA;
                return new IntInst(loopIndex);
            }
        });
    }

}
