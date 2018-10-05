package org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader;

import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticExpression;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPattern;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.LightPhraseme;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader.annotations.PhrasemeGroup;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader.annotations.PhrasemeVariant;
import org.panda_lang.panda.utilities.annotations.AnnotationsScannerProcess;
import org.panda_lang.panda.utilities.commons.ReflectionUtils;
import org.panda_lang.panda.utilities.commons.objects.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

class PhrasemeGroupLoader {

    private final PhrasemeMethodLoader methodLoader = new PhrasemeMethodLoader();

    protected Collection<Phraseme> load(Context context, AnnotationsScannerProcess process) throws Exception {
        Collection<Phraseme> phrasemes = new ArrayList<>();

        Collection<Class<?>> selected = process.createSelector()
                .selectTypesAnnotatedWith(PhrasemeGroup.class);

        for (Class<?> clazz : selected) {
            phrasemes.addAll(loadPhrasemeGroup(context, clazz));
        }

        return phrasemes;
    }

    private Collection<Phraseme> loadPhrasemeGroup(Context context, Class<?> clazz) throws Exception {
        PhrasemeGroup group = clazz.getAnnotation(PhrasemeGroup.class);

        Collection<Method> variantMethods = ReflectionUtils.getMethodsAnnotatedWith(clazz, PhrasemeVariant.class);
        Collection<Phraseme> phrasemes = new ArrayList<>(variantMethods.size());

        for (Method variantMethod : variantMethods) {
            phrasemes.add(loadPhraseme(group.value(), context, variantMethod));
        }

        return phrasemes;
    }

    private Phraseme loadPhraseme(String patternScheme, Context context, Method method) throws Exception {
        String preparedPattern = StringUtils.replaceRespectively(patternScheme, "<?>", Stream.of(method.getParameterTypes())
                .map(clazz -> "<" + clazz.getSimpleName() + ">")
                .toArray(String[]::new));

        LinguisticPattern pattern = LinguisticPattern.builder()
                .compile(preparedPattern)
                .build();

        LinguisticExpression expression = methodLoader.load(context, method);
        return new LightPhraseme(pattern, expression.getType(), expression);
    }

}
