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

package org.panda_lang.light.util;

import org.panda_lang.light.LightCore;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

public class ReflectionsUtils {

    public static final ConfigurationBuilder REFLECTIONS_CONFIG = new ConfigurationBuilder();

    static {
        try {
            REFLECTIONS_CONFIG.setClassLoaders(new ClassLoader[]{ LightCore.class.getClassLoader() });
            REFLECTIONS_CONFIG.addUrls(LightCore.class.getProtectionDomain().getCodeSource().getLocation().toURI().toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Disable logging
        Reflections.log = null;
    }

    public static final Reflections REFLECTIONS = new Reflections(org.panda_lang.panda.util.ReflectionsUtils.REFLECTIONS_CONFIG);

}
