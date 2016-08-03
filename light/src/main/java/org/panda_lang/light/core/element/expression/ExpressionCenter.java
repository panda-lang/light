package org.panda_lang.light.core.element.expression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ExpressionCenter {

    private final Collection<ExpressionRepresentation> elements;
    private final Collection<ExpressionRepresentation> initializables;
    private final Map<String, ExpressionRepresentation> expressionRepresentationMap;

    public ExpressionCenter() {
        this.elements = new ArrayList<>();
        this.initializables = new ArrayList<>();
        this.expressionRepresentationMap = new HashMap<>();
    }

    public void registerElement(ExpressionRepresentation element) {
        if (element.getExpressionType() == ExpressionType.INITIALIZABLE) {
            initializables.add(element);
        }
        elements.add(element);
    }

    public Map<String, ExpressionRepresentation> getExpressionRepresentationMap() {
        return expressionRepresentationMap;
    }

    public Collection<ExpressionRepresentation> getInitializables() {
        return initializables;
    }

    public Collection<ExpressionRepresentation> getElements() {
        return elements;
    }

}
