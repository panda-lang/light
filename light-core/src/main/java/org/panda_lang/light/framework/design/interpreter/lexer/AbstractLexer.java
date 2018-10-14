package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.panda.framework.design.interpreter.lexer.Lexer;

abstract class AbstractLexer implements Lexer {

    private final String source;
    private final String lineSeparator;

    AbstractLexer(String source, String lineSeparator) {
        this.source = source;
        this.lineSeparator = lineSeparator;
    }

    AbstractLexer(String source) {
        this(source, System.lineSeparator());
    }

    protected String getLineSeparator() {
        return lineSeparator;
    }

    protected String getSource() {
        return source;
    }

}
