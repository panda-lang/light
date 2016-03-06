package org.panda_lang.light.lang.block;

import org.panda_lang.light.Light;
import org.panda_lang.light.core.element.expression.ExpressionRuntime;
import org.panda_lang.light.core.parser.ExpressionParser;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;

public class RunnableBlock extends LightBlock {

    public RunnableBlock(String name) {
        super.setName(name);
    }

    public static void initialize(final Light light) {
        BlockLayout blockLayout = new BlockLayout(RunnableBlock.class, "runnable");
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                String phrase = atom.getBlockInfo().getSpecifiersAsPhrase();
                ExpressionParser expressionParser = new ExpressionParser(light);
                ExpressionRuntime condition = expressionParser.parse(atom, phrase);
                String name = condition.run(null).toString();
                return new RunnableBlock(name);
            }
        });
        light.registerBlock(blockLayout);
    }

}
