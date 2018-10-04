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

package org.panda_lang.light.framework.design.architecture.value;

import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;

import java.util.Objects;

public class LightTypeValue implements TypeValue {

    private final Type type;
    private final Object value;

    public LightTypeValue(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getValue() {
        return (T) value;
    }

    @Override
    public Object getObject() {
        return value;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LightTypeValue that = (LightTypeValue) o;

        return type.equals(that.type) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

}
