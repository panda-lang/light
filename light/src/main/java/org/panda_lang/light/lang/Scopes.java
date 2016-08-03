package org.panda_lang.light.lang;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.core.element.scope.*;
import org.panda_lang.light.lang.scope.*;
import org.panda_lang.light.util.LightElements;
import org.panda_lang.panda.core.statement.Block;

public class Scopes implements LightElements {

    private final LightCore lightCore;

    public Scopes(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    @Override
    public void registerDefaultElements() {
        ScopeRepresentation ifThenScopeRepresentation = new ScopeRepresentation("if", IfThenScope.class, lightCore);
        ifThenScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(org.panda_lang.light.core.Flash flash) {
                String phrase = flash.getFullPhrase();
                org.panda_lang.light.core.element.expression.ExpressionRuntime condition = flash.parseExpression(phrase);
                return new IfThenScope(condition.toFactor());
            }
        });
        lightCore.registerScope(ifThenScopeRepresentation);

        ScopeRepresentation elseThenScopeRepresentation = new ScopeRepresentation("else", ElseThenScope.class, lightCore);
        elseThenScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(org.panda_lang.light.core.Flash flash) {
                ElseThenScope elseThenScope = new ElseThenScope();
                Block previous = flash.getParserInfo().getPrevious();
                if (previous instanceof IfThenScope) {
                    ((IfThenScope) previous).setElseThenScope(elseThenScope);
                }
                return elseThenScope;
            }
        });
        elseThenScopeRepresentation.getBlockLayout().conventional(false);
        lightCore.registerScope(elseThenScopeRepresentation);

        ScopeRepresentation loopScopeRepresentation = new ScopeRepresentation("loop", LoopScope.class, lightCore);
        loopScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(org.panda_lang.light.core.Flash flash) {
                String expression = flash.getSpecifiers().get(0);
                org.panda_lang.light.core.element.expression.ExpressionRuntime count = flash.parseExpression(expression);
                return new LoopScope(count.toFactor());
            }
        });
        lightCore.registerScope(loopScopeRepresentation);

        ScopeRepresentation whileScopeRepresentation = new ScopeRepresentation("while", WhileScope.class, lightCore);
        whileScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(org.panda_lang.light.core.Flash flash) {
                String phrase = flash.getFullPhrase();
                org.panda_lang.light.core.element.expression.ExpressionRuntime condition = flash.parseExpression(phrase);
                return new WhileScope(condition.toFactor());
            }
        });
        lightCore.registerScope(whileScopeRepresentation);

        ScopeRepresentation functionScopeRepresentation = new ScopeRepresentation("function", FunctionScope.class, lightCore);
        functionScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(org.panda_lang.light.core.Flash flash) {
                String functionName = flash.getSpecifiers().get(0);
                return new FunctionScope(functionName);
            }
        });
        lightCore.registerScope(functionScopeRepresentation);

        ScopeRepresentation eventScopeRepresentation = new ScopeRepresentation(lightCore, EventScope.class, "on", "event");
        eventScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(org.panda_lang.light.core.Flash flash) {
                String eventName = flash.getFullPhrase();
                ScopeUnit scopeUnit = lightCore.getEventCenter().getEventUnit(eventName);
                return new EventScope(scopeUnit);
            }
        });
        eventScopeRepresentation.scopeUnitGetter(new ScopeUnitGetter() {
            @Override
            public ScopeUnit get(Scope scope) {
                EventScope eventScope = (EventScope) scope;
                return eventScope.getScopeUnit();
            }
        });
        lightCore.registerScope(eventScopeRepresentation);
    }

}
