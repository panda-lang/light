package org.panda_lang.light.core.parser.essential.assistant;

import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.parser.Phrase;
import org.panda_lang.light.core.parser.util.HollowPattern;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.util.documentation.Documentation;

import java.util.ArrayList;
import java.util.Collection;

public class PhraseRepresentation {

    private final Phrase phrase;
    private final Collection<HollowPattern> patterns;
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

    public PhraseRepresentation pattern(String expression) {
        return pattern(new HollowPattern(patterns.size(), expression));
    }

    public PhraseRepresentation pattern(HollowPattern hollowPattern) {
        patterns.add(hollowPattern);
        return this;
    }

    public Documentation documentation() {
        return documentation;
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    public Collection<HollowPattern> getPatterns() {
        return patterns;
    }

    public Phrase getPhrase() {
        return phrase;
    }

}
