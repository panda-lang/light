package org.panda_lang.light;

import org.panda_lang.light.core.block.CommandBlock;
import org.panda_lang.light.core.block.EventBlock;
import org.panda_lang.light.core.block.FunctionBlock;
import org.panda_lang.light.core.block.LoopBlock;
import org.panda_lang.light.core.parser.essential.PhraseParser;
import org.panda_lang.panda.core.parser.essential.BlockParser;

public class LightBasis {

    private final Light light;

    public LightBasis(Light light) {
        this.light = light;
    }

    public void loadParsers() {
        BlockParser.initialize(light.getPanda());
        PhraseParser.initialize(light);
    }

    public void loadBlocks() {
        CommandBlock.initialize(light);
        EventBlock.initialize(light);
        FunctionBlock.initialize(light);
        LoopBlock.initialize(light);
    }

    public Light getLight() {
        return light;
    }

}
