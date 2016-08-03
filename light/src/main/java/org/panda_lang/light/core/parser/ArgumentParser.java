package org.panda_lang.light.core.parser;

import org.panda_lang.panda.core.parser.PandaException;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.ParserInfo;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.statement.Block;

import java.util.ArrayList;
import java.util.List;

public class ArgumentParser implements Parser {

    private org.panda_lang.light.core.element.argument.ArgumentRepresentation argumentRepresentation;

    @Override
    public org.panda_lang.light.core.element.expression.ExpressionRuntime parse(ParserInfo parserInfo) {
        Block block = parserInfo.getCurrent();
        while (block != null) {
            if (block instanceof org.panda_lang.light.core.element.scope.Scope) {
                org.panda_lang.light.core.element.scope.Scope scope = (org.panda_lang.light.core.element.scope.Scope) block;
                org.panda_lang.light.core.element.expression.ExpressionRuntime expressionRuntime = parse(parserInfo, scope);

                if (expressionRuntime != null) {
                    return expressionRuntime;
                }
            }

            block = block.getParent();
        }

        return null;
    }

    public org.panda_lang.light.core.element.expression.ExpressionRuntime parse(ParserInfo parserInfo, org.panda_lang.light.core.element.scope.Scope scope) {
        String argumentSource = parserInfo.getSourceCode();
        org.panda_lang.light.core.element.scope.ScopeRepresentation scopeRepresentation = scope.getScopeRepresentation();
        org.panda_lang.light.core.element.scope.ScopeUnit scopeUnit = scopeRepresentation.getScopeUnit(scope);

        for (final org.panda_lang.light.core.element.argument.ArgumentRepresentation argumentRepresentation : scopeUnit.getArgumentRepresentations()) {
            for (HollowPattern hollowPattern : argumentRepresentation.getPatterns()) {
                if (hollowPattern.match(argumentSource)) {
                    if (!scope.argumentBelongsToScope(argumentRepresentation)) {
                        PandaException pandaException = new PandaException("Argument " + argumentSource + " is not allowed here", parserInfo.getSourcesDivider());
                        return parserInfo.getPandaParser().throwException(pandaException);
                    }
                    this.argumentRepresentation = argumentRepresentation;

                    final List<String> hollows = new ArrayList<>(hollowPattern.getHollows());
                    final org.panda_lang.light.core.element.scope.Scope argumentScope = scope;

                    return new org.panda_lang.light.core.element.expression.ExpressionRuntime(new org.panda_lang.light.core.element.expression.Expression() {
                        @Override
                        public Object getValue(org.panda_lang.light.core.Ray ray) {
                            ray.argumentScope(argumentScope);
                            ray.hollows(hollows);
                            return argumentRepresentation.get(ray);
                        }
                    }, null);
                }
            }
        }

        return null;
    }

    public org.panda_lang.light.core.element.argument.ArgumentRepresentation getArgumentRepresentation() {
        return argumentRepresentation;
    }

}
