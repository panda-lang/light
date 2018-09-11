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

import org.panda_lang.light.LightConstants;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.registry.Id;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.registry.PhrasemeRepresentation;

public class ConsolePhraseme {

    @PhrasemeRepresentation("send message:<string> to [the] console")
    public void sendMessageToConsole(@Id("message") String message) {
        System.out.println(message);
    }

    @PhrasemeRepresentation("send message:<boolean> to [the] console")
    public void sendMessageToConsole(@Id("message") boolean message) {
        System.out.println("boolean::" + message);
    }

    @PhrasemeRepresentation("light version")
    public String lightVersion() {
        return LightConstants.VERSION;
    }

    @PhrasemeRepresentation("string of <object>")
    public String stringOf(Object obj) {
        return obj.toString();
    }

    @PhrasemeRepresentation("joined <string> and <string>")
    public String join(String a, String b) {
        return a + b;
    }

}
