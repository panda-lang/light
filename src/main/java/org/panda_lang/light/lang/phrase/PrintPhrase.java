package org.panda_lang.light.lang.phrase;

import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.element.phrase.Phrase;

public class PrintPhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        Object object = ray.getExpressionValue(0);
        System.out.println(object);
    }

}
