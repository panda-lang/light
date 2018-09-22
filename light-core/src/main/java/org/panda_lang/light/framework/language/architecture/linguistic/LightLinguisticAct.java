package org.panda_lang.light.framework.language.architecture.linguistic;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticExpression;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;

public class LightLinguisticAct implements LinguisticAct {

    private final String identifier;
    private final Type<?> returnType;
    private final LinguisticExpression[] acts;

    public LightLinguisticAct(String identifier, Type<?> returnType, LinguisticExpression... acts) {
        this.identifier = identifier;
        this.returnType = returnType;
        this.acts = acts;
    }

    @Override
    public boolean compare(LinguisticAct another) {
        if (another == null) {
            return false;
        }

        return identifier.equals(another.getIdentifier());
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
