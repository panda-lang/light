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

package org.panda_lang.light.framework.language.architecture;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.framework.language.interpreter.parser.scope.main.MainScope;
import org.panda_lang.panda.framework.design.architecture.Application;
import org.panda_lang.panda.framework.design.architecture.Script;
import org.panda_lang.panda.framework.design.runtime.ExecutableProcess;
import org.panda_lang.panda.framework.language.runtime.PandaExecutableProcess;
import org.panda_lang.panda.framework.language.runtime.PandaRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class LightApplication implements Application {

    private final List<Script> scripts;

    public LightApplication() {
        this.scripts = new ArrayList<>();
    }

    @Override
    public void launch() {
        LightCore.getLogger().info("Launching Light application");

        for (Script script : scripts) {
            List<MainScope> mainScopes = script.select(MainScope.class);

            if (mainScopes.size() == 0) {
                throw new PandaRuntimeException("Main not found");
            }

            if (mainScopes.size() > 1) {
                throw new PandaRuntimeException("Duplicated main section");
            }

            ExecutableProcess process = new PandaExecutableProcess(this, mainScopes.get(0));
            process.execute();
        }

        LightCore.getLogger().info("Process finished with exit code 0");
    }

    public void addScript(Script script) {
        this.scripts.add(script);
    }

    @Override
    public void setApplicationArguments(String... arguments) {

    }

    @Override
    public List<Script> getScripts() {
        return scripts;
    }

    @Override
    public String getWorkingDirectory() {
        throw new RuntimeException("Not implemented");
    }

}
