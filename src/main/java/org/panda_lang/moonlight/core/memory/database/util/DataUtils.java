package org.panda_lang.moonlight.core.memory.database.util;

public class DataUtils {

    public static byte[] intToByteArray(int value) {
        return new byte[]{
                (byte) ((value >>> 24) & 0xFF),
                (byte) ((value >> 16) & 0xFF),
                (byte) ((value >> 8) & 0xFF),
                (byte) ((value) & 0xFF)};
    }

}
