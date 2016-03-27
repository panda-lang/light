package org.panda_lang.moonlight.lang.phrase;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.element.phrase.Phrase;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.statement.Block;
import org.panda_lang.panda.core.statement.Factor;
import org.panda_lang.panda.core.statement.Return;

public class ReturnPhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        ExpressionRuntime result = null;
        if (ray.getExpressionRuntimes().size() > 0) {
            result = ray.getExpressionRuntimes().get(0);
        }

        Alice alice = ray.getAlice();
        Block block = new Block(alice.getBlock());

        Factor factor = result != null ? result.toFactor() : null;
        Return returnElement = new Return(block, factor);
        block.addExecutable(returnElement);
        block.run(alice);
    }

}
