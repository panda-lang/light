package org.panda_lang.moonlight.core.element.expression;

import org.panda_lang.panda.lang.ObjectEssence;

public class ExpressionEssence extends ObjectEssence {

    public ExpressionEssence(Object object) {
        super(object);
    }

    public Object getObject() {
        return getJavaValue();
    }

}
