package org.panda_lang.light.framework.design.interpreter.pattern.linguistic;

import org.junit.jupiter.api.Test;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.LexicalPattern;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.extractor.LexicalExtractorResult;
import org.panda_lang.panda.utilities.commons.BenchmarkUtils;

import java.util.ArrayList;
import java.util.Collection;

public class LexicalPatternTest {

    private final Collection<LexicalPattern<?>> patterns = new ArrayList<>(1_000_000);

    @Test
    public void testPerformance() {
        fill();

        BenchmarkUtils.execute("LexicalPattern ", () -> {
            for (int i = 0; i < 10000; i++) {
                match();
            }
        });
    }

    private void match() {
        for (LexicalPattern<?> pattern : patterns) {
            LexicalExtractorResult<?> result = pattern.extract("matched");

            if (result.isMatched()) {
                break;
            }
        }
    }

    private void fill() {
        LexicalPattern pattern = LexicalPattern.builder()
                .compile("send message:<string> to [the] console")
                .build();

        for (int i = 0; i < 1000; i++) {
            patterns.add(pattern);
        }

        patterns.add(LexicalPattern.builder()
                .compile("matched")
                .build());
    }

}
