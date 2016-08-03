package org.panda_lang.light.lang.phrase;

public class ModificationPhrase implements org.panda_lang.light.core.element.phrase.Phrase {

    @Override
    public void run(org.panda_lang.light.core.Ray ray) {
        org.panda_lang.light.core.element.expression.ExpressionRuntime expressionRuntime = ray.getExpressionRuntimes().get(0);
        org.panda_lang.light.core.element.expression.Expression expression = expressionRuntime.getExpression();

        org.panda_lang.light.core.util.Modification modification;
        switch (ray.getModificationType()) {
            case org.panda_lang.light.core.util.ModificationType.ADD:
                modification = new org.panda_lang.light.core.util.Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(1), ray.getExpressionRuntimes().get(0));
                break;
            case org.panda_lang.light.core.util.ModificationType.SET:
                modification = new org.panda_lang.light.core.util.Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(0), ray.getExpressionRuntimes().get(1));
                break;
            case org.panda_lang.light.core.util.ModificationType.REMOVE:
                modification = new org.panda_lang.light.core.util.Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(1), ray.getExpressionRuntimes().get(0));
                break;
            case org.panda_lang.light.core.util.ModificationType.DELETE:
                modification = new org.panda_lang.light.core.util.Modification(ray, ray.getModificationType(), ray.getExpressionRuntimes().get(0), null);
                break;
            default:
                modification = null;
                break;
        }

        expression.modify(modification);
    }

}
