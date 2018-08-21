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

package org.panda_lang.light.framework.design.architecture.linguistic.type;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.ContextComponent;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticCandidate;
import org.panda_lang.panda.language.runtime.ExecutableBranch;

import java.util.Collection;
import java.util.HashSet;

public class Types implements ContextComponent<Type<?>> {

    private final Collection<Type<?>> types = new HashSet<>();

    @Override
    public LinguisticCandidate<LinguisticAct> recognize(Context context, String sentence, @Nullable LinguisticCandidate<LinguisticAct> previousCandidate) {
        for (Type<?> type : types) {
            for (TypeTransformer<?> transformer : type.getTypeTransformer()) {
                Object result = transformer.transform(sentence);

                if (result == null) {
                    continue;
                }

                return new LinguisticCandidate<>(new LinguisticAct() {
                    @Override
                    public Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
                        return result;
                    }

                    @Override
                    public String getType() {
                        return type.getClassName();
                    }
                }, null, previousCandidate);
            }
        }

        return new LinguisticCandidate<>(false);
    }

    @Override
    public void registerElement(Type<?> element) {
        types.add(element);
    }

    @Override
    public Collection<? extends Type<?>> getElements() {
        return types;
    }

    @Override
    public Class<?> getComponentType() {
        return Type.class;
    }

}
