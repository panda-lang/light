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

package org.panda_lang.light.framework.design.architecture.type;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.dynamic.LinguisticAct;
import org.panda_lang.panda.framework.design.architecture.prototype.PandaClassPrototypeBuilder;

import java.util.function.Function;

public class LightTypeBuilder extends PandaClassPrototypeBuilder<LightTypeBuilder, LightType> {

    protected TypeTransformer transformer;
    protected TypeSerializer<?> serializer;
    protected Function<?, String> stringifier;

    protected LightTypeBuilder() {
        this.transformer = new DefaultTypeTransformer();
    }

    public LightTypeBuilder serializer(TypeSerializer<?> serializer) {
        this.serializer = serializer;
        return this;
    }

    public LightTypeBuilder transformer(TypeTransformer transformer) {
        this.transformer = transformer;
        return this;
    }

    public LightTypeBuilder stringifier(Function<?, String> stringifier) {
        this.stringifier = stringifier;
        return this;
    }

    @Override
    public LightType build() {
        if (name == null) {
            throw new IllegalArgumentException("ClassPrototype name is not definied");
        }

        return new LightType(this);
    }

    private static class DefaultTypeTransformer implements TypeTransformer {

        @Override
        public @Nullable LinguisticAct transform(String sentence) {
            return null;
        }

    }

}
