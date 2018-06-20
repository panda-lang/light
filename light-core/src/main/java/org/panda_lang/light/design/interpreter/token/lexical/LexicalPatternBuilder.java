package org.panda_lang.light.design.interpreter.token.lexical;

public class LexicalPatternBuilder {

    private final LexicalPatternCompiler compiler = new LexicalPatternCompiler();
    private LexicalPatternElement pattern;

    public LexicalPatternBuilder compile(String pattern) {
        LexicalPatternElement compiledPattern = compiler.compile(pattern);

        if (compiledPattern == null) {
            throw new RuntimeException("Cannot compile pattern: " + pattern);
        }

        this.pattern = compiledPattern;
        return this;
    }

    public LexicalPattern build() {
        return new LexicalPattern(pattern);
    }

}
