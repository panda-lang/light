package org.panda_lang.light.framework.language.architecture.linguistic;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticCandidate;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

import java.util.Collection;
import java.util.stream.Collectors;

class LightContextUtils {

    private LightContextUtils() { }

    protected static @Nullable LinguisticAct prepare(Collection<LinguisticCandidate> candidates) {
        if (candidates.size() == 0) {
            return null;
        }

        LinguisticCandidate first = candidates.iterator().next();

        if (candidates.size() == 1) {
            return createElement(first);
        }

        Collection<LinguisticAct> elements = candidates.stream()
                .map(LightContextUtils::createElement)
                .collect(Collectors.toList());

        return new LightLinguisticGroup(first.getMatchedElement().getType(), elements);
    }

    @NotNull
    protected static LinguisticAct createElement(LinguisticCandidate candidate) {
        LinguisticAct matched = candidate.getMatchedElement();
        LinguisticAct[] matchedParameters = candidate.getMatchedParameters();

        return new LinguisticAct() {
            @Override
            public Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
                return matched.perform(branch, matchedParameters);
            }

            @Override
            public boolean compare(LinguisticAct another) {
                return another.equals(this);
            }

            @Override
            public Type<?> getType() {
                return matched.getType();
            }
        };
    }

}
