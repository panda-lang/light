package org.panda_lang.moonlight.core.element.expression;

import org.panda_lang.panda.lang.ObjectInst;

public class ExpressionInst extends ObjectInst {

    public ExpressionInst(Object object) {
        super(object);
    }

    public Object getObject() {
        return getJavaValue();
    }

}
