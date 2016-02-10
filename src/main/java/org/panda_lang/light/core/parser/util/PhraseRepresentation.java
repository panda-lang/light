package org.panda_lang.light.core.parser.util;

import org.panda_lang.light.Light;
import org.panda_lang.light.core.parser.Phrase;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Executable;

import java.util.ArrayList;
import java.util.Collection;

public class PhraseRepresentation implements Phrase {

    private final Collection<HollowPattern> patterns;
    private final Executable executable;

    public PhraseRepresentation(Executable executable) {
        this.patterns = new ArrayList<>();
        this.executable = executable;
    }

    @Override
    public Essence run(Particle particle) {
        return executable.run(particle);
    }

    public void registerPattern(String expression) {
        registerPattern(new HollowPattern(expression));
    }

    public void registerPattern(HollowPattern pattern) {
        patterns.add(pattern);
    }

    public void register(Light light) {
        light.registerPhrase(this);
    }

    public Executable getExecutable() {
        return executable;
    }

    public Collection<HollowPattern> getPatterns() {
        return patterns;
    }

}
