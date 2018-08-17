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

package org.panda_lang.light.framework.design.architecture.phraseme;

import org.panda_lang.light.framework.design.architecture.dynamic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.type.Type;

public class Phraseme {

    private final LinguisticAct act;
    private final Type returnType;

    public Phraseme(PhrasemeCallback act) {
        this(act.getType(), act);
    }

    public Phraseme(Type type, LinguisticAct act) {
        this.act = act;
        this.returnType = type;
    }

    public LinguisticAct getAct() {
        return act;
    }

    public Type getReturnType() {
        return returnType;
    }

}
