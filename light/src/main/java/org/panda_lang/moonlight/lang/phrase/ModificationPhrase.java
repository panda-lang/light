package org.panda_lang.moonlight.lang.phrase;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.element.phrase.Phrase;
import org.panda_lang.moonlight.core.util.ModificationType;
import org.panda_lang.moonlight.core.util.Modification;

public class ModificationPhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        ExpressionRuntime expressionRuntime = ray.getExpressionRuntimes().get(0);
        Expression expression = expressionRuntime.getExpression();

        Modification modification;
        switch (ray.getModificationType()) {
            case ModificationType.ADD:
                modification = new Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(1), ray.getExpressionRuntimes().get(0));
                break;
            case ModificationType.SET:
                modification = new Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(0), ray.getExpressionRuntimes().get(1));
                break;
            case ModificationType.REMOVE:
                modification = new Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(1), ray.getExpressionRuntimes().get(0));
                break;
            case ModificationType.DELETE:
                modification = new Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(0), null);
                break;
            default:
                modification = null;
                break;
        }

        expression.modify(modification);
    }

}
