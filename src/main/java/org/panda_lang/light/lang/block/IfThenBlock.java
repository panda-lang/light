package org.panda_lang.light.lang.block;

import org.panda_lang.light.Light;
import org.panda_lang.light.core.parser.ExpressionParser;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;
import org.panda_lang.panda.lang.BooleanEssence;

public class IfThenBlock extends LightBlock {

    private final Factor factor;
    private ElseThenBlock elseThenBlock;

    public IfThenBlock(Factor factor) {
        this.factor = factor;
    }

    @Override
    public Essence run(Particle particle) {
        if (factor.<BooleanEssence> getValue(particle).isTrue()) {
            return super.run(particle);
        }
        else if (elseThenBlock != null) {
            elseThenBlock.run(particle);
        }
        return null;
    }

    public void setElseThenBlock(ElseThenBlock elseThenBlock) {
        this.elseThenBlock = elseThenBlock;
    }

    public static void initialize(final Light light) {
        BlockLayout blockLayout = new BlockLayout(IfThenBlock.class, "if");
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                String phrase = atom.getBlockInfo().getSpecifiersAsPhrase();
                ExpressionParser expressionParser = new ExpressionParser(light);
                Factor factor = expressionParser.parse(atom, phrase).toFactor();
                return new IfThenBlock(factor);
            }
        });
        light.registerBlock(blockLayout);
    }

}
