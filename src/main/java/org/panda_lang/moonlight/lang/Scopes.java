package org.panda_lang.moonlight.lang;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Flash;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.moonlight.core.element.scope.ScopeInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeRepresentation;
import org.panda_lang.moonlight.lang.scope.*;
import org.panda_lang.panda.core.syntax.Block;

public class Scopes {

    private final MoonlightCore moonlight;
    private final MoonlightCore moonlightCore;

    public Scopes(MoonlightCore moonlightCore) {
        this.moonlight = moonlightCore;
        this.moonlightCore = moonlightCore;
    }

    public void registerDefaultElements() {
        ScopeRepresentation ifThenScope = new ScopeRepresentation("if", IfThenScope.class, moonlight);
        ifThenScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String phrase = flash.getFullPhrase();
                ExpressionRuntime condition = flash.parseExpression(phrase);
                return new IfThenScope(condition.toFactor());
            }
        });
        moonlight.registerScope(ifThenScope);

        ScopeRepresentation elseThenScope = new ScopeRepresentation("else", ElseThenScope.class, moonlight);
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
        moonlight.registerScope(elseThenScope);

        ScopeRepresentation loopScope = new ScopeRepresentation("loop", LoopScope.class, moonlight);
        loopScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String expression = flash.getSpecifiers().get(0);
                ExpressionRuntime count = flash.parseExpression(expression);
                return new LoopScope(count.toFactor());
            }
        });
        moonlight.registerScope(loopScope);

        ScopeRepresentation whileScope = new ScopeRepresentation("while", WhileScope.class, moonlight);
        whileScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String phrase = flash.getFullPhrase();
                ExpressionRuntime condition = flash.parseExpression(phrase);
                return new WhileScope(condition.toFactor());
            }
        });
        moonlight.registerScope(whileScope);

        ScopeRepresentation functionScope = new ScopeRepresentation("function", FunctionScope.class, moonlight);
        functionScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String functionName = flash.getSpecifiers().get(0);
                return new FunctionScope(functionName);
            }
        });
        moonlight.registerScope(functionScope);

        ScopeRepresentation commandScope = new ScopeRepresentation("command", CommandScope.class, moonlight);
        commandScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String commandName = flash.getSpecifiers().get(0);
                return new CommandScope(commandName);
            }
        });
        moonlight.registerScope(commandScope);

        ScopeRepresentation eventScope = new ScopeRepresentation(moonlight, EventScope.class, "on", "event");
        eventScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String eventName = flash.getSpecifiers().get(0);
                return new EventScope(eventName);
            }
        });
        moonlight.registerScope(eventScope);
    }

    public MoonlightCore getMoonlightCore() {
        return moonlightCore;
    }

}
