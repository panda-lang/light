package org.panda_lang.light.core.element.expression;

import org.panda_lang.light.core.Ray;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;
import org.panda_lang.panda.core.syntax.Runtime;

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
        if (expression != null) {
            return getExpressionValue(particle);
        }
        return getFactorValue(particle);
    }

    public Factor toFactor() {
        return new Factor(this);
    }

    public Essence getFactorValue(Particle particle) {
        return factor.getValue(particle);
    }

    public Essence getExpressionValue(Particle particle) {
        ray.particle(particle);
        return expression.getValue(ray);
    }

    public Ray getRay() {
        return ray;
    }

    public Expression getExpression() {
        return expression;
    }

}
