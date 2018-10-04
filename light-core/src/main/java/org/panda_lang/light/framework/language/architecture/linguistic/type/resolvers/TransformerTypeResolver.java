package org.panda_lang.light.framework.language.architecture.linguistic.type.resolvers;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.ContextComponent;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticExpression;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticUtils;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.architecture.linguistic.type.TypeResolver;
import org.panda_lang.light.framework.design.architecture.linguistic.type.TypeTransformer;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

import java.util.Objects;

public class TransformerTypeResolver implements TypeResolver {

    @Override
    public @Nullable LinguisticAct resolve(ContextComponent<Type<?>> component, String sentence) {
        for (Type<?> type : component.getElements()) {
            LinguisticAct result = resolve(type, sentence);

            if (result != null) {
                return result;
            }
        }

        return null;
    }

    private @Nullable LinguisticAct resolve(Type<?> type, String sentence) {
        for (TypeTransformer<?> transformer : type.getTypeTransformer()) {
            Object result = transformer.transform(sentence);

            if (result == null) {
                continue;
            }

            return new TypeExpression(type, result);
        }

        return null;
    }

    private class TypeExpression implements LinguisticExpression {

        private final Type<?> type;
        private final Object value;

        private TypeExpression(Type<?> type, Object value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
            return value;
        }

        @Override
        public boolean compare(LinguisticAct another) {
            return another instanceof TypeExpression && Objects.equals(value, ((TypeExpression) another).value);
        }

        @Override
        public Type<?> getType() {
            return type;
        }

        @Override
        public Type<?>[] getParameterTypes() {
            return LinguisticUtils.TYPELESS;
        }

    }

}
