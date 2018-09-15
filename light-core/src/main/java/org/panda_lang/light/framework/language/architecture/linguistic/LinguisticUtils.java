package org.panda_lang.light.framework.language.architecture.linguistic;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

public class LinguisticUtils {

    public static Object[] perform(ExecutableBranch branch, LinguisticAct[] acts) {
        Object[] convertedParameters = new Object[acts.length];

        for (int i = 0; i < acts.length; i++) {
            convertedParameters[i] = acts[i].perform(branch);
        }

        return convertedParameters;
    }

}
