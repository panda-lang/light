package org.panda_lang.light.design.interpreter.token.lexical;

import org.panda_lang.light.design.interpreter.token.lexical.elements.*;

public class LexicalPatternBuilder {

    private LexicalPatternElement pattern;
    private boolean softMatching = true;

    public LexicalPatternBuilder compile(String pattern) {
        LexicalPatternCompiler compiler = new LexicalPatternCompiler(softMatching);
        LexicalPatternElement compiledPattern = compiler.compile(pattern);

        if (compiledPattern == null) {
            throw new RuntimeException("Cannot compile pattern: " + pattern);
        }

        this.pattern = compiledPattern;
        return this;
    }

    public LexicalPatternBuilder disableSoftMatching() {
        this.softMatching = false;
        return this;
    }

    public LexicalPattern build() {
        return new LexicalPattern(pattern, softMatching);
    }

}
