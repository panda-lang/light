package org.panda_lang.light.core;

import org.panda_lang.light.LightScript;
import org.panda_lang.light.core.parser.essential.assistant.PhraseRepresentation;
import org.panda_lang.light.core.parser.util.HollowPattern;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.syntax.Essence;

public class Ray extends Particle {

    private LightScript lightScript;
    private HollowPattern pattern;
    private PhraseRepresentation phraseRepresentation;
    private Essence returnValue;

    public Ray() {
    }

    public Ray(Particle particle) {
        super(particle.getPandaScript(), particle.getMemory(), particle.getEssence(), particle.getInstance(), particle.getFactors());
    }

    public Ray include(Particle particle) {
        super.pandaScript(particle.getPandaScript())
                .memory(particle.getMemory())
                .essence(particle.getEssence())
                .instance(particle.getInstance())
                .factors(particle.getFactors());
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

    public Ray returnValue(Essence returnValue) {
        this.returnValue = returnValue;
        return this;
    }

    public Essence getReturnValue() {
        return returnValue;
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
