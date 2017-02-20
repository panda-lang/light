package net.dzikoysk.lightmc.util.generator.util;

public class GeneratorUtils {

    public static String transformName(String firstPart, String name, boolean spaces, String... otherParts) {
        firstPart = Character.toUpperCase(firstPart.charAt(0)) + firstPart.substring(1);
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        name = name.replace(firstPart, "");
        for (String otherPart : otherParts) {
            name = name.replace(otherPart, "");
        }
        name = Character.toLowerCase(name.charAt(0)) + name.substring(1);

        String[] parts = name.split("(?=\\p{Upper})");

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : parts) {
            if (spaces) {
                s = Character.toLowerCase(s.charAt(0)) + s.substring(1);
            }

            stringBuilder.append(s);

            if (spaces) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

}
