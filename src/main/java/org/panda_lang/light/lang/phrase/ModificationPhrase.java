package org.panda_lang.light.lang.phrase;

import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.element.expression.Expression;
import org.panda_lang.light.core.element.expression.ExpressionRuntime;
import org.panda_lang.light.core.element.phrase.Phrase;
import org.panda_lang.light.core.util.Modification;

public class ModificationPhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        ExpressionRuntime expressionRuntime = ray.getExpressionRuntimes().get(0);
        Expression expression = expressionRuntime.getExpression();

        Modification modification;
        switch (ray.getModificationType()) {
            case ADD:
                modification = new Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(1), ray.getExpressionRuntimes().get(0));
                break;
            case SET:
                modification = new Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(0), ray.getExpressionRuntimes().get(1));
                break;
            case REMOVE:
                modification = new Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(1), ray.getExpressionRuntimes().get(0));
                break;
            case DELETE:
                modification = new Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(0), null);
                break;
            default:
                modification = null;
                break;
        }

        expression.modify(modification);
    }

}
