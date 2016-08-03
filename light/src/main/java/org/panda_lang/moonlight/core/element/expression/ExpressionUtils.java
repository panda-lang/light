package org.panda_lang.moonlight.core.element.expression;

import org.panda_lang.panda.core.statement.RuntimeValue;

import java.util.ArrayList;
import java.util.Collection;

public class ExpressionUtils {

    public static RuntimeValue[] toFactors(Collection<ExpressionRuntime> expressionRuntimes) {
        Collection<RuntimeValue> runtimeValueCollection = new ArrayList<>(expressionRuntimes.size());
        for (ExpressionRuntime expressionRuntime : expressionRuntimes) {
            if (expressionRuntime == null) {
                continue;
            }
            runtimeValueCollection.add(expressionRuntime.toFactor());
        }

        final RuntimeValue[] array = new RuntimeValue[runtimeValueCollection.size()];
        return runtimeValueCollection.toArray(array);
    }

}
