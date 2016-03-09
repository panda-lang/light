package org.panda_lang.light.core.element.expression;

import java.util.ArrayList;
import java.util.Collection;

public class ExpressionCenter {

    private final Collection<ExpressionRepresentation> elements;
    private final Collection<ExpressionRepresentation> initializables;

    public ExpressionCenter() {
        this.elements = new ArrayList<>();
        this.initializables = new ArrayList<>();
    }

    public void registerElement(ExpressionRepresentation element) {
        if (element.getExpressionType() == ExpressionType.INITIALIZABLE) {
            initializables.add(element);
        }
        elements.add(element);
    }

    public Collection<ExpressionRepresentation> getInitializables() {
        return initializables;
    }

    public Collection<ExpressionRepresentation> getElements() {
        return elements;
    }

}
