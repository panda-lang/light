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

package org.panda_lang.light.design.interpreter.parser.defaults;

import org.panda_lang.light.design.architecture.phraseme.Phraseme;
import org.panda_lang.light.design.architecture.phraseme.PhrasemeCandidate;
import org.panda_lang.light.design.architecture.phraseme.PhrasemesGroup;
import org.panda_lang.light.design.interpreter.parser.LightComponents;
import org.panda_lang.light.design.interpreter.token.SentenceRepresentation;
import org.panda_lang.panda.framework.design.architecture.statement.Statement;
import org.panda_lang.panda.framework.design.interpreter.parser.Parser;
import org.panda_lang.panda.framework.design.interpreter.parser.ParserData;
import org.panda_lang.panda.framework.language.interpreter.parser.PandaParserFailure;

public class SentenceParser implements Parser {

    public Statement parse(ParserData data, SentenceRepresentation sentenceRepresentation) {
        String sentence = sentenceRepresentation.getTokenValue();

        PhrasemesGroup phrasemes = data.getComponent(LightComponents.PHRASEMES);
        PhrasemeCandidate candidate = null;

        while (true) {
            candidate = phrasemes.find(sentence, candidate);

            if (!candidate.isMatched()) {
                break;
            }

            break;
        }

        if (!candidate.isMatched()) {
            throw new PandaParserFailure("Unknown sentence", data);
        }

        Phraseme phraseme = candidate.getPhraseme();
        return null;
    }

}
