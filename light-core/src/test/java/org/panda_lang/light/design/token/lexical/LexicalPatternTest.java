package org.panda_lang.light.design.token.lexical;

import org.junit.jupiter.api.*;
import org.panda_lang.light.design.interpreter.token.lexical.*;
import org.panda_lang.light.design.interpreter.token.lexical.extractor.*;

public class LexicalPatternTest {

    @Test
    public void testSoftLexicalPattern() {
        LexicalPattern pattern = LexicalPattern.builder()
                .compile("(send [message] * to (console|terminal[ ][screen *])|rand)")
                .build();

        LexicalExtractorResult result = pattern.extract("send 'test' to terminal screen X11");
        System.out.println(result.getWildcards());

        Assertions.assertTrue(result.isMatched());
        Assertions.assertNotNull(result.getIds());
        Assertions.assertNotNull(result.getWildcards());

        Assertions.assertAll(
                () -> Assertions.assertEquals("'test'", result.getWildcards().get(0)),
                () -> Assertions.assertEquals("X11", result.getWildcards().get(1))
        );
    }

    @Test
    public void testLexicalPattern() {
        LexicalPattern pattern = LexicalPattern.builder()
                .disableSoftMatching()
                .compile("(send[ message] * to (console|terminal[ ]screen *)|rand)")
                .build();

        LexicalExtractorResult result = pattern.extract("send 'test' to terminalscreen X11");
        System.out.println(result.getWildcards());

        Assertions.assertTrue(result.isMatched());
        Assertions.assertNotNull(result.getIds());
        Assertions.assertNotNull(result.getWildcards());

        Assertions.assertAll(
                () -> Assertions.assertEquals("'test'", result.getWildcards().get(0)),
                () -> Assertions.assertEquals("X11", result.getWildcards().get(1))
        );
    }

}
