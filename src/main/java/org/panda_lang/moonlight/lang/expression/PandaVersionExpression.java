package org.panda_lang.moonlight.lang.expression;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.util.Modification;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.lang.StringInst;

public class PandaVersionExpression extends Expression {

    private static String version = Panda.PANDA_VERSION;

    @Override
    public void modify(Modification modification) {
        switch (modification.getType()) {
            case ADD:
                break;
            case SET:
                version = modification.getValue().get(modification.getRay()).toString();
                break;
            case REMOVE:
                break;
            case DELETE:
                break;
        }
    }

    @Override
    public Inst getValue(Ray ray) {
        return new StringInst(version);
    }

}
