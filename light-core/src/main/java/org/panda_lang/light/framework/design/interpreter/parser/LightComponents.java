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

package org.panda_lang.light.framework.design.interpreter.parser;

import org.panda_lang.light.framework.design.architecture.phraseme.PhrasemesGroup;
import org.panda_lang.light.framework.language.interpreter.LightInterpreter;
import org.panda_lang.panda.framework.design.interpreter.parser.component.Component;

public class LightComponents {

    public static final Component<LightInterpreter> INTERPRETER = Component.of("light-interpreter", LightInterpreter.class);

    public static final Component<PhrasemesGroup> PHRASEMES = Component.of("light-phrasemes", PhrasemesGroup.class);

}