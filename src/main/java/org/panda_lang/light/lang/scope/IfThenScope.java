package org.panda_lang.light.lang.scope;

import org.panda_lang.light.Light;
import org.panda_lang.light.core.element.scope.Scope;
import org.panda_lang.light.core.parser.ExpressionParser;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;
import org.panda_lang.panda.lang.BooleanEssence;

public class IfThenScope extends Scope {

    private final Factor factor;
    private ElseThenScope elseThenScope;

    public IfThenScope(Factor factor) {
        this.factor = factor;
    }

    @Override
    public Essence run(Particle particle) {
        if (factor.<BooleanEssence>getValue(particle).isTrue()) {
            return super.run(particle);
        }
        else if (elseThenScope != null) {
            elseThenScope.run(particle);
        }
        return null;
    }

    public void setElseThenScope(ElseThenScope elseThenScope) {
        this.elseThenScope = elseThenScope;
    }

    public static void initialize(final Light light) {
        BlockLayout blockLayout = new BlockLayout(IfThenScope.class, "if");
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                String phrase = atom.getBlockInfo().getSpecifiersAsPhrase();
                ExpressionParser expressionParser = new ExpressionParser(light);
                Factor factor = expressionParser.parse(atom, phrase).toFactor();
                return new IfThenScope(factor);
            }
        });
    }

}
