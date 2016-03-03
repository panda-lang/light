package org.panda_lang.light.core.element.expression;

import org.panda_lang.panda.core.syntax.Factor;

import java.util.ArrayList;
import java.util.Collection;

public class ExpressionUtils {

    public static Factor[] toFactors(Collection<ExpressionRuntime> expressionRuntimes) {
        Collection<Factor> factorCollection = new ArrayList<>(expressionRuntimes.size());
        for (ExpressionRuntime expressionRuntime : expressionRuntimes) {
            factorCollection.add(expressionRuntime.toFactor());
        }

        final Factor[] array = new Factor[factorCollection.size()];
        return factorCollection.toArray(array);
    }

}
