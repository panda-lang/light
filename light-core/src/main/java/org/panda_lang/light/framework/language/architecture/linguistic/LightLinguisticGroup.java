package org.panda_lang.light.framework.language.architecture.linguistic;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticGroup;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;

public class LightLinguisticGroup implements LinguisticGroup {

    private final String identifier;
    private final Type<?> returnType;
    private final LinguisticAct[] acts;

    public LightLinguisticGroup(String identifier, Type<?> returnType, LinguisticAct... acts) {
        this.identifier = identifier;
        this.returnType = returnType;
        this.acts = acts;
    }

    @Override
    public boolean compare(LinguisticGroup another) {
        return another.getIdentifier().equals(identifier);
    }

    @Override
    public LinguisticAct[] getPerformers() {
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
