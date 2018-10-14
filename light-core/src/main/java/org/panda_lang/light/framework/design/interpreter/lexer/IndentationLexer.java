package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;

public class IndentationLexer extends AbstractLexer {

    public IndentationLexer(String source, String lineSeparator) {
        super(source, lineSeparator);
    }

    public IndentationLexer(String content) {
        super(content);
    }

    @Override
    public TokenizedSource convert() {
        IndentationLexerWorker worker = new IndentationLexerWorker(this);
        return worker.convert();
    }

}
