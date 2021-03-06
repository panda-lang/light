package org.panda_lang.light.framework.language.architecture.linguistic.phraseme;

class PhrasemeLoaderUtils {

    static Object[] cast(Object[] parameters, Class<?>[] types) {
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = types[i].cast(parameters[i]);
        }

        return parameters;
    }

}
