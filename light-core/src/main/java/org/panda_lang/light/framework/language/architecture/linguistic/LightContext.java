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

package org.panda_lang.light.framework.language.architecture.linguistic;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.ContextComponent;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticGroup;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticCandidate;

import java.util.Collection;
import java.util.HashSet;

public class LightContext implements Context {

    protected final Collection<ContextComponent<?>> context;
    protected final LightContextTypeLookup typeLookup;

    private LightContext(Collection<ContextComponent<?>> context) {
        this.context = context;
        this.typeLookup = new LightContextTypeLookup(this);
    }

    public LightContext() {
        this(new HashSet<>());
    }

    @Override
    public void importComponent(ContextComponent<?> component) {
        context.add(component);
    }

    @Override
    public @Nullable LinguisticGroup find(String sentence, @Nullable LinguisticCandidate<LinguisticGroup> previousCandidate) {
        LinguisticCandidate<LinguisticGroup> candidate = findNext(sentence, null);

        while (candidate != null) {
            if (!candidate.isMatched()) {
                break;
            }

            LinguisticCandidate<LinguisticGroup> currentCandidate = findNext(sentence, candidate);

            if (candidate.getMatchedElement().compare(currentCandidate.getMatchedElement())) {
                candidate = null;
                break;
            }

            candidate = currentCandidate;
        }

        if (candidate == null) {
            return null;
        }

        return LightContextUtils.assignParameters(candidate);
    }

    private LinguisticCandidate<LinguisticGroup> findNext(String sentence, @Nullable LinguisticCandidate<LinguisticGroup> previousCandidate) {
        for (ContextComponent<?> contextComponent : context) {
            LinguisticCandidate<LinguisticGroup> candidate = contextComponent.recognize(this, sentence, previousCandidate);

            if (!candidate.isMatched()) {
                continue;
            }

            return candidate;
        }

        return LinguisticCandidate.notMatched();
    }

    @Override
    public LightContext fork() {
        return new LightContext(context);
    }

    @Override
    public @Nullable Type<?> getType(Class<?> clazz) {
        return typeLookup.getType(type -> clazz.isAssignableFrom(type.getAssociated()));
    }

    @Override
    public @Nullable Type<?> getType(String typeName) {
        return typeLookup.getType(type -> type.getClassName().equals(typeName) || type.getAssociated().getSimpleName().equals(typeName));
    }

}
