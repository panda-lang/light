package org.panda_lang.moonlight.core.parser;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.MoonlightScript;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.*;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.PandaException;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.essential.EssenceParser;
import org.panda_lang.panda.core.parser.essential.RuntimeParser;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.statement.Factor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExpressionParser implements Parser {

    public final MoonlightCore moonlightCore;

    public ExpressionParser(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    @Override
    public ExpressionRuntime parse(final Atom atom) {
        final String expressionSource = atom.getSourceCode().trim();
        final ExpressionCenter expressionCenter = moonlightCore.getExpressionCenter();

        for (final ExpressionRepresentation expressionRepresentation : expressionCenter.getElements()) {
            for (final HollowPattern pattern : expressionRepresentation.getPatterns()) {
                if (pattern.match(expressionSource)) {
                    final Collection<String> hollows = new ArrayList<>(pattern.getHollows());
                    final List<ExpressionRuntime> expressions = parse(atom, hollows);
                    final Factor[] factors = ExpressionUtils.toFactors(expressions);

                    final Expression expression = expressionRepresentation.getExpression();

                    return new ExpressionRuntime(expression, null) {
                        @Override
                        public Essence get(Ray ray) {
                            ray.script((MoonlightScript) atom.getPandaScript())
                                    .pattern(pattern)
                                    .expressionRuntimes(expressions)
                                    .factors(factors);
                            return super.get(ray);
                        }
                    };
                }
            }
        }

        for (ExpressionRepresentation expressionRepresentation : expressionCenter.getInitializables()) {
            ExpressionInitializer initializer = expressionRepresentation.getExpressionInitializer();
            if (initializer.match(expressionSource)) {
                return initializer.initialize(atom);
            }
        }

        ArgumentParser argumentParser = new ArgumentParser();
        ExpressionRuntime argument = argumentParser.parse(atom);

        if (argument != null) {
            return argument;
        }

        EssenceParser essenceParser = new EssenceParser();
        Essence essence = essenceParser.parse(atom);

        if (essence != null) {
            Factor factor = new Factor(essence);
            return new ExpressionRuntime(factor);
        }

        RuntimeParser runtimeParser = new RuntimeParser();
        Factor factor = runtimeParser.parse(atom);

        if (factor == null) {
            PandaException pandaException = new PandaException("Unknown expression '" + expressionSource + "'", atom.getSourcesDivider());
            return atom.getPandaParser().throwException(pandaException);
        }

        return new ExpressionRuntime(factor);
    }

    public ExpressionRuntime parse(Atom atom, String expression) {
        if (expression == null || expression.isEmpty()) {
            return null;
        }
        atom.setSourceCode(expression);
        return parse(atom);
    }

    public List<ExpressionRuntime> parse(Atom atom, Collection<String> expressions) {
        List<ExpressionRuntime> executables = new ArrayList<>(expressions.size());
        for (String expression : expressions) {
            if (expression == null || expression.isEmpty()) {
                continue;
            }
            ExpressionRuntime namedExecutable = parse(atom, expression);
            executables.add(namedExecutable);
        }
        return executables;
    }

}
