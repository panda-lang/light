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

package org.panda_lang.light.framework.language.architecture.linguistic.type;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.type.TypeSerializer;
import org.panda_lang.light.framework.design.architecture.linguistic.type.TypeTransformer;
import org.panda_lang.panda.framework.design.architecture.prototype.PandaClassPrototypeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LightTypeBuilder<T> extends PandaClassPrototypeBuilder<LightTypeBuilder<T>, LightType> {

    protected List<TypeTransformer<T>> transformers;
    protected TypeSerializer<T> serializer;
    protected Function<T, String> stringifier;

    protected LightTypeBuilder() {
        this.transformers = new ArrayList<>();
        transformers.add(new DefaultTypeTransformer<>());
    }

    public LightTypeBuilder<T> serializer(TypeSerializer<T> serializer) {
        this.serializer = serializer;
        return this;
    }

    public LightTypeBuilder<T> transformer(TypeTransformer<T> transformer) {
        this.transformers.add(transformer);
        return this;
    }

    public LightTypeBuilder<T> stringifier(Function<T, String> stringifier) {
        this.stringifier = stringifier;
        return this;
    }

    @Override
    public LightType<T> build() {
        if (name == null) {
            throw new IllegalArgumentException("ClassPrototype name is not definied");
        }

        return new LightType<>(this);
    }

    private static class DefaultTypeTransformer<T> implements TypeTransformer<T> {

        @Override
        public @Nullable T transform(String sentence) {
            return null;
        }

    }

}
