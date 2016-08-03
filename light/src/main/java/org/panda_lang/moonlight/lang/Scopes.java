package org.panda_lang.moonlight.lang;

import org.panda_lang.moonlight.core.element.scope.*;
import org.panda_lang.moonlight.lang.scope.*;
import org.panda_lang.moonlight.util.MoonlightElements;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Flash;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.panda.core.statement.Block;

public class Scopes implements MoonlightElements {

    private final MoonlightCore moonlightCore;

    public Scopes(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    @Override
    public void registerDefaultElements() {
        ScopeRepresentation ifThenScopeRepresentation = new ScopeRepresentation("if", IfThenScope.class, moonlightCore);
        ifThenScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String phrase = flash.getFullPhrase();
                ExpressionRuntime condition = flash.parseExpression(phrase);
                return new IfThenScope(condition.toFactor());
            }
        });
        moonlightCore.registerScope(ifThenScopeRepresentation);

        ScopeRepresentation elseThenScopeRepresentation = new ScopeRepresentation("else", ElseThenScope.class, moonlightCore);
        elseThenScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                ElseThenScope elseThenScope = new ElseThenScope();
                Block previous = flash.getParserInfo().getPrevious();
                if (previous instanceof IfThenScope) {
                    ((IfThenScope) previous).setElseThenScope(elseThenScope);
                }
                return elseThenScope;
            }
        });
        elseThenScopeRepresentation.getBlockLayout().conventional(false);
        moonlightCore.registerScope(elseThenScopeRepresentation);

        ScopeRepresentation loopScopeRepresentation = new ScopeRepresentation("loop", LoopScope.class, moonlightCore);
        loopScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String expression = flash.getSpecifiers().get(0);
                ExpressionRuntime count = flash.parseExpression(expression);
                return new LoopScope(count.toFactor());
            }
        });
        moonlightCore.registerScope(loopScopeRepresentation);

        ScopeRepresentation whileScopeRepresentation = new ScopeRepresentation("while", WhileScope.class, moonlightCore);
        whileScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String phrase = flash.getFullPhrase();
                ExpressionRuntime condition = flash.parseExpression(phrase);
                return new WhileScope(condition.toFactor());
            }
        });
        moonlightCore.registerScope(whileScopeRepresentation);

        ScopeRepresentation functionScopeRepresentation = new ScopeRepresentation("function", FunctionScope.class, moonlightCore);
        functionScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String functionName = flash.getSpecifiers().get(0);
                return new FunctionScope(functionName);
            }
        });
        moonlightCore.registerScope(functionScopeRepresentation);

        ScopeRepresentation eventScopeRepresentation = new ScopeRepresentation(moonlightCore, EventScope.class, "on", "event");
        eventScopeRepresentation.initializer(new ScopeInitializer() {
            @Override
            public Scope initialize(Flash flash) {
                String eventName = flash.getFullPhrase();
                ScopeUnit scopeUnit = moonlightCore.getEventCenter().getEventUnit(eventName);
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
        moonlightCore.registerScope(eventScopeRepresentation);
    }

}
