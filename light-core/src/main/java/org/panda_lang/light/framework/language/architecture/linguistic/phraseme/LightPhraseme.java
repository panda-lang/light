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
        this.addAssociatedExpressions(acts);
    }

    @Override
    public void increaseUsages() {
        ++usages;
    }

    public void merge(Phraseme phraseme) {
        if (!returnType.isAssignableFrom(phraseme.getReturnType())) {
            throw new IllegalArgumentException("Cannot merge a phraseme of another type (" + returnType.getClassName() + " != " + phraseme.getReturnType().getClassName() + ")");
        }

        expressions.addAll(phraseme.getExpressions());
    }

    public void addAssociatedExpressions(LinguisticExpression... acts) {
        expressions.addAll(Arrays.asList(acts));
    }

    @Override
    public Collection<LinguisticExpression> getExpressions() {
        return expressions;
    }

    @Override
    public Type<?> getReturnType() {
        return returnType;
    }

    @Override
    public LinguisticPattern getPattern() {
        return pattern;
    }

}
