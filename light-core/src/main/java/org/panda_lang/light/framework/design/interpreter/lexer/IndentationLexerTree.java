package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.light.LightException;
import org.panda_lang.light.framework.design.interpreter.token.SentenceRepresentation;
import org.panda_lang.panda.framework.design.interpreter.token.TokenRepresentation;
import org.panda_lang.panda.utilities.commons.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class IndentationLexerTree {

    private final List<Object> elements = new ArrayList<>();
    private final Stack<Group> currentGroups = new Stack<>();
    private final LightLineBuilder lineBuilder = new LightLineBuilder();

    private String previousIndentation = StringUtils.EMPTY;
    private int indentationLength = -1;
    private int previousLine = -1;

    protected List<Object> build(String[] lines) {
        for (int lineNumber = 0; lineNumber < lines.length; lineNumber++) {
            String line = lines[lineNumber];
            int currentLine = lineNumber;

            if (StringUtils.isEmpty(line)) {
                continue;
            }

            if (previousLine == -1) {
                previousLine = lineNumber;
            }

            lineBuilder.next(line, () -> check(currentLine));
        }

        if (lineBuilder.getLength() > 0) {
            this.check(previousLine);
        }

        return elements;
    }

    private void check(int lineNumber) {
        String line = lineBuilder.getLine();
        String indentation = StringUtils.extractParagraph(line);

        if (indentationLength == -1 && indentation.length() > 0) {
            indentationLength = indentation.length();
        }

        String preparedLine = line.trim();
        int level = indentation.length() / indentationLength;

        if (line.endsWith(":")) {
            Group group = new Group(level, SentenceRepresentation.of(preparedLine.substring(0, preparedLine.length() - 1), lineNumber));
            add(level, group);
        }
        else {
            add(level, SentenceRepresentation.of(preparedLine, lineNumber));
        }

        lineBuilder.clear();
    }

    private void add(int currentLevel, Object element) {
        if (currentLevel == 0 || currentGroups.isEmpty()) {
            pushHeadElement(element);
            return;
        }

        Group previousGroup = currentGroups.peek();
        int levelDiff = currentLevel - previousGroup.level;

        if (levelDiff == 1) {
            addElementToGroup(previousGroup, element);
            return;
        }
        else if (levelDiff > 1) {
            throw new LightException("Too nested section " + element.toString());
        }

        if (levelDiff == 0) {
            levelDiff = 1;
        }

        popLevels(levelDiff);

        if (!currentGroups.isEmpty()) {
            addElementToGroup(currentGroups.peek(), element);
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

    private void addElementToGroup(Group previousGroup, Object element) {
        previousGroup.addElement(element);
        addIfGroup(element);
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
