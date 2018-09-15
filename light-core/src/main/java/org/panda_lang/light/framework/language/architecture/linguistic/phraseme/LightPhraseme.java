package org.panda_lang.light.framework.language.architecture.linguistic.phraseme;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPattern;

public class LightPhraseme implements Phraseme {

    private final LinguisticPattern pattern;
    private final LinguisticAct act;
    private int usages;

    public LightPhraseme(LinguisticPattern pattern, LinguisticAct act) {
        this.pattern = pattern;
        this.act = act;
    }

    public LightPhraseme(LinguisticPattern pattern, PhrasemeCallback callback, Type<?> returnType) {
        this.pattern = pattern;
        this.act = new LightPhrasemeLinguisticAct(callback, returnType);
    }

    @Override
    public void increaseUsages() {
        ++usages;
    }

    @Override
    public LinguisticAct getAct() {
        return act;
    }

    @Override
    public LinguisticPattern getPattern() {
        return pattern;
    }

}
