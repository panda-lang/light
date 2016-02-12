package org.panda_lang.light.core.block;

import org.panda_lang.light.Light;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;

public class EventBlock extends Block {

    private final String eventName;

    public EventBlock(Atom atom) {
        this.eventName = atom.getBlockInfo().getSpecifiers().get(0);
    }

    public String getEventName() {
        return eventName;
    }

    @Override
    public String getName() {
        return getEventName();
    }

    public static void initialize(final Light light) {
        BlockLayout blockLayout = new BlockLayout(EventBlock.class, "on", "event");
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                EventBlock eventBlock = new EventBlock(atom);
                light.getEventsCollector().registerEventBlock(eventBlock);
                return eventBlock;
            }
        });
        light.registerBlock(blockLayout);
    }

}
