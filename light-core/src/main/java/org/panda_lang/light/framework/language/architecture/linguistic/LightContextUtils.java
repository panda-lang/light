package org.panda_lang.light.framework.language.architecture.linguistic;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticUtils;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.interpreter.pattern.linguistic.LinguisticCandidate;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;

class LightContextUtils {

    private LightContextUtils() { }

    protected static @Nullable LinguisticAct assignParameters(LinguisticCandidate<LinguisticAct> candidate) {
        LinguisticAct act = candidate.getMatchedElement();

        if (!candidate.isMatched() || act == null) {
            return null;
        }

        if (candidate.getLinguisticResult() != null) {
            LexicalExtractorResult<LinguisticAct> lexicalResult = candidate.getLinguisticResult().getLexicalResult();
            LinguisticAct[] matchedParameters = new LinguisticAct[lexicalResult.getProcessedValues().size()];

            for (int i = 0; i < matchedParameters.length; i++) {
                matchedParameters[i] = lexicalResult.getProcessedValues().get(i).getValue();
            }

            return new LinguisticAct() {
                @Override
                public Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
                    return act.perform(branch, matchedParameters);
                }

                @Override
                public Type<?>[] getParameterTypes() {
                    return LinguisticUtils.TYPELESS;
                }

                @Override
                public Type<?> getType() {
                    return act.getType();
                }
            };
        }

        return act;
    }

}
