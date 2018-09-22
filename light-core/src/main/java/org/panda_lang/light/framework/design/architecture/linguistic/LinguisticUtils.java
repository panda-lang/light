package org.panda_lang.light.framework.design.architecture.linguistic;

import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

public class LinguisticUtils {

    public static final Type<?>[] TYPELESS = new Type[0];

    public static Object[] perform(ExecutableBranch branch, LinguisticExpression[] acts) {
        Object[] convertedParameters = new Object[acts.length];

        for (int i = 0; i < acts.length; i++) {
            convertedParameters[i] = acts[i].perform(branch);
        }

        return convertedParameters;
    }

}
