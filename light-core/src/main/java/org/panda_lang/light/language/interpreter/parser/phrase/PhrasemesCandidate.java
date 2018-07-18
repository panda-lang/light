package org.panda_lang.light.language.interpreter.parser.phrase;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.language.interpreter.pattern.phrasem.PhrasemePatternResult;

public class PhrasemesCandidate {

    private final boolean matched;
    private Phraseme phraseme;
    private PhrasemePatternResult patternResult;

    protected PhrasemesCandidate(boolean matched) {
        this.matched = matched;
    }

    public PhrasemesCandidate(Phraseme phraseme, PhrasemePatternResult patternResult) {
        this(true);
        this.phraseme = phraseme;
        this.patternResult = patternResult;
    }

    public PhrasemesCandidate() {
        this(false);
    }

    public boolean isMatched() {
        return matched;
    }

    public @Nullable PhrasemePatternResult getPatternResult() {
        return patternResult;
    }

    public @Nullable Phraseme getPhraseme() {
        return phraseme;
    }

}
