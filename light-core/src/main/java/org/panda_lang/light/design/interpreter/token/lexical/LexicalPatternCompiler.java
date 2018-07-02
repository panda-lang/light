package org.panda_lang.light.design.interpreter.token.lexical;

import org.panda_lang.light.design.interpreter.token.lexical.elements.*;
import org.panda_lang.panda.utilities.commons.arrays.*;
import org.panda_lang.panda.utilities.commons.arrays.character.*;
import org.panda_lang.panda.utilities.commons.objects.*;

import java.util.*;

public class LexicalPatternCompiler {

    private static final char[] IDENTIFIER_CHARACTERS = CharacterUtils.mergeArrays(CharacterUtils.LETTERS, CharacterUtils.DIGITS, CharacterUtils.arrayOf('-'));

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
            String identifier = null;

            if ((currentChar == '[' || currentChar == '<' || currentChar == '(' || currentChar == '*') && unitBuilder.length() > 0) {
                String unitContent = unitBuilder.toString();

                if (!StringUtils.isEmpty(unitContent)) {
                    identifier = this.compileIdentifier(unitContent);
                    boolean current = false;

                    if (identifier != null) {
                        int identifierIndex = unitContent.trim().indexOf(identifier);

                        if (identifierIndex == 0) {
                            current = true;
                            unitContent = unitContent.substring(unitContent.indexOf(':') + 1);
                        }
                        else {
                            unitContent = unitContent.substring(0, unitContent.lastIndexOf(':') - identifier.length());
                        }
                    }

                    if (!StringUtils.isEmpty(unitContent)) {
                        LexicalPatternUnit unit = new LexicalPatternUnit(unitContent, optional);

                        if (current) {
                            unit.setIdentifier(identifier);
                            identifier = null;
                        }

                        elements.add(unit);
                        unitBuilder.setLength(0);
                    }
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
                LexicalPatternElement.Isolation parentIsolation = LexicalPatternElement.Isolation.of(previousChar, distributor.getNext());
                LexicalPatternElement.Isolation commonIsolation = LexicalPatternElement.Isolation.merge(parentIsolation, element.getIsolationType());
                element.setIsolationType(commonIsolation);

                if (identifier != null) {
                    element.setIdentifier(identifier);
                }

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

    private String compileIdentifier(String pattern) {
        pattern = pattern.trim();

        if (pattern.length() < 2 || !pattern.contains(":")) {
            return null;
        }

        String identifier = null;

        if (pattern.endsWith(":")) {
            int lastIndex = pattern.lastIndexOf(" ");
            identifier = pattern.substring(lastIndex == -1 ? 0 : lastIndex + 1, pattern.length() - 1);
        }
        else {
            AttentiveContentReader contentReader = new AttentiveContentReader(pattern);
            List<String> variants = contentReader.select(':');

            if (variants.size() < 2) {
                return null;
            }

            identifier = variants.get(0).trim();

            if (identifier.contains(" ")) {
                return null;
            }
        }

        if (StringUtils.isEmpty(identifier)) {
            return null;
        }

        if (StringUtils.containsOtherCharacters(identifier, IDENTIFIER_CHARACTERS)) {
            return null;
        }

        return identifier;
    }

}
