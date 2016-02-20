package org.panda_lang.light.core.block;

import org.panda_lang.light.Light;
import org.panda_lang.light.core.parser.ExpressionParser;
import org.panda_lang.light.core.util.ExpressionRuntime;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;
import org.panda_lang.panda.lang.BooleanEssence;

public class WhileBlock extends LightBlock {

    private final Factor factor;

    public WhileBlock(Factor factor) {
        this.factor = factor;
        this.setName("while::" + atomicInteger.incrementAndGet());
    }

    @Override
    public Essence run(Particle particle) {
        while (factor.<BooleanEssence>getValue(particle).isTrue()) {
            Essence essence = super.run(particle);

            if (essence != null) {
                return essence;
            }
        }

        return null;
    }

    public static void initialize(final Light light) {
        BlockLayout blockLayout = new BlockLayout(WhileBlock.class, "while");
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                String phrase = atom.getBlockInfo().getSpecifiersAsPhrase();
                ExpressionParser expressionParser = new ExpressionParser(light);
                ExpressionRuntime condition = expressionParser.parse(atom, phrase);
                return new WhileBlock(condition.toFactor());
            }
        });
        light.registerBlock(blockLayout);
    }

}
