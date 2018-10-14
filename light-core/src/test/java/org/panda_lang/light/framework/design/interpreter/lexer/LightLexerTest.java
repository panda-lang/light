package org.panda_lang.light.framework.design.interpreter.lexer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.panda_lang.panda.framework.design.interpreter.lexer.Lexer;
import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;
import org.panda_lang.panda.framework.language.interpreter.source.PandaURLSource;

class LightLexerTest {

    private static final String DEFAULT = "../examples/lexer/multiline_test.light";
    private static final String INDENTATION = "../examples/lexer/indentation.light";

    @Test
    public void testDefaultLexer() {
        Lexer indentationLexer = new LightLexer(PandaURLSource.fromPath(DEFAULT).getContent());
        TokenizedSource source = indentationLexer.convert();

        Assertions.assertNotNull(source);
        Assertions.assertTrue(source.size() > 0);
    }

    @Test
    public void testIndentationLexer() {
        Lexer indentationLexer = new LightLexer(PandaURLSource.fromPath(INDENTATION).getContent());
        TokenizedSource source = indentationLexer.convert();

        Assertions.assertNotNull(source);
        Assertions.assertTrue(source.size() > 0);
    }

}
