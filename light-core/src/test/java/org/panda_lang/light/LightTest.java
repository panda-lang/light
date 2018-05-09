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

import org.junit.jupiter.api.Test;
import org.panda_lang.light.design.architecture.LightApplication;

public class LightTest {

    @Test
    public void testLight() {
        LightCore core = new LightCore();

        LightLoader loader = core.getLoader();
        LightApplication application = loader.loadFiles("../examples/current_test.light");

        if (application == null) {
            LightCore.getLogger().warn("Cannot launch this application");
            return;
        }

        application.launch();
    }

}
