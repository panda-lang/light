package org.panda_lang.light;

import org.panda_lang.light.core.block.CommandBlock;
import org.panda_lang.light.core.block.EventBlock;
import org.panda_lang.light.core.parser.PhraseParser;
import org.panda_lang.panda.core.Basis;
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

        Basis basis = light.getPanda().getBasis();
        basis.loadBlocks();
    }

    public Light getLight() {
        return light;
    }

}
