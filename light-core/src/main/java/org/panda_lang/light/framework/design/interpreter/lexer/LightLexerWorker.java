package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.panda.framework.design.interpreter.lexer.Lexer;
import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;

class LightLexerWorker implements Lexer {

    private final LightLexer lexer;

    public LightLexerWorker(LightLexer lexer) {
        this.lexer = lexer;
    }

    @Override
    public TokenizedSource convert() {
        Lexer matchedLexer = findLexer(lexer.getSource());
        return matchedLexer.convert();
    }

    private Lexer findLexer(String source) {
        return endsWith(source, ":") ? new IndentationLexer(source, lexer.getLineSeparator()) : new DefaultLightLexer(source, lexer.getLineSeparator());
    }

    private boolean endsWith(String source, String element) {
        for (String line : source.split(lexer.getLineSeparator())) {
            if (line.endsWith(element)) {
                return true;
            }
        }

        return false;
    }

}
