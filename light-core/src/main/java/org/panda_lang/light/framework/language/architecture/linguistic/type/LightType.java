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

import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.architecture.linguistic.type.TypeSerializer;
import org.panda_lang.light.framework.design.architecture.linguistic.type.TypeTransformer;
import org.panda_lang.panda.framework.language.architecture.prototype.PandaClassPrototype;

import java.util.List;
import java.util.function.Function;

public class LightType<T> extends PandaClassPrototype implements Type<T> {

    private final List<String> plurals;
    private final TypeSerializer<T> serializer;
    private final List<TypeTransformer<T>> transformer;
    private final Function<T, String> stringifier;

    public LightType(LightTypeBuilder<T> builder) {
        super(builder);

        this.plurals = builder.plurals;
        this.serializer = builder.serializer;
        this.transformer = builder.transformers;
        this.stringifier = builder.stringifier;
    }

    @Override
    public TypeSerializer<T> getSerializer() {
        return serializer;
    }

    @Override
    public List<? extends TypeTransformer<T>> getTypeTransformer() {
        return transformer;
    }

    @Override
    public Function<T, String> getStringifier() {
        return stringifier;
    }

    @Override
    public List<? extends String> getPlurals() {
        return plurals;
    }

    public static <T> LightTypeBuilder<T> builder() {
        return new LightTypeBuilder<>();
    }

}
