package org.panda_lang.light.lang.phrase;

import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.element.phrase.Phrase;
import org.panda_lang.panda.core.syntax.Essence;

public class PrintPhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        Essence message = ray.getExpressionValue(0);
        System.out.println(message);
    }

}
