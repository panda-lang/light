package org.panda_lang.light.core.block;

import org.panda_lang.light.Light;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;

public class ElseThenBlock extends Block {

    public static void initialize(final Light light) {
        BlockLayout blockLayout = new BlockLayout(IfThenBlock.class, false, "else");
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                ElseThenBlock elseThenBlock = new ElseThenBlock();
                Block previous = atom.getPrevious();
                if (previous instanceof IfThenBlock) {
                    ((IfThenBlock) previous).setElseThenBlock(elseThenBlock);
                }
                return elseThenBlock;
            }
        });
        light.registerBlock(blockLayout);
    }

}
