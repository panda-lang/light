package org.panda_lang.light.core.element.expression;

import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.statement.RuntimeValue;

public class ExpressionRuntime extends Runtime {

    protected Expression expression;
    protected RuntimeValue runtimeValue;
    protected org.panda_lang.light.core.Ray ray;

    public ExpressionRuntime(RuntimeValue runtimeValue) {
        this.runtimeValue = runtimeValue;
    }

    public ExpressionRuntime(Expression expression, org.panda_lang.light.core.Ray ray) {
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
                ray = new org.panda_lang.light.core.Ray();
            }
        }
        ray.particle(alice);
        return get(ray);
    }

    public Inst get(org.panda_lang.light.core.Ray ray) {
        if (expression != null) {
            return getExpressionValue(ray);
        }
        return getFactorValue(ray);
    }

    public RuntimeValue toFactor() {
        return new RuntimeValue(this);
    }

    public Inst getFactorValue(org.panda_lang.light.core.Ray ray) {
        return runtimeValue.getValue(ray.getAlice());
    }

    public Inst getExpressionValue(org.panda_lang.light.core.Ray ray) {
        Object object = expression.getValue(ray);
        if (object instanceof Inst) {
            return (Inst) object;
        }
        return new ExpressionInst(object);
    }

    public org.panda_lang.light.core.Ray getRay() {
        return ray;
    }

    public Expression getExpression() {
        return expression;
    }

}
