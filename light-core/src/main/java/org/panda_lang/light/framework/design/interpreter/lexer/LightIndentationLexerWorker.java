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

    private final List<Object> elements = new ArrayList<>();
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

            if (indentation.length() > 0 && indentationLength == -1) {
                indentationLength = indentation.length();
            }

            lineBuilder.next(line, () -> check(indentation, currentLine));
        }

        if (lineBuilder.getLength() > 0) {
            this.check(previousIndentation, previousLine);
        }

        return new LightTokenizedSource(tokens);
    }

    private void check(String indentation, int lineNumber) {
        String line = lineBuilder.getTrimmedLine();
        int level = indentation.length() / indentationLength;

        if (line.endsWith(":")) {
            Group group = new Group(level, SentenceRepresentation.of(line.substring(0, line.length() - 1), lineNumber));
            addElement(level, group);
        }
        else {
            addElement(level, SentenceRepresentation.of(line, lineNumber));
        }

        lineBuilder.clear();
    }

    private void addElement(int currentLevel, Object element) {
        if (currentLevel == 0 || currentGroups.isEmpty()) {
            pushHeadElement(element);
            return;
        }

        Group previousGroup = currentGroups.peek();

        if (previousGroup.getLevel() < currentLevel) {
            popLevels(currentLevel - previousGroup.getLevel());
            addElement(previousGroup, element);
            return;
        }

        popLevels(previousGroup.getLevel() - currentLevel);

        if (!currentGroups.isEmpty()) {
            previousGroup = currentGroups.peek();
            addElement(previousGroup, element);
        }
        else {
            addElement(element);
        }
    }

    private void pushHeadElement(Object element) {
        currentGroups.clear();
        addElement(element);
    }

    private void addElement(Object element) {
        elements.add(element);
        addIfGroup(element);
    }

    private void addElement(Group previousGroup, Object element) {
        addIfGroup(element);
        previousGroup.addElement(element);
    }

    private void addIfGroup(Object element) {
        if (element instanceof Group) {
            currentGroups.push((Group) element);
        }
    }

    private void popLevels(int levels) {
        for (int i = 0; i < levels; i++) {
            currentGroups.pop();
        }
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
