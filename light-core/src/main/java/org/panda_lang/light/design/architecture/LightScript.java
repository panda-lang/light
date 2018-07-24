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

package org.panda_lang.light.design.architecture;

import org.panda_lang.panda.framework.design.architecture.Script;
import org.panda_lang.panda.framework.design.architecture.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class LightScript implements Script {

    private final String scriptName;
    private final List<Statement> statements;

    public LightScript(String scriptName) {
        this.scriptName = scriptName;
        this.statements = new ArrayList<>();
    }

    @Override
    public <T extends Statement> List<T> select(Class<? extends T> statementClass) {
        throw new RuntimeException("Not implemented");
    }

    public void addStatement(Statement statement) {
        this.statements.add(statement);
    }

    @Override
    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public String getScriptName() {
        return scriptName;
    }

}
