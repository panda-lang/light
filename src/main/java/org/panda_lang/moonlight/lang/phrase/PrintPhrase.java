package org.panda_lang.moonlight.lang.phrase;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.phrase.Phrase;

public class PrintPhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        Object object = ray.getExpressionValue(0);
        System.out.println(object);
    }

}
