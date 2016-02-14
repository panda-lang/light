package org.panda_lang.light.lang.phrase;

import org.panda_lang.light.core.Phrase;
import org.panda_lang.light.core.Ray;
import org.panda_lang.panda.lang.ArrayEssence;

public class FunctionPhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        String functionName = ray.getValueOfFactor(0).toString();
        if (ray.getPattern().getID() == 0) {
            ArrayEssence arrayEssence = ray.getValueOfFactor(1);

        }
        ray.getLightScript().callFunction(functionName, ray.getFactors());
    }

}