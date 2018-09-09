package org.panda_lang.light.framework.language.architecture.linguistic.type.resolvers;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.framework.design.architecture.linguistic.ContextComponent;
import org.panda_lang.light.framework.design.architecture.linguistic.LinguisticAct;
import org.panda_lang.light.framework.design.architecture.linguistic.type.Type;
import org.panda_lang.light.framework.design.architecture.linguistic.type.TypeResolver;
import org.panda_lang.light.framework.design.architecture.linguistic.type.TypeTransformer;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

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

            return new LinguisticAct() {
                @Override
                public Object perform(ExecutableBranch branch, LinguisticAct... parameters) {
                    return result;
                }

                @Override
                public String getType() {
                    return type.getClassName();
                }
            };
        }

        return null;
    }

}
