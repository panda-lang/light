package org.panda_lang.light.framework.design.interpreter.lexer;

import org.junit.jupiter.api.Test;
import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;
import org.panda_lang.panda.framework.language.interpreter.source.PandaURLSource;

class IndentationLexerTest {

    private static final String PATH = "../examples/lexer/indentation.light";

    @Test
    public void testLexer() {
        IndentationLexer indentationLexer = new IndentationLexer(PandaURLSource.fromPath(PATH).getContent());
        TokenizedSource source = indentationLexer.convert();

        System.out.println(source);
    }

}
