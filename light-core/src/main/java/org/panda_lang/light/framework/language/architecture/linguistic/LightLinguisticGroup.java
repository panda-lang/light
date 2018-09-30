package org.panda_lang.light.framework.language.architecture.linguistic;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticExpression;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticGroup;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

public class LightLinguisticGroup implements LinguisticGroup {

    private final String identifier;
    private final Type<?> returnType;
    private final LinguisticExpression[] acts;

    public LightLinguisticGroup(String identifier, Type<?> returnType, LinguisticExpression... acts) {
        this.identifier = identifier;
        this.returnType = returnType;
        this.acts = acts;
    }

    @Override
    public boolean compare(LinguisticAct another) {
        return another instanceof LightLinguisticGroup && identifier.equals(((LightLinguisticGroup) another).getIdentifier());
    }

    @Override
    public @Nullable Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
        return null;
    }

    @Override
    public LinguisticExpression[] getPerformers() {
        return acts;
    }

    @Override
    public Type<?> getType() {
         return returnType;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

}
