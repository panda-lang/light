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

    public int getID() {
        return id;
    }

    public static ModificationType valueOf(int id) {
        for (ModificationType modificationType : values()) {
            if (modificationType.getID() == id) {
                return modificationType;
            }
        }
        return SET;
    }

}
