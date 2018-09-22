package org.panda_lang.light.framework.design.architecture.linguistic;

import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;

public interface LinguisticAct {

    boolean compare(LinguisticAct another);

    LinguisticExpression[] getPerformers();

    Type<?> getType();

    String getIdentifier();

}
