package org.panda_lang.light.core.util;

public enum ModificationType {

    ADD(0),
    SET(1),
    REMOVE(2),
    DELETE(3);

    private final int id;

    ModificationType(int id) {
        this.id = id;
    }

    public static org.panda_lang.light.core.util.ModificationType valueOf(int id) {
        for (org.panda_lang.light.core.util.ModificationType modificationType : values()) {
            if (modificationType.getID() == id) {
                return modificationType;
            }
        }
        return SET;
    }

    public int getID() {
        return id;
    }

}
