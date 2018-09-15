package org.panda_lang.light.framework.design.architecture.linguistic.phraseme;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

public class DynamicPhraseme implements LinguisticAct {

    private final String returnType;
    private final Phraseme[] phrasemes;

    public DynamicPhraseme(String returnType, Phraseme... phrasemes) {
        this.returnType = returnType;
        this.phrasemes = phrasemes;
    }

    @Override
    public Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
        return null;
    }

    @Override
    public String getType() {
        return returnType;
    }

}
