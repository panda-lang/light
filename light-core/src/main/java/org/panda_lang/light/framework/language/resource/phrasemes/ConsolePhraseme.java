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

package org.panda_lang.light.framework.language.resource.phrasemes;

import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader.annotations.Id;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader.annotations.PhrasemeGroup;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader.annotations.PhrasemeVariant;

@PhrasemeGroup("send message:<?> to [the] console")
public class ConsolePhraseme {

    @PhrasemeVariant
    public void sendMessageToConsole(@Id("message") String message) {
        System.out.println(message);
    }

    @PhrasemeVariant
    public void sendMessageToConsole(boolean message) {
        System.out.println("boolean::" + message);
    }

}
