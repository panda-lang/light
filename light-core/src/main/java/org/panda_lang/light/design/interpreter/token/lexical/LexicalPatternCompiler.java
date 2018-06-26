package org.panda_lang.light.design.interpreter.token.lexical;

import org.panda_lang.light.design.interpreter.token.lexical.elements.*;
import org.panda_lang.panda.utilities.commons.arrays.*;
import org.panda_lang.panda.utilities.commons.arrays.character.*;

import java.util.*;

public class LexicalPatternCompiler {

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
                String unitContent = unitBuilder.toString().trim();

                if (unitContent.length() > 0) {
                    LexicalPatternUnit unit = new LexicalPatternUnit(unitBuilder.toString(), optional);
                    elements.add(unit);
                    unitBuilder.setLength(0);
                }
            }

            char previousChar = distributor.getPrevious();
            LexicalPatternElement element = null;

            if (currentChar == '[') {
                element = this.compileOptional(contentReader.readCurrent());
            }
            else if (currentChar == '(') {
                element = this.compileVariant(contentReader.readCurrent());
            }
            else if (currentChar == '*') {
                element = new LexicalPatternWildcard(optional);
            }
            else {
                unitBuilder.append(currentChar);
            }

            if (element != null) {
                element.setIsolationType(LexicalPatternElement.Isolation.of(previousChar, distributor.getNext()));
                elements.add(element);
            }
        }

        if (unitBuilder.length() > 0) {
            LexicalPatternUnit unit = new LexicalPatternUnit(unitBuilder.toString(), optional);
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
