package org.panda_lang.moonlight.core.parser;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentRepresentation;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.moonlight.core.element.scope.ScopeRepresentation;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.PandaException;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.statement.Block;

public class ArgumentParser implements Parser {

    @Override
    public ExpressionRuntime parse(Atom atom) {
        Block block = atom.getCurrent();
        while (block != null) {
            if (block instanceof Scope) {
                Scope scope = (Scope) block;
                ExpressionRuntime expressionRuntime = parse(atom, scope);

                if (expressionRuntime != null) {
                    return expressionRuntime;
                }
            }

            block = block.getParent();
        }

        return null;
    }

    public ExpressionRuntime parse(Atom atom, Scope scope) {
        String argumentSource = atom.getSourceCode();
        ScopeRepresentation scopeRepresentation = scope.getScopeRepresentation();

        for (final ArgumentRepresentation argumentRepresentation : scopeRepresentation.getArguments()) {
            for (HollowPattern hollowPattern : argumentRepresentation.getPatterns()) {
                if (hollowPattern.match(argumentSource)) {

                    if (!scope.argumentBelongsToScope(argumentRepresentation)) {
                        PandaException pandaException = new PandaException("Argument " + argumentSource + " is not allowed here", atom.getSourcesDivider());
                        return atom.getPandaParser().throwException(pandaException);
                    }

                    final Scope argumentScope = scope;
                    return new ExpressionRuntime(new Expression() {
                        @Override
                        public Object getValue(Ray ray) {
                            ray.argumentScope(argumentScope);
                            return argumentRepresentation.get(ray);
                        }
                    }, null);
                }
            }
        }

        return null;
    }

}
