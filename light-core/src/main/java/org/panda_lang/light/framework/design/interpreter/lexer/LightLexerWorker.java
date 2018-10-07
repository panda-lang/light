package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.light.framework.design.interpreter.source.LightTokenizedSource;
import org.panda_lang.light.framework.design.interpreter.token.Sentence;
import org.panda_lang.light.framework.design.interpreter.token.SentenceRepresentation;
import org.panda_lang.panda.framework.design.interpreter.lexer.Lexer;
import org.panda_lang.panda.framework.design.interpreter.token.Token;
import org.panda_lang.panda.framework.design.interpreter.token.TokenRepresentation;
import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;
import org.panda_lang.panda.framework.language.interpreter.token.PandaTokenRepresentation;
import org.panda_lang.panda.framework.language.resource.syntax.separator.Separators;
import org.panda_lang.panda.utilities.commons.StringUtils;

import java.util.ArrayList;
import java.util.List;

class LightLexerWorker implements Lexer {

    private final LightLexer lexer;
    private List<TokenRepresentation> tokens = new ArrayList<>();
    private LineBuilder lineBuilder = new LineBuilder();
    private int previousLine = -1;

    protected LightLexerWorker(LightLexer lexer) {
        this.lexer = lexer;
    }

    @Override
    public TokenizedSource convert() {
        String[] lines = lexer.getSource().split(lexer.getLineSeparator());

        for (int lineNumber = 0; lineNumber < lines.length; lineNumber++) {
            String line = lines[lineNumber];

            if (StringUtils.isEmpty(line)) {
                continue;
            }

            if (previousLine == -1) {
                previousLine = lineNumber;
            }

            String preparedLine = line.trim();
            int currentLine = lineNumber;

            lineBuilder.next(preparedLine, () -> {
                check(currentLine);
            });
        }

        if (lineBuilder.getLength() > 0) {
            this.check(previousLine);
        }

        return new LightTokenizedSource(tokens);
    }

    private void check(int lineNumber) {
        String phraseValue = lineBuilder.getTrimmedLine();

        boolean open = phraseValue.endsWith("{");
        boolean close = phraseValue.endsWith("}") && !phraseValue.contains("{");

        if (open) {
            phraseValue = phraseValue.substring(0, phraseValue.length() - 1);
        }

        if (close) {
            phraseValue = phraseValue.substring(1);
        }

        phraseValue = phraseValue.trim();

        if (phraseValue.length() > 0) {
            Sentence phrase = new Sentence(phraseValue);
            SentenceRepresentation representation = new SentenceRepresentation(phrase, previousLine);
            tokens.add(representation);
        }

        if (open || close) {
            Token operator = open ? Separators.LEFT_BRACE_DELIMITER : Separators.RIGHT_BRACE_DELIMITER;
            TokenRepresentation separatorRepresentation = new PandaTokenRepresentation(operator, previousLine);
            tokens.add(separatorRepresentation);
        }

        lineBuilder.clear();
        previousLine = lineNumber;
    }

}
