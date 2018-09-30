package org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader;

import org.panda_lang.light.LightException;
import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPattern;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.LightPhraseme;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.PhrasemeCallback;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader.annotations.PhrasemeRepresentation;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;
import org.panda_lang.panda.utilities.annotations.AnnotationsScannerProcess;
import org.panda_lang.panda.utilities.commons.objects.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

class PhrasemeRepresentationLoader {

    protected Collection<Phraseme> load(Context context, AnnotationsScannerProcess process) throws Exception {
        Collection<Phraseme> phrasemes = new ArrayList<>();

        Collection<Method> methods = process.createSelector()
                .selectMethodsAnnotatedWith(PhrasemeRepresentation.class);

        for (Method method : methods) {
            Phraseme phraseme = load(context, method);
            phrasemes.add(phraseme);
        }

        return phrasemes;
    }

    private Phraseme load(Context context, Method method) throws Exception {
        PhrasemeRepresentation phrasemeRepresentation = method.getAnnotation(PhrasemeRepresentation.class);
        String patternRepresentation = phrasemeRepresentation.value();

        if (StringUtils.isEmpty(patternRepresentation)) {
            throw new LightException("Pattern cannot be empty (source: " + method.getDeclaringClass() + ")");
        }

        LinguisticPattern pattern = LinguisticPattern.builder()
                .compile(patternRepresentation)
                .build();

        Object instance = method.getDeclaringClass().newInstance();
        Type<?> returnType = context.getType(method.getReturnType());

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

        Type<?>[] parameterTypes = new Type[method.getParameterCount()];

        for (int i = 0; i < parameterTypes.length; i++) {
            parameterTypes[i] = context.getType(method.getParameterTypes()[i]);
        }

        return new LightPhraseme(pattern, parameterTypes, callback, returnType);
    }

}
