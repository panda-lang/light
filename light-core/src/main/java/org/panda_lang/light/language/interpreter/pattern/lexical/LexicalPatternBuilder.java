package org.panda_lang.light.language.interpreter.pattern.lexical;

import org.panda_lang.light.language.interpreter.pattern.lexical.elements.LexicalPatternElement;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.processed.WildcardProcessor;

public class LexicalPatternBuilder<T> {

    private LexicalPatternElement pattern;
    private WildcardProcessor<T> wildcardProcessor;

    public LexicalPatternBuilder<T> compile(String pattern) {
        LexicalPatternCompiler compiler = new LexicalPatternCompiler();
        LexicalPatternElement compiledPattern = compiler.compile(pattern);

        if (compiledPattern == null) {
            throw new RuntimeException("Cannot compile pattern: " + pattern);
        }

        this.pattern = compiledPattern;
        return this;
    }

    public LexicalPatternBuilder<T> setWildcardProcessor(WildcardProcessor<T> wildcardProcessor) {
        this.wildcardProcessor = wildcardProcessor;
        return this;
    }

    public LexicalPattern<T> build() {
        return new LexicalPattern<>(pattern, wildcardProcessor);
    }

}
