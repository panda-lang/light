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

package org.panda_lang.light.framework.language.interpreter.parser.defaults;

import org.panda_lang.light.framework.design.interpreter.token.SentenceRepresentation;
import org.panda_lang.light.framework.language.interpreter.parser.scope.ScopeComponents;
import org.panda_lang.panda.framework.design.architecture.statement.Scope;
import org.panda_lang.panda.framework.design.architecture.statement.Statement;
import org.panda_lang.panda.framework.design.interpreter.parser.ParserData;
import org.panda_lang.panda.framework.design.interpreter.parser.UnifiedParser;
import org.panda_lang.panda.framework.design.interpreter.parser.component.UniversalComponents;
import org.panda_lang.panda.framework.design.interpreter.parser.generation.casual.GenerationLayer;
import org.panda_lang.panda.framework.design.interpreter.token.TokenRepresentation;
import org.panda_lang.panda.framework.design.interpreter.token.stream.SourceStream;
import org.panda_lang.panda.framework.language.interpreter.parser.PandaParserFailure;
import org.panda_lang.panda.framework.language.resource.syntax.sequence.Sequences;

public class ContentParser implements UnifiedParser {

    @Override
    public boolean parse(ParserData data, GenerationLayer nextLayer) {
        SentenceParser sentenceParser = new SentenceParser();

        SourceStream source = data.getComponent(UniversalComponents.SOURCE_STREAM);
        Scope scope = data.getComponent(ScopeComponents.SCOPE);

        while (source.hasUnreadSource()) {
            TokenRepresentation phrase = source.read();

            if (phrase instanceof SentenceRepresentation) {
                if (phrase.getTokenValue().startsWith(Sequences.LINE_ORIENTED_COMMENT.getSequenceStart())) {
                    continue;
                }

                Statement statement = sentenceParser.parse(data.fork(), (SentenceRepresentation) phrase);

                if (statement != null) {
                    scope.addStatement(statement);
                    continue;
                }

                throw new PandaParserFailure("Unknown statement", data);
            }

            throw new PandaParserFailure("Unknown token type", data);
        }

        return true;
    }

}
