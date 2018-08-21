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

package org.panda_lang.light.framework.language.runtime;

import org.panda_lang.light.framework.design.architecture.linguistic.type.LightType;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Types;

public class DefaultLightTypes {

    public Types generate() {
        Type<String> stringType = LightType.<String> builder()
                .name("string")
                .associated(String.class)
                .transformer(sentence -> (sentence.startsWith("\"") && sentence.endsWith("\"")) ? sentence.substring(1, sentence.length() - 1) : null)
                .build();

        Types types = new Types();
        types.registerElement(stringType);

        return types;
    }

}
