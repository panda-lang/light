package org.panda_lang.light.token.lexical;

import org.junit.jupiter.api.*;
import org.panda_lang.light.design.interpreter.token.lexical.*;

import java.util.*;

public class LexicalPatternTest {

    @Test
    public void testLexicalPattern() {
        LexicalPattern pattern = LexicalPattern.builder()
                .compile("send[ message] <string> to (console|terminal [screen])")
                .build();

        List<String> matches = pattern.extract("send message 'test' to console");
        System.out.println(matches);
    }

}
