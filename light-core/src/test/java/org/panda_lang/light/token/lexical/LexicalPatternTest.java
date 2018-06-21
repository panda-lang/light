package org.panda_lang.light.token.lexical;

import org.junit.jupiter.api.*;
import org.panda_lang.light.design.interpreter.token.lexical.*;
import org.panda_lang.light.design.interpreter.token.lexical.extractor.*;

public class LexicalPatternTest {

    @Test
    public void testLexicalPattern() {
        LexicalPattern pattern = LexicalPattern.builder()
                .compile("(send[ message] * to (console|terminal [screen])|rand)")
                .build();

        LexicalExtractorResult result = pattern.extract("send message 'test' to console");
        Assertions.assertTrue(result.isMatched());
    }

}
