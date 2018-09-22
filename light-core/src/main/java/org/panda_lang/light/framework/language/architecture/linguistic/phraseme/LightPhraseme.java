package org.panda_lang.light.framework.language.architecture.linguistic.phraseme;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticExpression;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class LightPhraseme implements Phraseme {

    private final LinguisticPattern pattern;
    private final Collection<LinguisticExpression> act;
    private final Type<?> returnType;
    private int usages;

    public LightPhraseme(LinguisticPattern pattern, Type<?> type, LinguisticExpression... acts) {
        this.pattern = pattern;
        this.returnType = type;
        this.act = new ArrayList<>();
        this.addActs(acts);
    }

    public LightPhraseme(LinguisticPattern pattern, PhrasemeCallback callback, Type<?> returnType) {
        this(pattern, returnType, new LightPhrasemeLinguisticExpression(callback, returnType));
    }

    @Override
    public boolean compare(LinguisticAct another) {
        return this.equals(another);
    }

    @Override
    public void increaseUsages() {
        ++usages;
    }

    protected void addActs(LinguisticExpression... acts) {
        act.addAll(Arrays.asList(acts));
    }

    @Override
    public LinguisticExpression[] getPerformers() {
        return act.toArray(new LinguisticExpression[0]);
    }

    @Override
    public Type<?> getType() {
        return returnType;
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
