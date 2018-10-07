package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.light.framework.design.interpreter.source.LightTokenizedSource;
import org.panda_lang.panda.framework.design.interpreter.lexer.Lexer;
import org.panda_lang.panda.framework.design.interpreter.token.TokenRepresentation;
import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;
import org.panda_lang.panda.utilities.commons.StringUtils;

import java.util.ArrayList;
import java.util.List;

class LightIndentationLexerWorker implements Lexer {

    private final LightIndentationLexer lexer;

    private List<TokenRepresentation> tokens = new ArrayList<>();
    private LineBuilder lineBuilder = new LineBuilder();
    private int previousLine = -1;

    protected LightIndentationLexerWorker(LightIndentationLexer lexer) {
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

            String indentation = StringUtils.extractParagraph(line);
            int currentLine = lineNumber;

            lineBuilder.next(line, () -> {
                checkSection(currentLine);
            });
        }

        if (lineBuilder.getLength() > 0) {
            this.checkSection(previousLine);
        }

        return new LightTokenizedSource(tokens);
    }

    private void checkSection(int lineNumber) {
        /*
        String phraseValue = lineBuilder.toString().trim();

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

        lineBuilder.setLength(0);
        previousLine = lineNumber;
        */
    }

}
