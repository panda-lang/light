package org.panda_lang.moonlight.lang.scope;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.element.scope.Scope;
import org.panda_lang.moonlight.core.parser.ExpressionParser;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.statement.Block;

public class RunnableScope extends Scope {

    public RunnableScope(String name) {
        super.setName(name);
    }

    public static void initialize(final MoonlightCore moonlight) {
        BlockLayout blockLayout = new BlockLayout(RunnableScope.class, "runnable");
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                String phrase = atom.getBlockInfo().getSpecifiersAsPhrase();
                ExpressionParser expressionParser = new ExpressionParser(moonlight);
                ExpressionRuntime condition = expressionParser.parse(atom, phrase);
                String name = condition.run(new Ray()).toString();
                return new RunnableScope(name);
            }
        });
    }

}
