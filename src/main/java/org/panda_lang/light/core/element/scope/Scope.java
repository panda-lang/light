package org.panda_lang.light.core.element.scope;

import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.element.expression.ExpressionModule;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.syntax.Block;
import org.panda_lang.panda.core.syntax.Essence;

public class Scope extends Block {

    @Override
    public Essence run(Particle particle) {
        Ray ray = particle.getCustom();
        ExpressionModule expressionModule = ray.getExpressionModule();

        return super.run(particle);
    }

}
