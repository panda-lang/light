package org.panda_lang.light.framework.design.architecture.linguistic;

import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

public interface LinguisticAct {

    Object perform(ExecutableBranch branch, LinguisticAct... parameters);

    boolean compare(LinguisticAct another);

    Type<?> getType();

}
