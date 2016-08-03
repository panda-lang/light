package org.panda_lang.light.core.util;

public class Modification {

    private final org.panda_lang.light.core.Ray ray;
    private final ModificationType type;
    private final org.panda_lang.light.core.element.expression.ExpressionRuntime instance;
    private final org.panda_lang.light.core.element.expression.ExpressionRuntime value;

    public Modification(org.panda_lang.light.core.Ray ray, org.panda_lang.light.core.element.expression.ExpressionRuntime instance, org.panda_lang.light.core.element.expression.ExpressionRuntime value) {
        this.ray = ray;
        this.type = ray.getModificationType();
        this.instance = instance;
        this.value = value;
    }

    public Modification(org.panda_lang.light.core.Ray ray, ModificationType modificationType, org.panda_lang.light.core.element.expression.ExpressionRuntime instance, org.panda_lang.light.core.element.expression.ExpressionRuntime value) {
        this.ray = ray;
        this.type = modificationType;
        this.instance = instance;
        this.value = value;
    }

    public org.panda_lang.light.core.element.expression.ExpressionRuntime getValue() {
        return value;
    }

    public org.panda_lang.light.core.element.expression.ExpressionRuntime getInstance() {
        return instance;
    }

    public ModificationType getType() {
        return type;
    }

    public org.panda_lang.light.core.Ray getRay() {
        return ray;
    }

}
