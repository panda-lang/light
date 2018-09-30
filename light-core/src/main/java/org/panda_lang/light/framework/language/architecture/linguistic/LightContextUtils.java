package org.panda_lang.light.framework.language.architecture.linguistic;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticCandidate;

import java.util.Collection;
import java.util.stream.Collectors;

class LightContextUtils {

    private LightContextUtils() { }

    protected static @Nullable LinguisticAct createGroup(Collection<LinguisticCandidate> candidates) {
        if (candidates.size() == 0) {
            return null;
        }

        LinguisticAct first = candidates.iterator().next().getMatchedElement();

        if (candidates.size() == 1) {
            return first;
        }

        Collection<LinguisticAct> elements = candidates.stream()
                .map(LinguisticCandidate::getMatchedElement)
                .collect(Collectors.toList());

        return new DynamicLinguisticExpression(first.getType(), elements);
    }

}
