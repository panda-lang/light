package org.panda_lang.light.language.interpreter.pattern.phrasem;

import org.panda_lang.light.language.interpreter.parser.phrase.Phraseme;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;

import java.util.Collection;

public class PhrasemePatternResult {

    private final boolean matched;
    private LexicalExtractorResult lexicalResult;
    private Collection<Phraseme> phrasemes;

    public PhrasemePatternResult(boolean matched) {
        this.matched = matched;
    }

    public boolean isMatched() {
        return matched;
    }

}
