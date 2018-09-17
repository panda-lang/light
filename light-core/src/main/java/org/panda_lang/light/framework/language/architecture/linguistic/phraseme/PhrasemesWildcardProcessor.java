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

package org.panda_lang.light.framework.language.architecture.linguistic.phraseme;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticDescriptor;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticCandidate;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticWildcardProcessor;
import org.panda_lang.light.framework.language.architecture.linguistic.LightLinguisticDescriptor;

public class PhrasemesWildcardProcessor implements LinguisticWildcardProcessor {

    private static final PhrasemesWildcardProcessor INSTANCE = new PhrasemesWildcardProcessor();

    @Override
    public @Nullable LinguisticDescriptor handle(Context context, String details, String wildcard, @Nullable LinguisticCandidate<LinguisticDescriptor> previousCandidate) {
        LinguisticAct matchedAct = context.find(wildcard, previousCandidate);

        if (matchedAct == null) {
            return null;
        }

        Type<?> required = context.getType(details);
        Type<?> matched = matchedAct.getType();

        if (required == null || matched == null) {
            return null;
        }

        if (!required.isAssignableFrom(matched)) {
            return null;
        }

        return new LightLinguisticDescriptor("#TODO", matchedAct);
    }

    public static PhrasemesWildcardProcessor getInstance() {
        return INSTANCE;
    }

}
