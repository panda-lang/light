package org.panda_lang.light.framework.language.architecture.linguistic;

import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticDescriptor;

public class LightLinguisticDescriptor implements LinguisticDescriptor {

    private final String identifier;
    private final LinguisticAct[] acts;

    public LightLinguisticDescriptor(String identifier, LinguisticAct... acts) {
        this.identifier = identifier;
        this.acts = acts;
    }

    @Override
    public LinguisticAct[] getActs() {
        return acts;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

}
