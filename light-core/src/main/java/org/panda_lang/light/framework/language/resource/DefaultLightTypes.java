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

package org.panda_lang.light.framework.language.resource;

import org.panda_lang.light.framework.language.architecture.linguistic.type.LightType;
import org.panda_lang.light.framework.language.architecture.linguistic.type.Types;
import org.panda_lang.light.framework.language.architecture.linguistic.type.resolvers.TransformerTypeResolver;

public class DefaultLightTypes {

    public Types generate() {
        Types types = new Types();
        types.registerResolver(new TransformerTypeResolver());

        types.registerElement(LightType.builder()
                .name("object")
                .plural("objects")
                .build());

        types.registerElement(LightType.<Void> builder()
                .name("void")
                .associated(Void.class)
                .build());

        types.registerElement(LightType.<Boolean> builder()
                .name("boolean")
                .plural("booleans")
                .associated(boolean.class)
                .transformer(sentence -> (sentence.equals("true") || sentence.equals("false")) ? Boolean.parseBoolean(sentence) : null)
                .build());

        types.registerElement(LightType.<String> builder()
                .name("string")
                .plural("strings")
                .associated(String.class)
                .transformer(sentence -> (sentence.startsWith("\"") && sentence.endsWith("\"")) ? sentence.substring(1, sentence.length() - 1) : null)
                .build());

        return types;
    }

}
