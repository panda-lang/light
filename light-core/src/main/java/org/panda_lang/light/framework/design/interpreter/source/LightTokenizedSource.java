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

package org.panda_lang.light.framework.design.interpreter.source;

import org.panda_lang.panda.framework.design.interpreter.token.TokenRepresentation;
import org.panda_lang.panda.framework.language.interpreter.token.PandaTokenizedSource;

import java.util.List;

public class LightTokenizedSource extends PandaTokenizedSource {

    public LightTokenizedSource(List<TokenRepresentation> tokenRepresentations) {
        super(tokenRepresentations);
    }

    @Override
    public String toString() {
        StringBuilder messageBuilder = new StringBuilder()
                .append("src: { ")
                .append(System.lineSeparator());

        for (TokenRepresentation representation : super.getTokensRepresentations()) {
            messageBuilder
                    .append("  ")
                    .append(representation.getTokenType())
                    .append(" [at ").append(representation.getLine() + 1).append("]: ")
                    .append(representation.getTokenValue())
                    .append(System.lineSeparator());
        }

        return messageBuilder.append("}").toString();
    }

}
