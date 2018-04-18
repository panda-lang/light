/*
 * Copyright (c) 2015-2018 Dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.light.lexer;

import org.junit.jupiter.api.Test;
import org.panda_lang.light.design.interpreter.lexer.LightLexer;
import org.panda_lang.panda.framework.design.interpreter.lexer.Lexer;
import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;
import org.panda_lang.panda.framework.language.interpreter.source.PandaCodeSource;

public class MultilineLexerTest {

    private final PandaCodeSource source = PandaCodeSource.fromPath("../examples/lexer/multiline_test.light");

    @Test
    public void testLexer() {
        Lexer lexer = new LightLexer(source.getContent());
        TokenizedSource tokenizedSource = lexer.convert();

        System.out.println(tokenizedSource);
    }

}