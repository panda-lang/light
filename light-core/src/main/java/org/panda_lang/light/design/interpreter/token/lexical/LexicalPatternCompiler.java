package org.panda_lang.light.design.interpreter.token.lexical;

import org.panda_lang.light.design.interpreter.token.lexical.elements.*;
import org.panda_lang.panda.utilities.commons.arrays.*;
import org.panda_lang.panda.utilities.commons.arrays.character.*;

import java.util.*;

public class LexicalPatternCompiler {

    private final boolean softMatching;

    public LexicalPatternCompiler(boolean softMatching) {
        this.softMatching = softMatching;
    }

    public LexicalPatternElement compile(String pattern) {
        return this.compile(pattern, false);
    }

    public LexicalPatternElement compile(String pattern, boolean optional) {
        List<LexicalPatternElement> elements = new ArrayList<>();
        StringBuilder unitBuilder = new StringBuilder();

        CharArrayDistributor distributor = new CharArrayDistributor(pattern.toCharArray());
        BracketContentReader contentReader = new BracketContentReader(distributor);

        while (distributor.hasNext()) {
            char currentChar = distributor.next();

            if ((currentChar == '[' || currentChar == '<' || currentChar == '(' || currentChar == '*') && unitBuilder.length() > 0) {
                LexicalPatternUnit unit = new LexicalPatternUnit(unitBuilder.toString(), optional, softMatching);
                elements.add(unit);
                unitBuilder.setLength(0);
            }

            if (currentChar == '[') {
                LexicalPatternElement optionalElement = this.compileOptional(contentReader.readCurrent());
                elements.add(optionalElement);
            }
            else if (currentChar == '(') {
                LexicalPatternElement variantElement = this.compileVariant(contentReader.readCurrent());
                elements.add(variantElement);
            }
            else if (currentChar == '*') {
                elements.add(new LexicalPatternWildcard(optional));
            }
            else {
                unitBuilder.append(currentChar);
            }
        }

        if (unitBuilder.length() > 0) {
            LexicalPatternUnit unit = new LexicalPatternUnit(unitBuilder.toString(), optional, softMatching);
            elements.add(unit);
        }

        if (elements.size() == 0) {
            throw new RuntimeException("Empty element");
        }

        return elements.size() == 1 ? elements.get(0) : new LexicalPatternNode(elements, optional);
    }

    private LexicalPatternElement compileOptional(String pattern) {
        return this.compile(pattern, true);
    }

    private LexicalPatternElement compileVariant(String pattern) {
        AttentiveContentReader contentReader = new AttentiveContentReader(pattern);

        List<String> variants = contentReader.select('|');
        List<LexicalPatternElement> elements = new ArrayList<>(variants.size());

        for (String variant : variants) {
            elements.add(this.compile(variant));
        }

        return new LexicalPatternNode(elements, false, true);
    }

}
