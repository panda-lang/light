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

package org.panda_lang.light;

import org.panda_lang.light.design.architecture.LightApplication;
import org.panda_lang.light.design.architecture.LightEnvironment;
import org.panda_lang.light.design.interpreter.LightInterpreter;
import org.panda_lang.panda.framework.PandaFrameworkException;
import org.panda_lang.panda.framework.design.interpreter.source.SourceProvider;
import org.panda_lang.panda.framework.design.interpreter.source.SourceSet;
import org.panda_lang.panda.framework.language.interpreter.source.providers.FileSourceProvider;
import org.panda_lang.panda.utilities.commons.io.FileUtils;

public class LightLoader {

    private final LightCore light;

    public LightLoader(LightCore light) {
        this.light = light;
    }

    public LightApplication loadFiles(String... paths) {
        return load(new FileSourceProvider(FileUtils.toFiles(paths)));
    }

    public LightApplication load(SourceProvider provider) {
        SourceSet sourceSet = provider.toSourceSet();

        if (sourceSet.isEmpty()) {
            throw new PandaFrameworkException("Sources are not provided");
        }

        LightEnvironment environment = new LightEnvironment(light);
        LightInterpreter interpreter = environment.getInterpreter();
        LightApplication application = interpreter.interpret(sourceSet);

        return application;
    }

}
