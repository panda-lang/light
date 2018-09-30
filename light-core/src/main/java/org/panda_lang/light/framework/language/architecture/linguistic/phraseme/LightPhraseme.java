package org.panda_lang.light.framework.language.architecture.linguistic.phraseme;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticExpression;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class LightPhraseme implements Phraseme {

    private final LinguisticPattern pattern;
    private final Type<?> returnType;
    private final Collection<LinguisticExpression> expressions;
    private int usages;

    public LightPhraseme(LinguisticPattern pattern, Type<?> returnType, LinguisticExpression... acts) {
        this.pattern = pattern;
        this.returnType = returnType;
        this.expressions = new ArrayList<>(1);
        this.addActs(acts);
    }

    public LightPhraseme(LinguisticPattern pattern, Type<?>[] parameterTypes, PhrasemeCallback callback, Type<?> returnType) {
        this(pattern, returnType, new LightPhrasemeLinguisticExpression(parameterTypes, callback, returnType));
    }

    @Override
    public void increaseUsages() {
        ++usages;
    }

    protected void addActs(LinguisticExpression... acts) {
        expressions.addAll(Arrays.asList(acts));
    }

    @Override
    public Type<?> getReturnType() {
        return returnType;
    }

    @Override
    public Collection<LinguisticExpression> getExpressions() {
        return expressions;
    }

    @Override
    public LinguisticPattern getPattern() {
        return pattern;
    }

}
