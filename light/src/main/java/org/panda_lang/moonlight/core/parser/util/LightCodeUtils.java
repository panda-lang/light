package org.panda_lang.moonlight.core.parser.util;

public class LightCodeUtils {

    public static String convert(String source) {
        final String[] lines = source.split(System.lineSeparator());

        for (int i = 0; i < lines.length; i++) {
            final String line = lines[i];

            if (line.isEmpty()) {
                continue;
            }
            else if (line.endsWith(";") || line.endsWith("{") || line.endsWith("}")) {
                continue;
            }

            lines[i] = line + ';' + System.lineSeparator();
        }

        final StringBuilder grammaticalSourceBuilder = new StringBuilder();
        for (String line : lines) {
            grammaticalSourceBuilder.append(line);
        }

        return grammaticalSourceBuilder.toString();
    }

}
