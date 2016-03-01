package org.panda_lang.light.core;

import org.panda_lang.light.LightScript;
import org.panda_lang.light.core.parser.assistant.ExpressionRepresentation;
import org.panda_lang.light.core.parser.assistant.PhraseRepresentation;
import org.panda_lang.light.core.util.ExpressionModule;
import org.panda_lang.light.core.util.ExpressionRuntime;
import org.panda_lang.light.core.util.ModificationType;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;

import java.util.List;

public class Ray extends Particle {

    private LightScript lightScript;
    private HollowPattern pattern;
    private Essence returnValue;
    private PhraseRepresentation phraseRepresentation;
    private ExpressionModule expressionModule;

    public Ray() {
        this.expressionModule = new ExpressionModule();
    }

    public Ray(Particle particle) {
        super(particle.getPandaScript(), particle.getMemory(), particle.getEssence(), particle.getInstance(), particle.getFactors());
        this.expressionModule = new ExpressionModule();
    }

    @Override
    public Ray factors(Factor... factors) {
        super.setFactors(factors);
        return this;
    }

    public Ray include(Particle particle) {
        super.memory(particle.getMemory())
                .essence(particle.getEssence())
                .instance(particle.getInstance());
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
        Essence essence = expressionRuntime.run(this);
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

    public HollowPattern getPattern() {
        return pattern;
    }

    public LightScript getLightScript() {
        return lightScript;
    }

}
