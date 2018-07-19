package org.panda_lang.light.language.interpreter.pattern.phraseme;

import org.panda_lang.light.language.interpreter.parser.phrase.Phraseme;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;

public class PhrasemePatternResult {

    private final boolean matched;
    protected LexicalExtractorResult<Phraseme> lexicalResult;

    public PhrasemePatternResult(boolean matched) {
        this.matched = matched;
    }

    public PhrasemePatternResult(LexicalExtractorResult<Phraseme> result) {
        this.matched = result.isMatched();
        this.lexicalResult = result;
    }

    public boolean isMatched() {
        return matched;
    }

}
