package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.light.framework.design.interpreter.source.LightTokenizedSource;
import org.panda_lang.panda.framework.design.interpreter.lexer.Lexer;
import org.panda_lang.panda.framework.design.interpreter.token.TokenRepresentation;
import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;

import java.util.List;

class IndentationLexerWorker implements Lexer {

    private final IndentationLexer lexer;

    protected IndentationLexerWorker(IndentationLexer lexer) {
        this.lexer = lexer;
    }

    @Override
    public TokenizedSource convert() {
        String[] lines = lexer.getSource().split(lexer.getLineSeparator());

        IndentationLexerTree tree = new IndentationLexerTree();
        List<Object> result = tree.build(lines);

        IndentationLexerConverter converter = new IndentationLexerConverter();
        List<TokenRepresentation> tokens = converter.convert(result);

        return new LightTokenizedSource(tokens);
    }

}
