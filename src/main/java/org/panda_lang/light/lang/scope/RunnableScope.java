package org.panda_lang.light.lang.scope;

import org.panda_lang.light.Light;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.element.expression.ExpressionRuntime;
import org.panda_lang.light.core.element.scope.Scope;
import org.panda_lang.light.core.parser.ExpressionParser;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;

public class RunnableScope extends Scope {

    public RunnableScope(String name) {
        super.setName(name);
    }

    public static void initialize(final Light light) {
        BlockLayout blockLayout = new BlockLayout(RunnableScope.class, "runnable");
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                String phrase = atom.getBlockInfo().getSpecifiersAsPhrase();
                ExpressionParser expressionParser = new ExpressionParser(light);
                ExpressionRuntime condition = expressionParser.parse(atom, phrase);
                String name = condition.run(new Ray()).toString();
                return new RunnableScope(name);
            }
        });
    }

}
