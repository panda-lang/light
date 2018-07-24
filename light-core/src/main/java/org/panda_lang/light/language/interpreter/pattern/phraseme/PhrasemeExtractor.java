package org.panda_lang.light.language.interpreter.pattern.phraseme;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.language.interpreter.parser.phrase.Phraseme;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesCandidate;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesGroup;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.LexicalExtractor;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.LexicalExtractorWorker;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.processed.WildcardProcessor;

public class PhrasemeExtractor implements LexicalExtractor<Phraseme> {

    private final PhrasemePattern pattern;
    private final PhrasemesGroup group;
    private final @Nullable PhrasemesCandidate previousCandidate;

    public PhrasemeExtractor(PhrasemePattern pattern, PhrasemesGroup group, @Nullable PhrasemesCandidate previousResult) {
        this.pattern = pattern;
        this.group = group;
        this.previousCandidate = previousResult;
    }

    @Override
    public LexicalExtractorResult<Phraseme> extract(String phrase) {
        WildcardProcessor<Phraseme> wildcardProcessor = null;

        if (pattern.getWildcardProcessor() != null) {
            wildcardProcessor = wildcard -> pattern.getWildcardProcessor().handle(group, wildcard, previousCandidate);
        }

        if (wildcardProcessor == null && pattern.getLexicalPattern().hasWildcardProcessor()) {
            wildcardProcessor = pattern.getLexicalPattern().getWildcardProcessor();
        }

        LexicalExtractorWorker<Phraseme> extractorWorker = new LexicalExtractorWorker<>(wildcardProcessor);
        return extractorWorker.extract(pattern.getLexicalPattern().getModel(), phrase);
    }

}
