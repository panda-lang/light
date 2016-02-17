package org.panda_lang.light.core.block;

import org.panda_lang.light.Light;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;

public class CommandBlock extends LightBlock {

    private final String commandName;

    public CommandBlock(Atom atom) {
        this.commandName = atom.getBlockInfo().getSpecifiers().get(0);
    }

    public String getCommandName() {
        return commandName;
    }

    @Override
    public String getName() {
        return getCommandName();
    }

    public static void initialize(final Light light) {
        BlockLayout blockLayout = new BlockLayout(CommandBlock.class, "command");
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                CommandBlock commandBlock = new CommandBlock(atom);
                light.getCommandsCollector().registerCommandBlock(commandBlock);
                return commandBlock;
            }
        });
        light.registerBlock(blockLayout);
    }

}
