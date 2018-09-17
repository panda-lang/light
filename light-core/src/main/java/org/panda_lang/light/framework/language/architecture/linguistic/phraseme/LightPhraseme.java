package org.panda_lang.light.framework.language.architecture.linguistic.phraseme;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class LightPhraseme implements Phraseme {

    private final LinguisticPattern pattern;
    private final Collection<LinguisticAct> act;
    private int usages;

    public LightPhraseme(LinguisticPattern pattern, LinguisticAct... acts) {
        this.pattern = pattern;
        this.act = new ArrayList<>();
        this.addActs(acts);
    }

    public LightPhraseme(LinguisticPattern pattern, PhrasemeCallback callback, Type<?> returnType) {
        this(pattern, new LightPhrasemeLinguisticAct(callback, returnType));
    }

    protected void addActs(LinguisticAct... acts) {
        act.addAll(Arrays.asList(acts));
    }

    @Override
    public void increaseUsages() {
        ++usages;
    }

    @Override
    public LinguisticAct[] getActs() {
        return act.toArray(new LinguisticAct[0]);
    }

    @Override
    public LinguisticPattern getPattern() {
        return pattern;
    }

    @Override
    public String getIdentifier() {
        return "#TODO";
    }

}
