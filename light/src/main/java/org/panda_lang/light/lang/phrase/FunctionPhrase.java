package org.panda_lang.light.lang.phrase;

import org.panda_lang.panda.lang.ArrayInst;

public class FunctionPhrase implements org.panda_lang.light.core.element.phrase.Phrase {

    @Override
    public void run(org.panda_lang.light.core.Ray ray) {
        final String functionName = ray.getHollows().get(0);

        if (ray.getPattern().getIndex() == 0) {
            ArrayInst arrayEssence = ray.getExpressionValue(0);
            // todo
        }

        ray.getLightScript().callFunction(functionName, ray.getRuntimeValues());
    }

}