package org.panda_lang.light.lang;

import org.panda_lang.light.Light;
import org.panda_lang.light.LightCore;
import org.panda_lang.light.core.Flash;
import org.panda_lang.light.core.element.expression.ExpressionRuntime;
import org.panda_lang.light.core.element.scope.Scope;
import org.panda_lang.light.core.element.scope.ScopeInitializer;
import org.panda_lang.light.core.element.scope.ScopeRepresentation;
import org.panda_lang.light.lang.scope.*;
import org.panda_lang.panda.core.syntax.Block;

public class Scopes {

    private final Light light;
    private final LightCore lightCore;

    public Scopes(LightCore lightCore) {
        this.light = lightCore.getLight();
        this.lightCore = lightCore;
    }

    public void registerDefaultElements() {
        ScopeRepresentation ifThenScope = new ScopeRepresentation("if", IfThenScope.class, light);
        ifThenScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String phrase = flash.getFullPhrase();
                ExpressionRuntime condition = flash.parseExpression(phrase);
                return new IfThenScope(condition.toFactor());
            }
        });
        light.registerScope(ifThenScope);

        ScopeRepresentation elseThenScope = new ScopeRepresentation("else", ElseThenScope.class, light);
        elseThenScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                ElseThenScope elseThenScope = new ElseThenScope();
                Block previous = flash.getAtom().getPrevious();
                if (previous instanceof IfThenScope) {
                    ((IfThenScope) previous).setElseThenScope(elseThenScope);
                }
                return elseThenScope;
            }
        });
        elseThenScope.getBlockLayout().conventional(false);
        light.registerScope(elseThenScope);

        ScopeRepresentation loopScope = new ScopeRepresentation("loop", LoopScope.class, light);
        loopScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String expression = flash.getSpecifiers().get(0);
                ExpressionRuntime count = flash.parseExpression(expression);
                return new LoopScope(count.toFactor());
            }
        });
        light.registerScope(loopScope);

        ScopeRepresentation whileScope = new ScopeRepresentation("while", WhileScope.class, light);
        whileScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String phrase = flash.getFullPhrase();
                ExpressionRuntime condition = flash.parseExpression(phrase);
                return new WhileScope(condition.toFactor());
            }
        });
        light.registerScope(whileScope);

        ScopeRepresentation functionScope = new ScopeRepresentation("function", FunctionScope.class, light);
        functionScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String functionName = flash.getSpecifiers().get(0);
                return new FunctionScope(functionName);
            }
        });
        light.registerScope(functionScope);

        ScopeRepresentation commandScope = new ScopeRepresentation("command", CommandScope.class, light);
        commandScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String commandName = flash.getSpecifiers().get(0);
                return new CommandScope(commandName);
            }
        });
        light.registerScope(commandScope);

        ScopeRepresentation eventScope = new ScopeRepresentation(light, EventScope.class, "on", "event");
        eventScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String eventName = flash.getSpecifiers().get(0);
                return new EventScope(eventName);
            }
        });
        light.registerScope(eventScope);
    }

    public LightCore getLightCore() {
        return lightCore;
    }

}
