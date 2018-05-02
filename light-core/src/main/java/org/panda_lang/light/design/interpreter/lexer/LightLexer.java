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

package org.panda_lang.light.design.interpreter.lexer;

import org.panda_lang.light.design.interpreter.source.*;
import org.panda_lang.light.design.interpreter.token.*;
import org.panda_lang.panda.framework.design.interpreter.lexer.*;
import org.panda_lang.panda.framework.design.interpreter.token.*;

import java.util.*;

public class LightLexer implements Lexer {

    private final String source;
    private String lineSeparator = System.lineSeparator();

    public LightLexer(String source) {
        this.source = source;
    }

    @Override
    public TokenizedSource convert() {
        List<TokenRepresentation> tokens = new ArrayList<>();

        String[] lines = source.split(lineSeparator);
        StringBuilder lineBuilder = new StringBuilder();
        boolean multiline = false;
        int previousLine = -1;

        for (int lineNumber = 0; lineNumber < lines.length; lineNumber++) {
            String line = lines[lineNumber];
            String preparedLine = line.trim();

            if (preparedLine.isEmpty()) {
                continue;
            }

            if (previousLine == -1) {
                previousLine = lineNumber;
            }

            boolean startsWithMultiline = preparedLine.startsWith(">");
            boolean endsWithMultiline = preparedLine.endsWith(">");

            if (!multiline && !startsWithMultiline && lineBuilder.length() > 0) {
                String phraseValue = lineBuilder.toString();

                /*
                boolean open = phraseValue.endsWith("{");
                boolean close = phraseValue.startsWith("}");

                if (open) {
                    phraseValue = phraseValue.substring(0, phraseValue.length() - 1);
                }

                if (close) {
                    phraseValue = phraseValue.substring(1, phraseValue.length());
                }
                */

                Phrase phrase = new Phrase(phraseValue);
                PhraseRepresentation representation = new PhraseRepresentation(phrase, previousLine);
                tokens.add(representation);

                /*
                if (open || close) {
                    Token operator = open ? Separators.LEFT_BRACE_DELIMITER : Separators.RIGHT_BRACE_DELIMITER;
                    TokenRepresentation separatorRepresentation = new PandaTokenRepresentation(operator, previousLine);
                    tokens.add(separatorRepresentation);
                }
                */

                lineBuilder.setLength(0);
                previousLine = lineNumber;
            }

            if (startsWithMultiline) {
                preparedLine = preparedLine.substring(2, preparedLine.length());
            }

            if (endsWithMultiline) {
                preparedLine = preparedLine.substring(0, preparedLine.length() - 2);
            }

            if (lineBuilder.length() > 0) {
                lineBuilder.append(" ");
            }

            lineBuilder.append(preparedLine);
            multiline = endsWithMultiline;
        }

        if (lineBuilder.length() > 0) {
            Phrase phrase = new Phrase(lineBuilder.toString());
            PhraseRepresentation representation = new PhraseRepresentation(phrase, previousLine);
            tokens.add(representation);
        }

        return new LightTokenizedSource(tokens);
    }

    public void setLineSeparator(String regex) {
        this.lineSeparator = regex;
    }

}
