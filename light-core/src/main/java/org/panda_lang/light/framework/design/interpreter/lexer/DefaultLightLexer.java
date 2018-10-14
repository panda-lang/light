/*
 * Copyright (c) 2016-2018 Dzikoysk
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

package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;

public class DefaultLightLexer extends AbstractLexer {

    public DefaultLightLexer(String source, String lineSeparator) {
        super(source, lineSeparator);
    }

    public DefaultLightLexer(String content) {
        super(content);
    }

    @Override
    public TokenizedSource convert() {
        DefaultLightLexerWorker worker = new DefaultLightLexerWorker(this);
        return worker.convert();
    }

}
