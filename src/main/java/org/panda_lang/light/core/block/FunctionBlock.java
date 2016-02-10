package org.panda_lang.light.core.block;

import org.panda_lang.light.Light;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;

public class FunctionBlock extends Block {

    private final String functionName;

    public FunctionBlock(Atom atom) {
        this.functionName = atom.getBlockInfo().getSpecifiers().get(0);
    }

    public String getFunctionName() {
        return functionName;
    }

    @Override
    public String getName() {
        return getFunctionName();
    }

    public static void initialize(final Light light) {
        BlockLayout blockLayout = new BlockLayout(EventBlock.class, false, "function").initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                FunctionBlock functionBlock = new FunctionBlock(atom);
                light.getFunctionsCollector().registerFunctionBlock(functionBlock);
                return functionBlock;
            }
        });
        light.getPanda().getPandaCore().registerBlock(blockLayout);
    }

}
