package org.panda_lang.light.design.interpreter.token.lexical;

import org.panda_lang.panda.utilities.commons.arrays.*;
import org.panda_lang.panda.utilities.commons.arrays.character.*;

import java.util.*;

// send [message] <string> to (console|terminal)

public class LexicalPatternCompiler {

    private final String expression;
    private final List<LexicalPatternElement> units;

    public LexicalPatternCompiler(String expression) {
        this.expression = expression;
        this.units = new ArrayList<>();
    }

    public List<LexicalPatternElement> compile() {
        StringBuilder unitBuilder = new StringBuilder();
        units.clear();

        CharArrayDistributor distributor = new CharArrayDistributor(expression.toCharArray());
        BracketContentReader contentReader = new BracketContentReader(distributor);

        while (distributor.hasNext()) {
            char currentChar = distributor.next();

            if (currentChar == '[') {
                LexicalPatternElement optionalElement = this.compileOptional(contentReader.read());
                units.add(optionalElement);
            }
            else if (currentChar == '<') {
                LexicalPatternElement typeElement = this.compileExpression(contentReader.read());
                units.add(typeElement);
            }
            else if (currentChar == '(') {
                LexicalPatternElement variantElement = this.compileExpression(contentReader.read());
                units.add(variantElement);
            }
            else {
                unitBuilder.append(currentChar);
            }
        }

        return units;
    }

    private LexicalPatternElement compileExpression(String pattern) {
        return new LexicalPatternUnit(LexicalPatternUnit.UnitType.EXPRESSION, pattern);
    }

    private LexicalPatternElement compileOptional(String pattern) {
        return new LexicalPatternUnit(LexicalPatternUnit.UnitType.STATIC, pattern);
    }

    private LexicalPatternElement compileVariant(String pattern) {
        return new LexicalPatternNode();
    }

}
