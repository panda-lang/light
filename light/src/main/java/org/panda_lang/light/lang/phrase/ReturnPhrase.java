package org.panda_lang.light.lang.phrase;

import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.statement.Block;
import org.panda_lang.panda.core.statement.Return;
import org.panda_lang.panda.core.statement.RuntimeValue;

public class ReturnPhrase implements org.panda_lang.light.core.element.phrase.Phrase {

    @Override
    public void run(org.panda_lang.light.core.Ray ray) {
        org.panda_lang.light.core.element.expression.ExpressionRuntime result = null;
        if (ray.getExpressionRuntimes().size() > 0) {
            result = ray.getExpressionRuntimes().get(0);
        }

        Alice alice = ray.getAlice();
        Block block = new Block(alice.getBlock());
        alice.getMemory().getParent().getCache().proceed(false);

        RuntimeValue runtimeValue = result != null ? result.toFactor() : null;
        Return returnElement = new Return(block, runtimeValue);
        block.addExecutable(returnElement);
        block.execute(alice);
    }

}
