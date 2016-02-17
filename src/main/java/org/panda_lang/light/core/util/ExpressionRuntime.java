package org.panda_lang.light.core.util;

import org.panda_lang.light.core.Expression;
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
            ray.include(particle);
            return expression.getValue(ray);
        }
        return factor.run(particle);
    }

    public Factor toFactor() {
        return new Factor(this);
    }

    public Ray getRay() {
        return ray;
    }

    public Expression getExpression() {
        return expression;
    }

}
