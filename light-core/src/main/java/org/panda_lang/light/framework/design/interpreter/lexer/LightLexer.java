package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;

public class LightLexer extends AbstractLexer {

    public LightLexer(String source) {
        super(source);
    }

    @Override
    public TokenizedSource convert() {
        LightLexerWorker worker = new LightLexerWorker(this);
        return worker.convert();
    }

}
