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

package org.panda_lang.light.framework.design.architecture;

import org.junit.jupiter.api.Test;
import org.panda_lang.light.framework.design.architecture.dynamic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.type.LightType;
import org.panda_lang.light.framework.design.architecture.type.Type;
import org.panda_lang.light.framework.design.architecture.type.TypeSerializer;
import org.panda_lang.light.framework.design.architecture.value.TypeValue;
import org.panda_lang.panda.language.runtime.ExecutableBranch;

import java.util.function.Function;

public class TypeTest {

    @Test
    void testType() {
        Type type = LightType.builder()
                .name("string")
                .associated(String.class)
                .aliases("String")
                .serializer(new TypeSerializer<String>() {
                    @Override
                    public String serialize(String data) {
                        return data.substring(1, data.length() - 1);
                    }

                    @Override
                    public String deserialize(String object) {
                        return '"' + object + '"';
                    }
                })
                .stringifier(new Function<String, String>() {
                    @Override
                    public String apply(String typeValue) {
                        return typeValue;
                    }
                })
                .transformer(sentence -> {
                    if (sentence.startsWith("\"") && sentence.endsWith("\"")) {
                        return new LinguisticAct() {
                            @Override
                            public TypeValue perform(ExecutableBranch branch) {
                                return null;
                            }

                            @Override
                            public Type getType() {
                                return null;
                            }
                        };
                    }

                    return null;
                })
                .build();
    }

}
