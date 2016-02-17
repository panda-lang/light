package org.panda_lang.light.core;

import org.panda_lang.light.LightScript;
import org.panda_lang.light.core.parser.assistant.ExpressionRepresentation;
import org.panda_lang.light.core.parser.assistant.PhraseRepresentation;
import org.panda_lang.light.core.parser.pattern.LightPattern;
import org.panda_lang.light.core.util.ExpressionRuntime;
import org.panda_lang.light.core.util.ModificationType;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;

import java.util.List;

public class Ray extends Particle {

    private LightScript lightScript;
    private LightPattern pattern;
    private Essence returnValue;
    private PhraseRepresentation phraseRepresentation;
    private ExpressionRepresentation expressionRepresentation;
    private List<ExpressionRuntime> expressionRuntimes;

    public Ray() {
    }

    public Ray(Particle particle) {
        super(particle.getPandaScript(), particle.getMemory(), particle.getEssence(), particle.getInstance(), particle.getFactors());
    }

    @Override
    public Ray factors(Factor... factors) {
        super.setFactors(factors);
        return this;
    }

    public Ray include(Particle particle) {
        super.pandaScript(particle.getPandaScript())
                .memory(particle.getMemory())
                .essence(particle.getEssence())
                .instance(particle.getInstance());
        return this;
    }

    public Ray lightScript(LightScript lightScript) {
        this.lightScript = lightScript;
        return this;
    }

    public Ray pattern(LightPattern pattern) {
        this.pattern = pattern;
        return this;
    }

    public Ray phraseRepresentation(PhraseRepresentation phraseRepresentation) {
        this.phraseRepresentation = phraseRepresentation;
        return this;
    }

    public Ray expressionRepresentation(ExpressionRepresentation expressionRepresentation) {
        this.expressionRepresentation = expressionRepresentation;
        return this;
    }

    public Ray returnValue(Essence returnValue) {
        this.returnValue = returnValue;
        return this;
    }

    public Ray expressionRuntimes(List<ExpressionRuntime> expressionRuntimes) {
        this.expressionRuntimes = expressionRuntimes;
        return this;
    }

    public ModificationType getModificationType() {
        return ModificationType.valueOf(getPattern().getIndex());
    }

    public List<ExpressionRuntime> getExpressionRuntimes() {
        return expressionRuntimes;
    }

    public Essence getReturnValue() {
        return returnValue;
    }

    public ExpressionRepresentation getExpressionRepresentation() {
        return expressionRepresentation;
    }

    public PhraseRepresentation getPhraseRepresentation() {
        return phraseRepresentation;
    }

    public LightPattern getPattern() {
        return pattern;
    }

    public LightScript getLightScript() {
        return lightScript;
    }

}
