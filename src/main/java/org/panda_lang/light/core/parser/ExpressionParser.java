package org.panda_lang.light.core.parser;

import org.panda_lang.light.Light;
import org.panda_lang.light.LightScript;
import org.panda_lang.light.core.Expression;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.parser.assistant.ExpressionRepresentation;
import org.panda_lang.light.core.parser.pattern.LightPattern;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.essential.FactorParser;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Executable;
import org.panda_lang.panda.core.syntax.Factor;
import org.panda_lang.panda.core.syntax.Runtime;

import java.util.ArrayList;
import java.util.Collection;

public class ExpressionParser implements Parser {

    public final Light light;

    public ExpressionParser(Light light) {
        this.light = light;
    }

    @Override
    public Factor parse(Atom atom) {
        String expressionSource = atom.getSourceCode().trim();

        for (final ExpressionRepresentation expressionRepresentation : light.getLightCore().getExpressionCenter().getExpressions()) {
            for (LightPattern pattern : expressionRepresentation.getPatterns()) {
                if (pattern.match(expressionSource)) {
                    final Collection<String> hollows = new ArrayList<>(pattern.getHollows());
                    final Collection<Factor> expressions = parse(atom, hollows);

                    final Factor[] array = new Factor[expressions.size()];
                    final Factor[] factors = expressions.toArray(array);

                    final Expression expression = expressionRepresentation.getRepresentation();
                    final Ray ray = new Ray()
                            .lightScript((LightScript) atom.getPandaScript())
                            .pattern(pattern);

                    final Runtime runtime = new Runtime(null, new Executable() {
                        @Override
                        public Essence run(Particle particle) {
                            ray.include(particle);
                            return expression.getValue(ray);
                        }
                    }, factors);

                    return new Factor(runtime);
                }
            }
        }

        FactorParser factorParser = new FactorParser();
        return factorParser.parse(atom, expressionSource);
    }

    public Factor parse(Atom atom, String expression) {
        atom.setSourceCode(expression);
        return parse(atom);
    }

    public Collection<Factor> parse(Atom atom, Collection<String> expressions) {
        Collection<Factor> executables = new ArrayList<>(expressions.size());
        for (String expression : expressions) {
            Factor namedExecutable = parse(atom, expression);
            executables.add(namedExecutable);
        }
        return executables;
    }


}
