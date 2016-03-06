package org.panda_lang.light.lang.phrase;

import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.element.phrase.Phrase;
import org.panda_lang.panda.lang.ArrayEssence;

public class FunctionPhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        String functionName = ray.getExpressionValue(0).toString();
        if (ray.getPattern().getIndex() == 0) {
            ArrayEssence arrayEssence = ray.getExpressionValue(1);

        }
        ray.getLightScript().callFunction(functionName, ray.getFactors());
    }

}