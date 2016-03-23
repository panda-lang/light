package org.panda_lang.moonlight.core.element.expression;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;
import org.panda_lang.panda.core.syntax.Runtime;
import org.panda_lang.panda.lang.ObjectEssence;

public class ExpressionRuntime extends Runtime {

    private Expression expression;
    private Factor factor;
    private Ray ray;

    public ExpressionRuntime(Factor factor) {
        this.factor = factor;
    }

    public ExpressionRuntime(Expression expression, Ray ray) {
        this.expression = expression;
        this.ray = ray;
    }

    @Override
    public Essence run(Particle particle) {
        if (ray == null) {
            ray = new Ray();
        }

        ray.particle(particle);
        return run(ray);
    }

    public Essence run(Ray ray) {
        if (expression != null) {
            return getExpressionValue(ray);
        }
        return getFactorValue(ray);
    }

    public Factor toFactor() {
        return new Factor(this);
    }

    public Essence getFactorValue(Ray ray) {
        return factor.getValue(ray.getParticle());
    }

    public Essence getExpressionValue(Ray ray) {
        Object object = expression.getValue(ray);
        return new ObjectEssence(object);
    }

    public Ray getRay() {
        return ray;
    }

    public Expression getExpression() {
        return expression;
    }

}
