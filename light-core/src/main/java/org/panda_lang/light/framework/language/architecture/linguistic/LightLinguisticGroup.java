package org.panda_lang.light.framework.language.architecture.linguistic;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.LightException;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticExpression;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticGroup;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;
import org.panda_lang.panda.framework.language.runtime.PandaRuntimeException;

import java.util.Arrays;
import java.util.Collection;

public class LightLinguisticGroup implements LinguisticGroup {

    protected final Type<?> returnType;
    protected final LinguisticAct[] candidates;

    public LightLinguisticGroup(Type<?> returnType, LinguisticAct... candidates) {
        if (candidates.length == 0) {
            throw new IllegalArgumentException("Cannot create DynamicPhraseme without any associated acts");
        }

        this.returnType = returnType;
        this.candidates = candidates;
    }

    public LightLinguisticGroup(Type<?> returnType, Collection<? extends LinguisticAct> candidates) {
        this(returnType, candidates.toArray(new LinguisticAct[0]));
    }

    @Override
    public Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
        LinguisticAct selected = select(parameters);

        if (selected == null) {
            throw new LightException("Cannot find matching candidate");
        }

        return selected.perform(branch, parameters);
    }

    @Override
    public LinguisticAct select(LinguisticAct... parameters) {
        return select(candidates, parameters);
    }

    private @Nullable LinguisticAct select(LinguisticAct[] acts, LinguisticAct... parameters) {
        for (LinguisticAct act : acts) {
            LinguisticAct selected = select(act, parameters);

            if (selected != null) {
                return selected;
            }
        }

        return null;
    }

    private @Nullable LinguisticAct select(LinguisticAct act, LinguisticAct... parameters) {
        if (act instanceof LinguisticExpression) {
            return selectExpression((LinguisticExpression) act, parameters);
        }

        if (act instanceof LinguisticGroup) {
            return ((LinguisticGroup) act).select(parameters);
        }

        return parameters.length == 0 ? act : null;
    }

    private @Nullable LinguisticAct selectExpression(LinguisticExpression expression, LinguisticAct... parameters) {
        Type<?>[] requiredTypes = expression.getParameterTypes();

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

        return expression;
    }

    @Override
    public boolean compare(LinguisticAct another) {
        return another instanceof LightLinguisticGroup && Arrays.equals(candidates, ((LightLinguisticGroup) another).candidates);
    }

    @Override
    public Type<?> getType() {
        return returnType;
    }

}
