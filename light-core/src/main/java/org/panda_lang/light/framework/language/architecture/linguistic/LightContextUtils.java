package org.panda_lang.light.framework.language.architecture.linguistic;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticGroup;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticCandidate;

class LightContextUtils {

    private LightContextUtils() { }

    protected static @Nullable LinguisticGroup assignParameters(LinguisticCandidate<LinguisticGroup> candidate) {
        LinguisticGroup descriptor = candidate.getMatchedElement();

        if (!candidate.isMatched() || descriptor == null) {
            return null;
        }

        if (candidate.getLinguisticResult() != null) {
            return new LightLinguisticGroup("#TODO", descriptor.getType(), new DynamicLinguisticAct(descriptor.getType(), descriptor));
        }

        return descriptor;
    }

}
