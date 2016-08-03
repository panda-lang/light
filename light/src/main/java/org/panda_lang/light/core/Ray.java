package org.panda_lang.light.core;

import org.panda_lang.light.LightScript;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.statement.RuntimeValue;

import java.util.List;

public class Ray {

    private Alice alice;
    private LightScript lightScript;
    private org.panda_lang.light.core.element.expression.ExpressionModule expressionModule;
    private org.panda_lang.light.core.util.RepresentationInfo representationInfo;
    private HollowPattern pattern;
    private List<String> hollows;
    private org.panda_lang.light.core.element.scope.Scope argumentScope;
    private Object scopeObject;
    private RuntimeValue[] runtimeValues;

    public Ray(Alice alice) {
        this();
        this.particle(alice);
    }

    public Ray() {
        this.expressionModule = new org.panda_lang.light.core.element.expression.ExpressionModule();
        this.representationInfo = new org.panda_lang.light.core.util.RepresentationInfo();
    }

    public org.panda_lang.light.core.Ray script(LightScript lightScript) {
        this.lightScript = lightScript;
        return this;
    }

    public org.panda_lang.light.core.Ray pattern(HollowPattern pattern) {
        this.pattern = pattern;
        return this;
    }

    public org.panda_lang.light.core.Ray expressionRuntimes(List<org.panda_lang.light.core.element.expression.ExpressionRuntime> expressionRuntimes) {
        expressionModule.setExpressionRuntimes(expressionRuntimes);
        return this;
    }

    public org.panda_lang.light.core.Ray hollows(List<String> hollows) {
        this.hollows = hollows;
        return this;
    }

    public org.panda_lang.light.core.Ray scopeObject(Object scopeObject) {
        this.scopeObject = scopeObject;
        return this;
    }

    public org.panda_lang.light.core.Ray argumentScope(org.panda_lang.light.core.element.scope.Scope argumentScope) {
        this.argumentScope = argumentScope;
        return this;
    }

    public org.panda_lang.light.core.Ray factors(RuntimeValue... runtimeValues) {
        this.runtimeValues = runtimeValues;
        if (alice != null) {
            alice.factors(runtimeValues);
        }
        return this;
    }

    public org.panda_lang.light.core.Ray particle(Alice alice) {
        this.alice = alice;
        if (runtimeValues != null) {
            alice.setRuntimeValues(runtimeValues);
        }

        alice.setCustom(this);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getDefaultExpressionValue(int index) {
        org.panda_lang.light.core.element.expression.ExpressionRuntime expressionRuntime = getExpressionRuntimes().get(index);
        if (expressionRuntime == null) {
            return null;
        }

        alice.setCustom(this);
        return (T) expressionRuntime.execute(alice);
    }

    @SuppressWarnings("unchecked")
    public <T> T getExpressionValue(int index) {
        Inst inst = getDefaultExpressionValue(index);
        Object object = inst != null ? inst.getJavaValue() : null;
        return (T) object;
    }

    public List<String> getHollows() {
        return hollows;
    }

    public org.panda_lang.light.core.element.scope.Scope getArgumentScope() {
        return argumentScope;
    }

    public Object getScopeObject() {
        return scopeObject;
    }

    public org.panda_lang.light.core.util.ModificationType getModificationType() {
        return org.panda_lang.light.core.util.ModificationType.valueOf(getPattern().getIndex());
    }

    public List<org.panda_lang.light.core.element.expression.ExpressionRuntime> getExpressionRuntimes() {
        return expressionModule.getExpressionRuntimes();
    }

    public org.panda_lang.light.core.util.RepresentationInfo getRepresentationInfo() {
        return representationInfo;
    }

    public org.panda_lang.light.core.element.expression.ExpressionModule getExpressionModule() {
        return expressionModule;
    }

    public RuntimeValue[] getRuntimeValues() {
        return runtimeValues;
    }

    public HollowPattern getPattern() {
        return pattern;
    }

    public LightScript getLightScript() {
        return lightScript;
    }

    public Alice getAlice() {
        return alice;
    }

}
