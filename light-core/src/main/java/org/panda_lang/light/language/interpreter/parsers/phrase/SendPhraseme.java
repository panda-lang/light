/*
 * Copyright (c) 2015-2018 Dzikoysk
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

package org.panda_lang.light.language.interpreter.parsers.phrase;

import java.io.*;

public class SendPhraseme {

    @PhrasemeRepresentation(phrase = "send <message> to (1: <player>|2: <file>)")
    public void send(String message, @Parameter(id = 1) Object player, @Parameter(id = 2) String console) {

    }

    @PhrasemeRepresentation(phrase = "send <message> to <file>")
    public void send(String message, File file) {

    }

}
