package org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader;

import org.panda_lang.light.LightException;
import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticExpression;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.LightPhrasemeLinguisticExpression;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.PhrasemeCallback;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class PhrasemeMethodLoader {

    protected LinguisticExpression load(Context context, Method method) throws Exception {
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
            Class<?> typeClass = method.getParameterTypes()[i];
            Type<?> type = context.getType(typeClass);

            if (type == null) {
                throw new LightException("Cannot recognize type " + typeClass);
            }

            parameterTypes[i] = type;
        }

        return new LightPhrasemeLinguisticExpression(parameterTypes, callback, returnType);
    }

}
