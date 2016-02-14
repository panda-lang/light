package org.panda_lang.light.core.parser.assistant;

import org.panda_lang.light.core.Phrase;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.parser.pattern.LightPattern;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.util.documentation.Documentation;

import java.util.ArrayList;
import java.util.Collection;

public class PhraseRepresentation {

    private final Phrase phrase;
    private final Collection<LightPattern> patterns;
    private final Documentation documentation;

    public PhraseRepresentation(Phrase phrase) {
        this.phrase = phrase;
        this.patterns = new ArrayList<>(1);
        this.documentation = new Documentation();
    }

    public Essence run(Ray ray) {
        ray.phraseRepresentation(this).returnValue(null);
        phrase.run(ray);
        return ray.getReturnValue();
    }

    public PhraseRepresentation pattern(String pattern) {
        LightPattern lightPattern = LightPattern.builder()
                .compiler()
                .compile(pattern)
                .build(patterns.size());
        return pattern(lightPattern);
    }

    public PhraseRepresentation pattern(LightPattern lightPattern) {
        patterns.add(lightPattern);
        return this;
    }

    public Documentation documentation() {
        return documentation;
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    public Collection<LightPattern> getPatterns() {
        return patterns;
    }

    public Phrase getPhrase() {
        return phrase;
    }

}
