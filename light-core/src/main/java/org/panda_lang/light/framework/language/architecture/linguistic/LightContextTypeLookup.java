package org.panda_lang.light.framework.language.architecture.linguistic;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.ContextComponent;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class LightContextTypeLookup {

    protected final LightContext lightContext;

    protected LightContextTypeLookup(LightContext lightContext) {
        this.lightContext = lightContext;
    }

    protected @Nullable Type<?> getType(Predicate<Type<?>> condition) {
        return getType(getTypes(), condition);
    }

    private @Nullable Type<?> getType(Collection<ContextComponent<? extends Type<?>>> types, Predicate<Type<?>> condition) {
        for (ContextComponent<? extends Type<?>> type : types) {
            Type<?> matched = getType(type, condition);

            if (matched != null) {
                return matched;
            }
        }

        return null;
    }

    private @Nullable Type<?> getType(ContextComponent<? extends Type<?>> types, Predicate<Type<?>> condition) {
        for (Type<?> element : types.getElements()) {
            if (condition.test(element)) {
                return element;
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private Collection<ContextComponent<? extends Type<?>>> getTypes() {
        return lightContext.context.stream()
                .filter(component -> component.getComponentType() == Type.class)
                .map(component -> (ContextComponent<? extends Type<?>>) component)
                .collect(Collectors.toList());
    }

}
