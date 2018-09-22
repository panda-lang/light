package org.panda_lang.light.framework.language.architecture.linguistic;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticCandidate;

import java.util.Collection;

class LightContextUtils {

    private LightContextUtils() { }

    protected static @Nullable LinguisticAct createGroup(Collection<LinguisticCandidate<LinguisticAct>> candidates) {
        if (candidates.size() == 0) {
            return null;
        }

        LinguisticAct first = candidates.iterator().next().getMatchedElement();

        return candidates.size() == 1 ? first : new DynamicLinguisticExpression(first.getType(), candidates.stream()
                .map(LinguisticCandidate::getMatchedElement)
                .toArray(LinguisticAct[]::new))
                .toAct();
    }

}
