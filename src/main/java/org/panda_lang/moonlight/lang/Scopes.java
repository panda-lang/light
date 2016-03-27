package org.panda_lang.moonlight.lang;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Flash;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.moonlight.core.element.scope.ScopeInitializer;
import org.panda_lang.moonlight.core.element.scope.ScopeRepresentation;
import org.panda_lang.moonlight.lang.scope.*;
import org.panda_lang.moonlight.lang.scope.event.EventUnit;
import org.panda_lang.moonlight.util.MoonlightElements;
import org.panda_lang.panda.core.syntax.Block;

public class Scopes implements MoonlightElements {

    private final MoonlightCore moonlightCore;

    public Scopes(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    @Override
    public void registerDefaultElements() {
        ScopeRepresentation ifThenScope = new ScopeRepresentation("if", IfThenScope.class, moonlightCore);
        ifThenScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String phrase = flash.getFullPhrase();
                ExpressionRuntime condition = flash.parseExpression(phrase);
                return new IfThenScope(condition.toFactor());
            }
        });
        moonlightCore.registerScope(ifThenScope);

        ScopeRepresentation elseThenScope = new ScopeRepresentation("else", ElseThenScope.class, moonlightCore);
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
        moonlightCore.registerScope(elseThenScope);

        ScopeRepresentation loopScope = new ScopeRepresentation("loop", LoopScope.class, moonlightCore);
        loopScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String expression = flash.getSpecifiers().get(0);
                ExpressionRuntime count = flash.parseExpression(expression);
                return new LoopScope(count.toFactor());
            }
        });
        moonlightCore.registerScope(loopScope);

        ScopeRepresentation whileScope = new ScopeRepresentation("while", WhileScope.class, moonlightCore);
        whileScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String phrase = flash.getFullPhrase();
                ExpressionRuntime condition = flash.parseExpression(phrase);
                return new WhileScope(condition.toFactor());
            }
        });
        moonlightCore.registerScope(whileScope);

        ScopeRepresentation functionScope = new ScopeRepresentation("function", FunctionScope.class, moonlightCore);
        functionScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String functionName = flash.getSpecifiers().get(0);
                return new FunctionScope(functionName);
            }
        });
        moonlightCore.registerScope(functionScope);

        ScopeRepresentation eventScope = new ScopeRepresentation(moonlightCore, EventScope.class, "on", "event");
        eventScope.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String eventName = flash.getSpecifiers().get(0);
                EventUnit eventUnit = moonlightCore.getEventCenter().getEventUnit(eventName);
                return new EventScope(eventUnit);
            }
        });
        moonlightCore.registerScope(eventScope);
    }

}
