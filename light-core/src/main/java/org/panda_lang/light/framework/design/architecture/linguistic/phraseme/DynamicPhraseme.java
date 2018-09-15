package org.panda_lang.light.framework.design.architecture.linguistic.phraseme;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.panda.framework.language.runtime.PandaRuntimeException;

public class DynamicPhraseme {

    private final LinguisticAct[] phrasemes;

    public DynamicPhraseme(LinguisticAct... phrasemes) {
        if (phrasemes.length == 0) {
            throw new IllegalArgumentException("Cannot create DynamicPhraseme without any associated phraseme");
        }

        this.phrasemes = phrasemes;
    }

    public @Nullable LinguisticAct select(LinguisticAct... parameters) {
        for (LinguisticAct phraseme : phrasemes) {
            LinguisticAct selected = select(phraseme, parameters);

            if (selected != null) {
                return selected;
            }
        }

        return null;
    }

    private  @Nullable LinguisticAct select(LinguisticAct act, LinguisticAct... parameters) {
        Type<?>[] requiredTypes = act.getParameterTypes();

        if (requiredTypes.length != parameters.length) {
            throw new PandaRuntimeException("Mismatched phrasemes");
        }

        for (int index = 0; index < parameters.length; index++) {
            Type<?> requiredType = requiredTypes[index];
            Type<?> parameterType = parameters[index].getType();

            if (!requiredType.isAssignableFrom(parameterType)) {
                return null;
            }
        }

        return act;
    }

}
