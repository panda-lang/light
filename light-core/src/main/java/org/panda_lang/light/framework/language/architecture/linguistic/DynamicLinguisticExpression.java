package org.panda_lang.light.framework.language.architecture.linguistic;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.LightException;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticExpression;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;
import org.panda_lang.panda.framework.language.runtime.PandaRuntimeException;

import java.util.Collection;

public class DynamicLinguisticExpression implements LinguisticExpression {

    private final Type<?> returnType;
    private final LinguisticAct[] candidates;

    public DynamicLinguisticExpression(Type<?> returnType, LinguisticAct... candidates) {
        if (candidates.length == 0) {
            throw new IllegalArgumentException("Cannot create DynamicPhraseme without any associated phraseme");
        }

        this.returnType = returnType;
        this.candidates = candidates;
    }

    public DynamicLinguisticExpression(Type<?> returnType, Collection<LinguisticAct> candidates) {
        this(returnType, candidates.toArray(new LinguisticAct[0]));
    }

    @Override
    public Object perform(ExecutableBranch branch, LinguisticExpression... parameters) {
        for (LinguisticAct candidate : candidates) {
            LinguisticExpression selected = select(candidate, parameters);

            if (selected == null) {
                continue;
            }

            return selected.perform(branch, parameters);
        }

        throw new LightException("Cannot find matching candidate");
    }

    private  @Nullable LinguisticExpression select(LinguisticAct candidate, LinguisticExpression... parameters) {
        for (LinguisticExpression act : candidate.getPerformers()) {
            LinguisticExpression selected = select(act, parameters);

            if (selected != null) {
                return selected;
            }
        }

        return null;
    }

    private @Nullable LinguisticExpression select(LinguisticExpression act, LinguisticExpression... parameters) {
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

    public LinguisticAct toAct() {
        return new LightLinguisticAct("#TODO", returnType, this);
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
