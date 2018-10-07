package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.panda.framework.design.interpreter.lexer.Lexer;
import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;

public class LightIndentationLexer implements Lexer {

    private final String source;
    private final String lineSeparator;

    public LightIndentationLexer(String source) {
        this.source = source;
        this.lineSeparator = System.lineSeparator();
    }

    @Override
    public TokenizedSource convert() {
        LightIndentationLexerWorker worker = new LightIndentationLexerWorker(this);
        return worker.convert();
    }

    protected String getLineSeparator() {
        return lineSeparator;
    }

    protected String getSource() {
        return source;
    }

}
