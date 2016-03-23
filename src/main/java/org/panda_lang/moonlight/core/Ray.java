package org.panda_lang.moonlight.core;

import org.panda_lang.moonlight.MoonlightScript;
import org.panda_lang.moonlight.core.element.expression.ExpressionModule;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.util.ModificationType;
import org.panda_lang.moonlight.core.util.RepresentationInfo;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;

import java.util.List;

public class Ray {

    private Particle particle;
    private MoonlightScript moonlightScript;
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

    public Ray lightScript(MoonlightScript moonlightScript) {
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

    public MoonlightScript getMoonlightScript() {
        return moonlightScript;
    }

    public Particle getParticle() {
        return particle;
    }

}
