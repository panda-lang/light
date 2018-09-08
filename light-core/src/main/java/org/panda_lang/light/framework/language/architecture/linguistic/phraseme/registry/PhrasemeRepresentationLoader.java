package org.panda_lang.light.framework.language.architecture.linguistic.phraseme.registry;

import org.panda_lang.light.LightException;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPattern;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.PhrasemeCallback;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;
import org.panda_lang.panda.utilities.annotations.AnnotationsScannerProcess;
import org.panda_lang.panda.utilities.commons.objects.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

public class PhrasemeRepresentationLoader {

    public Collection<Phraseme> load(AnnotationsScannerProcess process) {
        Collection<Phraseme> phrasemes = new ArrayList<>();

        Collection<Method> methods = process.createSelector()
                .selectMethodsAnnotatedWith(PhrasemeRepresentation.class);

        for (Method method : methods) {
            try {
                Phraseme phraseme = load(method);
                phrasemes.add(phraseme);
            } catch (Exception e) {
                throw new LightException(e);
            }
        }

        return phrasemes;
    }

    private Phraseme load(Method method) throws Exception {
        PhrasemeRepresentation phrasemeRepresentation = method.getAnnotation(PhrasemeRepresentation.class);
        String patternRepresentation = phrasemeRepresentation.value();

        if (StringUtils.isEmpty(patternRepresentation)) {
            throw new LightException("Pattern cannot be empty (source: " + method.getDeclaringClass() + ")");
        }

        LinguisticPattern pattern = LinguisticPattern.builder()
                .compile(patternRepresentation)
                .build();

        Object instance = method.getDeclaringClass().newInstance();

        PhrasemeCallback callback = new PhrasemeCallback() {
            @Override
            public Object call(ExecutableBranch branch, Object[] convertedParameters) {
                try {
                    return method.invoke(instance, convertedParameters);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

                return null;
            }
        };

        return new Phraseme(pattern, callback);
    }

}
