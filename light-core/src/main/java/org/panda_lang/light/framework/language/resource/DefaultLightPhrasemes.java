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

import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.Phrasemes;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader.PhrasemesLoader;
import org.panda_lang.panda.utilities.annotations.AnnotationsScannerProcess;

import java.util.Collection;

public class DefaultLightPhrasemes {

    public Phrasemes generate(Context context, AnnotationsScannerProcess process) {
        Phrasemes defaultPhrasemes = new Phrasemes();

        PhrasemesLoader loader = new PhrasemesLoader();
        Collection<Phraseme> phrasemes = loader.load(context, process);

        for (Phraseme phraseme : phrasemes) {
            defaultPhrasemes.registerElement(phraseme);
        }

        return defaultPhrasemes;
    }

}
