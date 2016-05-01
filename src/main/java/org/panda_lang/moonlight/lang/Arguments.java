package org.panda_lang.moonlight.lang;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeCenter;
import org.panda_lang.moonlight.core.element.scope.ScopeRepresentation;
import org.panda_lang.moonlight.lang.scope.LoopScope;
import org.panda_lang.moonlight.util.MoonlightElements;
import org.panda_lang.panda.lang.IntInst;

public class Arguments implements MoonlightElements {

    private final MoonlightCore moonlightCore;

    public Arguments(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    @Override
    public void registerDefaultElements() {
        ScopeCenter scopeCenter = moonlightCore.getScopeCenter();

        ScopeRepresentation loopScopeRepresentation = scopeCenter.select(LoopScope.class);
        loopScopeRepresentation.registerArgument("loop-index", new ArgumentInitializer() {
            @Override
            public Object get(Ray ray, Object object) {
                int loopIndex = (int) ray.getAlice().getMemory().getCache().slotA;
                return new IntInst(loopIndex);
            }
        });
    }

}
