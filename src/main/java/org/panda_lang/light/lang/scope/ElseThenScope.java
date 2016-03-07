package org.panda_lang.light.lang.scope;

import org.panda_lang.light.Light;
import org.panda_lang.light.core.element.scope.Scope;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;

public class ElseThenScope extends Scope {

    public static void initialize(final Light light) {
        BlockLayout blockLayout = new BlockLayout(IfThenScope.class, false, "else");
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                ElseThenScope elseThenScope = new ElseThenScope();
                Block previous = atom.getPrevious();
                if (previous instanceof IfThenScope) {
                    ((IfThenScope) previous).setElseThenScope(elseThenScope);
                }
                return elseThenScope;
            }
        });
    }

}
