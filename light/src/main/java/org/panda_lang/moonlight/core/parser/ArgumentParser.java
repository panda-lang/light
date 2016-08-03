package org.panda_lang.moonlight.core.parser;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentRepresentation;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.moonlight.core.element.scope.ScopeRepresentation;
import org.panda_lang.moonlight.core.element.scope.ScopeUnit;
import org.panda_lang.panda.core.parser.ParserInfo;
import org.panda_lang.panda.core.parser.PandaException;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.statement.Block;

import java.util.ArrayList;
import java.util.List;

public class ArgumentParser implements Parser {

    private ArgumentRepresentation argumentRepresentation;

    @Override
    public ExpressionRuntime parse(ParserInfo parserInfo) {
        Block block = parserInfo.getCurrent();
        while (block != null) {
            if (block instanceof Scope) {
                Scope scope = (Scope) block;
                ExpressionRuntime expressionRuntime = parse(parserInfo, scope);

                if (expressionRuntime != null) {
                    return expressionRuntime;
                }
            }

            block = block.getParent();
        }

        return null;
    }

    public ExpressionRuntime parse(ParserInfo parserInfo, Scope scope) {
        String argumentSource = parserInfo.getSourceCode();
        ScopeRepresentation scopeRepresentation = scope.getScopeRepresentation();
        ScopeUnit scopeUnit = scopeRepresentation.getScopeUnit(scope);

        for (final ArgumentRepresentation argumentRepresentation : scopeUnit.getArgumentRepresentations()) {
            for (HollowPattern hollowPattern : argumentRepresentation.getPatterns()) {
                if (hollowPattern.match(argumentSource)) {
                    if (!scope.argumentBelongsToScope(argumentRepresentation)) {
                        PandaException pandaException = new PandaException("Argument " + argumentSource + " is not allowed here", parserInfo.getSourcesDivider());
                        return parserInfo.getPandaParser().throwException(pandaException);
                    }
                    this.argumentRepresentation = argumentRepresentation;

                    final List<String> hollows = new ArrayList<>(hollowPattern.getHollows());
                    final Scope argumentScope = scope;

                    return new ExpressionRuntime(new Expression() {
                        @Override
                        public Object getValue(Ray ray) {
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

    public ArgumentRepresentation getArgumentRepresentation() {
        return argumentRepresentation;
    }

}
