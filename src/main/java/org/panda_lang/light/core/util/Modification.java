package org.panda_lang.light.core.util;

import org.panda_lang.light.core.Ray;

public class Modification {

    private final Ray ray;
    private final ModificationType type;
    private final ExpressionRuntime instance;
    private final ExpressionRuntime value;

    public Modification(Ray ray, ModificationType modificationType, ExpressionRuntime instance, ExpressionRuntime value) {
        this.ray = ray;
        this.type = ray.getModificationType();
        this.instance = instance;
        this.value = value;
    }

    public ExpressionRuntime getValue() {
        return value;
    }

    public ExpressionRuntime getInstance() {
        return instance;
    }

    public ModificationType getType() {
        return type;
    }

    public Ray getRay() {
        return ray;
    }

}
