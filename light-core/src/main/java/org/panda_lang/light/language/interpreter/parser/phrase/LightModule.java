package org.panda_lang.light.language.interpreter.parser.phrase;

import org.panda_lang.panda.framework.design.architecture.module.Module;
import org.panda_lang.panda.framework.design.architecture.prototype.ClassPrototype;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LightModule implements Module {

    private final String moduleName;
    private final Map<String, ClassPrototype> types = new HashMap<>();

    public LightModule(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public ClassPrototype add(ClassPrototype prototype) {
        return types.put(prototype.getClassName(), prototype);
    }

    @Override
    public ClassPrototype get(String className) {
        return types.get(className);
    }

    @Override
    public int getPrototypeCount() {
        return types.size();
    }

    @Override
    public Collection<ClassPrototype> getPrototypes() {
        return types.values();
    }

    @Override
    public String getName() {
        return moduleName;
    }

}
