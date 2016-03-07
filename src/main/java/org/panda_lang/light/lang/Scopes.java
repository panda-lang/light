package org.panda_lang.light.lang;

import org.panda_lang.light.Light;
import org.panda_lang.light.LightCore;
import org.panda_lang.light.core.Flash;
import org.panda_lang.light.core.element.scope.Scope;
import org.panda_lang.light.core.element.scope.ScopeInitializer;
import org.panda_lang.light.core.element.scope.ScopeRepresentation;
import org.panda_lang.light.lang.scope.*;

public class Scopes {

    private final Light light;
    private final LightCore lightCore;

    public Scopes(LightCore lightCore) {
        this.light = lightCore.getLight();
        this.lightCore = lightCore;
    }

    public void registerDefaultElements() {
        ScopeRepresentation commandScope = new ScopeRepresentation("command", CommandScope.class, light);
        commandScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                return new CommandScope(flash.getAtom());
            }
        });

        ScopeRepresentation eventScope = new ScopeRepresentation(light, EventScope.class, "on", "event");
        eventScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                return new EventScope(flash.getAtom());
            }
        });
        light.registerScope(eventScope);

        ScopeRepresentation functionScope = new ScopeRepresentation("function", FunctionScope.class, light);
        functionScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                return new FunctionScope(flash.getAtom());
            }
        });

        ElseThenScope.initialize(light);
        FunctionScope.initialize(light);
        IfThenScope.initialize(light);
        LoopScope.initialize(light);
        RunnableScope.initialize(light);
        WhileScope.initialize(light);
    }

    public LightCore getLightCore() {
        return lightCore;
    }

}
