package org.panda_lang.light.design.token.lexical;

import org.junit.jupiter.api.*;
import org.panda_lang.light.design.interpreter.token.lexical.*;
import org.panda_lang.light.design.interpreter.token.lexical.extractor.*;

public class LexicalPatternTest {

    @Test
    public void testLexicalPattern() {
        LexicalPattern pattern = LexicalPattern.builder()
                .compile("(send msg:[message] wildcard:* 3:to (console|terminalIdentifier:terminal[ ][screen *])|rand)")
                .build();

        LexicalExtractorResult result = pattern.extract("send 'test' to terminalscreen X11");

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isMatched());

        Assertions.assertNotNull(result.getIdentifiers());
        Assertions.assertNotNull(result.getWildcards());

        System.out.println(result.getWildcards());

        Assertions.assertAll(
                () -> Assertions.assertEquals("'test'", result.getWildcards().get(0)),
                () -> Assertions.assertEquals("X11", result.getWildcards().get(1))
        );
    }

}
