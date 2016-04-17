package org.panda_lang.moonlight.core;

import org.panda_lang.moonlight.MoonlightScript;
import org.panda_lang.moonlight.core.element.expression.ExpressionModule;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.moonlight.core.util.ModificationType;
import org.panda_lang.moonlight.core.util.RepresentationInfo;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.statement.Factor;

import java.util.List;

public class Ray {

    private Alice alice;
    private MoonlightScript moonlightScript;
    private ExpressionModule expressionModule;
    private RepresentationInfo representationInfo;
    private HollowPattern pattern;
    private List<String> hollows;
    private Scope argumentScope;
    private Object scopeObject;
    private Factor[] factors;

    public Ray(Alice alice) {
        this();
        this.particle(alice);
    }

    public Ray() {
        this.expressionModule = new ExpressionModule();
        this.representationInfo = new RepresentationInfo();
    }

    public Ray script(MoonlightScript moonlightScript) {
        this.moonlightScript = moonlightScript;
        return this;
    }

    public Ray pattern(HollowPattern pattern) {
        this.pattern = pattern;
        return this;
    }

    public Ray expressionRuntimes(List<ExpressionRuntime> expressionRuntimes) {
        expressionModule.setExpressionRuntimes(expressionRuntimes);
        return this;
    }

    public Ray hollows(List<String> hollows) {
        this.hollows = hollows;
        return this;
    }

    public Ray scopeObject(Object scopeObject) {
        this.scopeObject = scopeObject;
        return this;
    }

    public Ray argumentScope(Scope argumentScope) {
        this.argumentScope = argumentScope;
        return this;
    }

    public Ray factors(Factor... factors) {
        this.factors = factors;
        if (alice != null) {
            alice.factors(factors);
        }
        return this;
    }

    public Ray particle(Alice alice) {
        this.alice = alice;
        if (factors != null) {
            alice.setFactors(factors);
        }

        alice.setCustom(this);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getDefaultExpressionValue(int index) {
        ExpressionRuntime expressionRuntime = getExpressionRuntimes().get(index);
        if (expressionRuntime == null) {
            return null;
        }

        alice.setCustom(this);
        return (T) expressionRuntime.execute(alice);
    }

    @SuppressWarnings("unchecked")
    public <T> T getExpressionValue(int index) {
        Essence essence = getDefaultExpressionValue(index);
        Object object = essence != null ? essence.getJavaValue() : null;
        return (T) object;
    }

    public List<String> getHollows() {
        return hollows;
    }

    public Scope getArgumentScope() {
        return argumentScope;
    }

    public Object getScopeObject() {
        return scopeObject;
    }

    public ModificationType getModificationType() {
        return ModificationType.valueOf(getPattern().getIndex());
    }

    public List<ExpressionRuntime> getExpressionRuntimes() {
        return expressionModule.getExpressionRuntimes();
    }

    public RepresentationInfo getRepresentationInfo() {
        return representationInfo;
    }

    public ExpressionModule getExpressionModule() {
        return expressionModule;
    }

    public Factor[] getFactors() {
        return factors;
    }

    public HollowPattern getPattern() {
        return pattern;
    }

    public MoonlightScript getMoonlightScript() {
        return moonlightScript;
    }

    public Alice getAlice() {
        return alice;
    }

}
