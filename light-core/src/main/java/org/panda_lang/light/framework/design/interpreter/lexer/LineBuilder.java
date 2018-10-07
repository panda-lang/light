package org.panda_lang.light.framework.design.interpreter.lexer;

class LineBuilder {

    private StringBuilder lineBuilder = new StringBuilder();
    private boolean multiline = false;

    protected void next(String line, Runnable runnable) {
        String preparedLine = line.trim();

        boolean startsWithMultiline = preparedLine.startsWith(">");
        boolean endsWithMultiline = preparedLine.endsWith(">");

        if (!multiline && !startsWithMultiline && lineBuilder.length() > 0) {
            runnable.run();
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

        lineBuilder.append(preparedLine);
        multiline = endsWithMultiline;
    }

    protected void clear() {
        lineBuilder.setLength(0);
    }

    protected int getLength() {
        return lineBuilder.length();
    }

    protected String getTrimmedLine() {
        return getLine().trim();
    }

    protected String getLine() {
        return lineBuilder.toString();
    }

}
