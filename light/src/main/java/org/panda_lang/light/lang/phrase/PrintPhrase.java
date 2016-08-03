package org.panda_lang.light.lang.phrase;

public class PrintPhrase implements org.panda_lang.light.core.element.phrase.Phrase {

    @Override
    public void run(org.panda_lang.light.core.Ray ray) {
        Object object = ray.getExpressionValue(0);
        System.out.println(object);
    }

}
