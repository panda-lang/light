package org.panda_lang.light.lang.expression;

import org.panda_lang.light.core.element.expression.Expression;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.util.Modification;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.lang.StringEssence;

public class PandaVersionExpression extends Expression {

    private static String version = Panda.PANDA_VERSION;

    @Override
    public void modify(Modification modification) {
        switch (modification.getType()) {
            case ADD:
                break;
            case SET:
                version = modification.getValue().run(modification.getRay()).toString();
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
