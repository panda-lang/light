package org.panda_lang.light.core.parser.essential.assistant;

import org.panda_lang.light.core.parser.Expression;
import org.panda_lang.light.core.parser.util.HollowPattern;
import org.panda_lang.panda.util.documentation.Documentation;

import java.util.ArrayList;
import java.util.Collection;

public class ExpressionRepresentation {

    private final Expression expression;
    private final Collection<HollowPattern> patterns;
    private final Documentation documentation;

    public ExpressionRepresentation(Expression expression) {
        this.expression = expression;
        this.patterns = new ArrayList<>(1);
        this.documentation = new Documentation();
    }

    public ExpressionRepresentation pattern(String expression) {
        return pattern(new HollowPattern(patterns.size(), expression));
    }

    public ExpressionRepresentation pattern(HollowPattern hollowPattern) {
        patterns.add(hollowPattern);
        return this;
    }

    public Documentation documentation() {
        return documentation;
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    public Collection<HollowPattern> getPatterns() {
        return patterns;
    }

    public Expression getExpression() {
        return expression;
    }

}
