package org.panda_lang.light.core;

import org.panda_lang.light.LightScript;
import org.panda_lang.light.core.element.expression.ExpressionModule;
import org.panda_lang.light.core.element.expression.ExpressionRepresentation;
import org.panda_lang.light.core.element.expression.ExpressionRuntime;
import org.panda_lang.light.core.element.phrase.PhraseRepresentation;
import org.panda_lang.light.core.util.ModificationType;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;

import java.util.List;

public class Ray {

    private Particle particle;
    private LightScript lightScript;
    private HollowPattern pattern;
    private Essence returnValue;
    private PhraseRepresentation phraseRepresentation;
    private ExpressionModule expressionModule;
    private Factor[] factors;

    public Ray() {
        this.expressionModule = new ExpressionModule();
    }

    public Ray(Particle particle) {
        this();
        this.particle = particle;

        particle.setCustom(this);
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

    public Ray phraseRepresentation(PhraseRepresentation phraseRepresentation) {
        this.phraseRepresentation = phraseRepresentation;
        return this;
    }

    public Ray expressionRepresentation(ExpressionRepresentation expressionRepresentation) {
        expressionModule.setExpressionRepresentation(expressionRepresentation);
        return this;
    }

    public Ray returnValue(Essence returnValue) {
        this.returnValue = returnValue;
        return this;
    }

    public Ray expressionRuntimes(List<ExpressionRuntime> expressionRuntimes) {
        expressionModule.setExpressionRuntimes(expressionRuntimes);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getExpressionValue(int index) {
        ExpressionRuntime expressionRuntime = getExpressionRuntimes().get(index);
        if (expressionRuntime == null) {
            return null;
        }

        particle.setCustom(this);
        Essence essence = expressionRuntime.run(particle);
        Object object = essence.getJavaValue();
        return (T) object;
    }

    public ModificationType getModificationType() {
        return ModificationType.valueOf(getPattern().getIndex());
    }

    public List<ExpressionRuntime> getExpressionRuntimes() {
        return expressionModule.getExpressionRuntimes();
    }

    public Essence getReturnValue() {
        return returnValue;
    }

    public ExpressionRepresentation getExpressionRepresentation() {
        return expressionModule.getExpressionRepresentation();
    }

    public ExpressionModule getExpressionModule() {
        return expressionModule;
    }

    public PhraseRepresentation getPhraseRepresentation() {
        return phraseRepresentation;
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
