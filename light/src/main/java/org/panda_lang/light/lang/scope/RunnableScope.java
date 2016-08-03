package org.panda_lang.light.lang.scope;

import org.panda_lang.light.LightCore;
import org.panda_lang.panda.core.parser.ParserInfo;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.statement.Block;

public class RunnableScope extends org.panda_lang.light.core.element.scope.Scope {

    public RunnableScope(String name) {
        super.setName(name);
    }

    public static void initialize(final LightCore light) {
        BlockLayout blockLayout = new BlockLayout(org.panda_lang.light.lang.scope.RunnableScope.class, "runnable");
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(ParserInfo parserInfo) {
                String phrase = parserInfo.getBlockInfo().getSpecifiersAsPhrase();
                org.panda_lang.light.core.parser.ExpressionParser expressionParser = new org.panda_lang.light.core.parser.ExpressionParser(light);
                org.panda_lang.light.core.element.expression.ExpressionRuntime condition = expressionParser.parse(parserInfo, phrase);
                String name = condition.get(new org.panda_lang.light.core.Ray()).toString();
                return new org.panda_lang.light.lang.scope.RunnableScope(name);
            }
        });
    }

}
