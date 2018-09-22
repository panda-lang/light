package org.panda_lang.light.framework.language.architecture.linguistic;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.LightException;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticGroup;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;
import org.panda_lang.panda.framework.language.runtime.PandaRuntimeException;

public class DynamicLinguisticAct implements LinguisticAct {

    private final Type<?> returnType;
    private final LinguisticGroup[] candidates;

    public DynamicLinguisticAct(Type<?> returnType, LinguisticGroup... candidates) {
        if (candidates.length == 0) {
            throw new IllegalArgumentException("Cannot create DynamicPhraseme without any associated phraseme");
        }

        this.returnType = returnType;
        this.candidates = candidates;
    }

    @Override
    public Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
        for (LinguisticGroup candidate : candidates) {
            LinguisticAct selected = select(candidate, parameters);

            if (selected == null) {
                continue;
            }

            return selected.perform(branch, parameters);
        }

        throw new LightException("Cannot find matching candidate");
    }

    private  @Nullable LinguisticAct select(LinguisticGroup candidate, LinguisticAct... parameters) {
        for (LinguisticAct act : candidate.getPerformers()) {
            LinguisticAct selected = select(act, parameters);

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

    @Override
    public Type<?>[] getParameterTypes() {
        return new Type[0];
    }

    @Override
    public Type<?> getType() {
        return returnType;
    }

}
