package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.light.framework.design.interpreter.source.LightTokenizedSource;
import org.panda_lang.light.framework.design.interpreter.token.SentenceRepresentation;
import org.panda_lang.panda.framework.design.interpreter.lexer.Lexer;
import org.panda_lang.panda.framework.design.interpreter.token.TokenRepresentation;
import org.panda_lang.panda.framework.design.interpreter.token.TokenizedSource;
import org.panda_lang.panda.utilities.commons.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class LightIndentationLexerWorker implements Lexer {

    private final LightIndentationLexer lexer;
    private final List<TokenRepresentation> tokens = new ArrayList<>();

    private final List<Group> groups = new ArrayList<>();
    private final Stack<Group> currentGroups = new Stack<>();
    private final LineBuilder lineBuilder = new LineBuilder();

    private String previousIndentation = StringUtils.EMPTY;
    private int indentationLength = -1;
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

            if (!StringUtils.isEmpty(indentation) && indentationLength == -1) {
                indentationLength = indentation.length();
            }

            lineBuilder.next(line, () -> {
                checkSection(indentation, currentLine);
            });
        }

        if (lineBuilder.getLength() > 0) {
            this.checkSection(previousIndentation, previousLine);
        }

        return new LightTokenizedSource(tokens);
    }

    private void checkSection(String indentation, int lineNumber) {
        String linePreview = lineBuilder.getTrimmedLine();

        if (linePreview.endsWith(":")) {
            Group group = new Group(indentation.length(), SentenceRepresentation.of(linePreview, lineNumber));

            if (group.getLevel() == 0) {
                currentGroups.clear();
                currentGroups.add(group);
                groups.add(group);
            }
            else if (currentGroups.isEmpty()) {
                currentGroups.push(group);
                groups.add(group);
            }
            else {
                Group previousGroup = currentGroups.peek();

                if (previousGroup.getLevel() < group.getLevel()) {
                    currentGroups.push(group);
                    previousGroup.addElement(group);
                }
                else {
                    int levels = previousGroup.getLevel() - group.getLevel();

                    currentGroups.pop();
                    previousGroup = currentGroups.peek();
                    previousGroup.addElement(group);
                    currentGroups.push(group);
                }
            }
        }

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

    static class Group {

        private final int level;
        private final TokenRepresentation master;
        private final List<Object> elements = new ArrayList<>();

        Group(int level, TokenRepresentation master) {
            this.level = level;
            this.master = master;
        }

        public void addElement(Object element) {
            elements.add(element);
        }

        public List<Object> getElements() {
            return elements;
        }

        public TokenRepresentation getMaster() {
            return master;
        }

        public int getLevel() {
            return level;
        }

    }

}
