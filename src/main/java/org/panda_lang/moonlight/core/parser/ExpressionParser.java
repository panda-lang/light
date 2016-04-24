package org.panda_lang.moonlight.core.parser;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.MoonlightScript;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.*;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.core.parser.ParserInfo;
import org.panda_lang.panda.core.parser.PandaException;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.essential.EssenceParser;
import org.panda_lang.panda.core.parser.essential.RuntimeParser;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.statement.RuntimeValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExpressionParser implements Parser {

    public final MoonlightCore moonlightCore;

    public ExpressionParser(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    @Override
    public ExpressionRuntime parse(final ParserInfo parserInfo) {
        final String expressionSource = parserInfo.getSourceCode().trim();
        final ExpressionCenter expressionCenter = moonlightCore.getExpressionCenter();

        for (final ExpressionRepresentation expressionRepresentation : expressionCenter.getElements()) {
            for (final HollowPattern pattern : expressionRepresentation.getPatterns()) {
                if (pattern.match(expressionSource)) {
                    final Collection<String> hollows = new ArrayList<>(pattern.getHollows());
                    final List<ExpressionRuntime> expressions = parse(parserInfo, hollows);
                    final RuntimeValue[] runtimeValues = ExpressionUtils.toFactors(expressions);

                    final Expression expression = expressionRepresentation.getExpression();

                    return new ExpressionRuntime(expression, null) {
                        @Override
                        public Essence get(Ray ray) {
                            ray.script((MoonlightScript) parserInfo.getPandaScript())
                                    .pattern(pattern)
                                    .expressionRuntimes(expressions)
                                    .factors(runtimeValues);
                            return super.get(ray);
                        }
                    };
                }
            }
        }

        for (ExpressionRepresentation expressionRepresentation : expressionCenter.getInitializables()) {
            ExpressionInitializer initializer = expressionRepresentation.getExpressionInitializer();
            if (initializer.match(expressionSource)) {
                return initializer.initialize(parserInfo);
            }
        }

        ArgumentParser argumentParser = new ArgumentParser();
        ExpressionRuntime argument = argumentParser.parse(parserInfo);

        if (argument != null) {
            return argument;
        }

        EssenceParser essenceParser = new EssenceParser();
        Essence essence = essenceParser.parse(parserInfo);

        if (essence != null) {
            RuntimeValue runtimeValue = new RuntimeValue(essence);
            return new ExpressionRuntime(runtimeValue);
        }

        RuntimeParser runtimeParser = new RuntimeParser();
        RuntimeValue runtimeValue = runtimeParser.parse(parserInfo);

        if (runtimeValue == null) {
            PandaException pandaException = new PandaException("Unknown expression '" + expressionSource + "'", parserInfo.getSourcesDivider());
            return parserInfo.getPandaParser().throwException(pandaException);
        }

        return new ExpressionRuntime(runtimeValue);
    }

    public ExpressionRuntime parse(ParserInfo parserInfo, String expression) {
        if (expression == null || expression.isEmpty()) {
            return null;
        }
        parserInfo.setSourceCode(expression);
        return parse(parserInfo);
    }

    public List<ExpressionRuntime> parse(ParserInfo parserInfo, Collection<String> expressions) {
        List<ExpressionRuntime> executables = new ArrayList<>(expressions.size());
        for (String expression : expressions) {
            if (expression == null || expression.isEmpty()) {
                continue;
            }
            ExpressionRuntime namedExecutable = parse(parserInfo, expression);
            executables.add(namedExecutable);
        }
        return executables;
    }

}
