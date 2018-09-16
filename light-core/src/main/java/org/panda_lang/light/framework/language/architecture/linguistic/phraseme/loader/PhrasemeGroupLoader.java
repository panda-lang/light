package org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader;

import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader.annotations.PhrasemeGroup;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader.annotations.PhrasemeVariant;
import org.panda_lang.panda.utilities.annotations.AnnotationsScannerProcess;
import org.panda_lang.panda.utilities.commons.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

class PhrasemeGroupLoader {

    protected Collection<Phraseme> load(Context context, AnnotationsScannerProcess process) throws Exception {
        Collection<Phraseme> phrasemes = new ArrayList<>();

        Collection<Class<?>> selected = process.createSelector()
                .selectTypesAnnotatedWith(PhrasemeGroup.class);

        for (Class<?> clazz : selected) {
            Phraseme phraseme = loadPhrasemeGroup(context, clazz);
            //phrasemes.add(phraseme);
        }

        return phrasemes;
    }

    private Phraseme loadPhrasemeGroup(Context context, Class<?> clazz) throws Exception {
        String phrasemeGroup = clazz.getAnnotation(PhrasemeGroup.class).value();

        Collection<Method> variantMethods = ReflectionUtils.getMethodsAnnotatedWith(clazz, PhrasemeVariant.class);

        return null;
    }

}
