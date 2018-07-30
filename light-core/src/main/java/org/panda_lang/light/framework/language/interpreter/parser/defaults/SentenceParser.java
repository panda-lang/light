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

import org.panda_lang.light.framework.design.architecture.phraseme.Phraseme;
import org.panda_lang.light.framework.design.architecture.phraseme.PhrasemeCandidate;
import org.panda_lang.light.framework.design.architecture.phraseme.PhrasemeRepresentation;
import org.panda_lang.light.framework.design.architecture.phraseme.PhrasemesGroup;
import org.panda_lang.light.framework.design.interpreter.parser.LightComponents;
import org.panda_lang.light.framework.design.interpreter.token.SentenceRepresentation;
import org.panda_lang.panda.framework.design.architecture.dynamic.ExecutableStatement;
import org.panda_lang.panda.framework.design.architecture.statement.Statement;
import org.panda_lang.panda.framework.design.interpreter.parser.Parser;
import org.panda_lang.panda.framework.design.interpreter.parser.ParserData;
import org.panda_lang.panda.language.runtime.ExecutableBranch;
import org.panda_lang.panda.framework.language.interpreter.parser.PandaParserFailure;

public class SentenceParser implements Parser {

    public Statement parse(ParserData data, SentenceRepresentation sentenceRepresentation) {
        String sentence = sentenceRepresentation.getTokenValue();

        PhrasemesGroup phrasemes = data.getComponent(LightComponents.PHRASEMES);
        PhrasemeCandidate candidate = phrasemes.find(sentence, null);

        while (candidate != null) {
            if (!candidate.isMatched() || candidate.isDefinite()) {
                break;
            }

            PhrasemeCandidate currentCandidate = phrasemes.find(sentence, candidate);

            if (candidate.equals(currentCandidate)) {
                candidate = null;
                break;
            }

            candidate = currentCandidate;
        }

        if (candidate == null || !candidate.isMatched()) {
            throw new PandaParserFailure("Unknown sentence", data);
        }

        PhrasemeRepresentation matchedPhraseme = candidate.getMatchedPhraseme();
        Phraseme phraseme = matchedPhraseme.getPhraseme();

        return new ExecutableStatement() {
            @Override
            public void execute(ExecutableBranch branch) {
                phraseme.execute(branch);
            }
        };
    }

}
