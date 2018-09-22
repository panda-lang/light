package org.panda_lang.light.framework.design.architecture.linguistic;

import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;

public interface LinguisticGroup {

    boolean compare(LinguisticGroup another);

    LinguisticAct[] getPerformers();

    Type<?> getType();

    String getIdentifier();

}
