package org.panda_lang.light.core.parser.essential;

import org.panda_lang.light.Light;
import org.panda_lang.light.core.parser.essential.assistant.ExpressionRepresentation;
import org.panda_lang.light.core.parser.util.HollowPattern;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.essential.FactorParser;
import org.panda_lang.panda.core.parser.essential.assistant.FieldAssistant;
import org.panda_lang.panda.core.syntax.Factor;

import java.util.ArrayList;
import java.util.Collection;

public class ExpressionParser implements Parser {

    public final Light light;

    public ExpressionParser(Light light) {
        this.light = light;
    }

    @Override
    public Factor parse(Atom atom) {
        String expression = FieldAssistant.clear(atom.getSourceCode(), 0);

        // <Light expr here>
        for (ExpressionRepresentation expressionRepresentation : light.getLightCore().getExpressionCenter().getExpressions()) {
            for (HollowPattern pattern : expressionRepresentation.getPatterns()) {
                if (pattern.match(expression)) {
                    return null;
                }
            }
        }

        FactorParser factorParser = new FactorParser();
        return factorParser.parse(atom, expression);
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
