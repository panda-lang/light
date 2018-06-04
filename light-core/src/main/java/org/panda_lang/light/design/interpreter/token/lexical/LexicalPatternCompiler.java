package org.panda_lang.light.design.interpreter.token.lexical;

import org.panda_lang.panda.utilities.commons.arrays.*;
import org.panda_lang.panda.utilities.commons.arrays.character.*;

import java.util.*;

// send [message] <string> to (console|terminal)

public class LexicalPatternCompiler {

    public List<LexicalPatternElement> compile(String pattern) {
        List<LexicalPatternElement> elements = new ArrayList<>();
        StringBuilder unitBuilder = new StringBuilder();

        CharArrayDistributor distributor = new CharArrayDistributor(pattern.toCharArray());
        BracketContentReader contentReader = new BracketContentReader(distributor);

        while (distributor.hasNext()) {
            char currentChar = distributor.next();

            if ((currentChar == '[' || currentChar == '<' || currentChar == '(') && unitBuilder.length() > 0) {
                String unitContent = unitBuilder.toString();

                LexicalPatternUnit unit = new LexicalPatternUnit(LexicalPatternUnit.UnitType.STATIC, unitContent, false);
                elements.add(unit);

                unitBuilder.setLength(0);
            }

            if (currentChar == '[') {
                LexicalPatternElement optionalElement = this.compileOptional(contentReader.read());
                elements.add(optionalElement);
            }
            else if (currentChar == '<') {
                LexicalPatternElement typeElement = this.compileType(contentReader.read());
                elements.add(typeElement);
            }
            else if (currentChar == '(') {
                LexicalPatternElement variantElement = this.compileVariant(contentReader.read());
                elements.add(variantElement);
            }
            else {
                unitBuilder.append(currentChar);
            }
        }

        return elements;
    }

    private LexicalPatternElement compileType(String pattern) {
        return new LexicalPatternUnit(LexicalPatternUnit.UnitType.EXPRESSION, pattern.substring(1, pattern.length() - 1), false);
    }

    private LexicalPatternElement compileOptional(String pattern) {
        return new LexicalPatternUnit(LexicalPatternUnit.UnitType.STATIC, pattern, true);
    }

    private LexicalPatternElement compileVariant(String pattern) {
        return new LexicalPatternNode(false);
    }

}
