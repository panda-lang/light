package org.panda_lang.moonlight.core.element.expression;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.statement.RuntimeValue;
import org.panda_lang.panda.core.statement.Runtime;

public class ExpressionRuntime extends Runtime {

    protected Expression expression;
    protected RuntimeValue runtimeValue;
    protected Ray ray;

    public ExpressionRuntime(RuntimeValue runtimeValue) {
        this.runtimeValue = runtimeValue;
    }

    public ExpressionRuntime(Expression expression, Ray ray) {
        this.expression = expression;
        this.ray = ray;
    }

    @Override
    public Inst execute(Alice alice) {
        if (ray == null) {
            if (alice.getCustom() != null) {
                ray = alice.getCustom();
            }
            else {
                ray = new Ray();
            }
        }
        ray.particle(alice);
        return get(ray);
    }

    public Inst get(Ray ray) {
        if (expression != null) {
            return getExpressionValue(ray);
        }
        return getFactorValue(ray);
    }

    public RuntimeValue toFactor() {
        return new RuntimeValue(this);
    }

    public Inst getFactorValue(Ray ray) {
        return runtimeValue.getValue(ray.getAlice());
    }

    public Inst getExpressionValue(Ray ray) {
        Object object = expression.getValue(ray);
        if (object instanceof Inst) {
            return (Inst) object;
        }
        return new ExpressionInst(object);
    }

    public Ray getRay() {
        return ray;
    }

    public Expression getExpression() {
        return expression;
    }

}
