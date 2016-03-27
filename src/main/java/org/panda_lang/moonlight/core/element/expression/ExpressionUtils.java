package org.panda_lang.moonlight.core.element.expression;

import org.panda_lang.panda.core.statement.Factor;

import java.util.ArrayList;
import java.util.Collection;

public class ExpressionUtils {

    public static Factor[] toFactors(Collection<ExpressionRuntime> expressionRuntimes) {
        Collection<Factor> factorCollection = new ArrayList<>(expressionRuntimes.size());
        for (ExpressionRuntime expressionRuntime : expressionRuntimes) {
            if (expressionRuntime == null) {
                continue;
            }
            factorCollection.add(expressionRuntime.toFactor());
        }

        final Factor[] array = new Factor[factorCollection.size()];
        return factorCollection.toArray(array);
    }

}
