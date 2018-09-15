package org.panda_lang.light.framework.language.architecture.linguistic.phraseme;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.language.architecture.linguistic.LinguisticUtils;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

public class LightPhrasemeLinguisticAct implements LinguisticAct {

    private final PhrasemeCallback callback;
    private final String returnType;

    public LightPhrasemeLinguisticAct(PhrasemeCallback callback, String returnType) {
        this.callback = callback;
        this.returnType = returnType;
    }

    @Override
    public Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
        return callback.call(branch, LinguisticUtils.perform(branch, parameters));
    }

    @Override
    public String getType() {
        return returnType;
    }

}
