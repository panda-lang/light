package org.panda_lang.moonlight.lang.expression;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.util.Modification;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.lang.StringEssence;

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
    public Essence getValue(Ray ray) {
        return new StringEssence(version);
    }

}
