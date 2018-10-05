package org.panda_lang.light.framework.language.architecture.linguistic.phraseme;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticExpression;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticUtils;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;
import org.panda_lang.panda.utilities.commons.arrays.ArrayUtils;

public class LightPhrasemeLinguisticExpression implements LinguisticExpression {

    private final Type<?>[] parameterTypes;
    private final PhrasemeCallback callback;
    private final Type<?> returnType;

    public LightPhrasemeLinguisticExpression(Type<?>[] parameterTypes, PhrasemeCallback callback, Type<?> returnType) {
        if (ArrayUtils.contains(parameterTypes, null)) {
            throw new IllegalArgumentException("Parameter types cannot contain null");
        }

        this.parameterTypes = parameterTypes;
        this.callback = callback;
        this.returnType = returnType;
    }

    @Override
    public Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
        return callback.call(branch, LinguisticUtils.perform(branch, parameters));
    }

    @Override
    public boolean compare(LinguisticAct another) {
        return another.equals(this);
    }

    @Override
    public Type<?>[] getParameterTypes() {
        return parameterTypes;
    }

    @Override
    public Type<?> getType() {
        return returnType;
    }

}
