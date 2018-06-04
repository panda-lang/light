package org.panda_lang.light.design.interpreter.token.lexical;

import java.util.*;

public class LexicalPatternBuilder {

    private final List<LexicalPatternElement> elements = new ArrayList<>();
    private final LexicalPatternCompiler compiler = new LexicalPatternCompiler();

    public LexicalPatternBuilder compile(String pattern) {
        List<LexicalPatternElement> compiledElements = compiler.compile(pattern);

        if (compiledElements == null) {
            throw new RuntimeException("Cannot compile pattern: " + pattern);
        }

        elements.addAll(compiledElements);
        return this;
    }

    public LexicalPattern build() {
        return new LexicalPattern();
    }

}
