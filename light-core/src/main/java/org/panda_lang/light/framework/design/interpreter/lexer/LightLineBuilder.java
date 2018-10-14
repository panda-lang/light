package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.panda.utilities.commons.StringUtils;

class LightLineBuilder {

    private StringBuilder lineBuilder = new StringBuilder();
    private boolean multiline = false;

    protected void next(String line, Runnable processor) {
        String preparedLine = line.trim();
        String indentation = StringUtils.extractParagraph(line);

        boolean startsWithMultiline = preparedLine.startsWith(">");
        boolean endsWithMultiline = preparedLine.endsWith(">");

        if (!multiline && !startsWithMultiline && lineBuilder.length() > 0) {
            processor.run();
        }

        if (startsWithMultiline) {
            preparedLine = preparedLine.substring(2);
        }

        if (endsWithMultiline) {
            preparedLine = preparedLine.substring(0, preparedLine.length() - 2);
        }

        if (lineBuilder.length() > 0) {
            lineBuilder.append(" ");
        }

        lineBuilder.append(indentation);
        lineBuilder.append(preparedLine);

        multiline = endsWithMultiline;
    }

    protected void clear() {
        lineBuilder.setLength(0);
    }

    protected int getLength() {
        return lineBuilder.length();
    }

    protected String getLine() {
        return lineBuilder.toString();
    }

}
