package org.panda_lang.light.lang;

import org.panda_lang.light.core.LightCore;
import org.panda_lang.light.core.parser.essential.assistant.ExpressionRepresentation;
import org.panda_lang.light.lang.expression.PandaVersionExpression;

public class Expressions {

    private final LightCore lightCore;

    public Expressions(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public void registerDefaultExpressions() {
        ExpressionRepresentation pandaVersionExpression = new ExpressionRepresentation(new PandaVersionExpression());
        pandaVersionExpression.pattern("panda version");
        lightCore.registerExpression(pandaVersionExpression);
    }

}
