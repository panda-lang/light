package org.panda_lang.light.core.parser.util;

import org.panda_lang.light.Light;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.parser.Phrase;
import org.panda_lang.panda.core.syntax.Essence;

import java.util.ArrayList;
import java.util.Collection;

public class PhraseRepresentation implements Phrase {

    private final Collection<HollowPattern> patterns;
    private final Phrase phrase;

    public PhraseRepresentation(Phrase phrase) {
        this.patterns = new ArrayList<>();
        this.phrase = phrase;
    }

    @Override
    public Essence run(Ray ray) {
        return phrase.run(ray);
    }

    public void registerPattern(String expression) {
        registerPattern(new HollowPattern(patterns.size(), expression));
    }

    public void registerPattern(HollowPattern hollowPattern) {
        patterns.add(hollowPattern);
    }

    public void register(Light light) {
        light.registerPhrase(this);
    }

    public Phrase getPhrase() {
        return phrase;
    }

    public Collection<HollowPattern> getPatterns() {
        return patterns;
    }

}
