package org.panda_lang.light.token.lexical;

import org.junit.jupiter.api.*;
import org.panda_lang.light.design.interpreter.token.lexical.*;

public class LexicalPatternTest {

    @Test
    public void testLexicalPattern() {
        LexicalPattern pattern = LexicalPattern.builder()
                .compile("send[ message] <string> to (console|terminal [screen])")
                .build();

        System.out.println(pattern);
    }

}
