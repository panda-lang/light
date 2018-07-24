package org.panda_lang.light.language.interpreter.pattern.phraseme;

import org.panda_lang.light.language.interpreter.parser.phrase.Phraseme;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesCandidate;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesGroup;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.LexicalExtractor;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.LexicalExtractorWorker;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.processed.WildcardProcessor;

import java.util.ArrayList;
import java.util.Collection;

public class PhrasemeExtractor implements LexicalExtractor<Phraseme> {

    private final PhrasemePattern pattern;
    private final PhrasemesGroup group;
    private final PhrasemesCandidate previousCandidate;

    public PhrasemeExtractor(PhrasemePattern pattern, PhrasemesGroup group, PhrasemesCandidate previousResult) {
        this.pattern = pattern;
        this.group = group;
        this.previousCandidate = previousResult;
    }

    @Override
    public LexicalExtractorResult<Phraseme> extract(String phrase) {
        LexicalExtractorWorker<Phraseme> extractorWorker = new LexicalExtractorWorker<>(wildcardProcessors);
        return extractorWorker.extract(pattern.getLexicalPattern().getModel(), phrase);
    }

}
