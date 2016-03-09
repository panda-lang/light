package org.panda_lang.light.core;

import org.panda_lang.light.LightScript;
import org.panda_lang.light.core.element.expression.ExpressionModule;
import org.panda_lang.light.core.element.expression.ExpressionRuntime;
import org.panda_lang.light.core.util.ModificationType;
import org.panda_lang.light.core.util.RepresentationInfo;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;

import java.util.List;

public class Ray {

    private Particle particle;
    private LightScript lightScript;
    private ExpressionModule expressionModule;
    private RepresentationInfo representationInfo;
    private HollowPattern pattern;
    private Factor[] factors;

    public Ray() {
        this.expressionModule = new ExpressionModule();
        this.representationInfo = new RepresentationInfo();
    }

    public Ray(Particle particle) {
        this();
        this.particle(particle);
    }

    public Ray particle(Particle particle) {
        this.particle = particle;
        if (factors != null) {
            particle.setFactors(factors);
        }

        particle.setCustom(this);
        return this;
    }

    public Ray factors(Factor... factors) {
        this.factors = factors;
        return this;
    }

    public Ray lightScript(LightScript lightScript) {
        this.lightScript = lightScript;
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

    @SuppressWarnings("unchecked")
    public <T> T getDefaultExpressionValue(int index) {
        ExpressionRuntime expressionRuntime = getExpressionRuntimes().get(index);
        if (expressionRuntime == null) {
            return null;
        }

        particle.setCustom(this);
        return (T) expressionRuntime.run(particle);
    }

    @SuppressWarnings("unchecked")
    public <T> T getExpressionValue(int index) {
        Essence essence = getDefaultExpressionValue(index);
        Object object = essence.getJavaValue();
        return (T) object;
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

    public LightScript getLightScript() {
        return lightScript;
    }

    public Particle getParticle() {
        return particle;
    }

}
