package org.panda_lang.light.lang.expression;

import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.lang.StringInst;

public class PandaVersionExpression extends org.panda_lang.light.core.element.expression.Expression {

    private static String version = Panda.PANDA_VERSION;

    @Override
    public void modify(org.panda_lang.light.core.util.Modification modification) {
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
    public Inst getValue(org.panda_lang.light.core.Ray ray) {
        return new StringInst(version);
    }

}
