package org.panda_lang.moonlight.lang.phrase;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.phrase.Phrase;
import org.panda_lang.panda.lang.ArrayEssence;

public class FunctionPhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        if (ray.getPattern().getIndex() == 0) {
            ArrayEssence arrayEssence = ray.getExpressionValue(0);

        }
        ray.getMoonlightScript().callFunction(ray.getHollows().get(0), ray.getFactors());
    }

}