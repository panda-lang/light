package org.panda_lang.light;

import org.panda_lang.light.core.block.EventBlock;
import org.panda_lang.panda.PandaScript;
import org.panda_lang.panda.core.syntax.Factor;

public class LightScript {

    private final PandaScript pandaScript;

    public LightScript(PandaScript pandaScript) {
        this.pandaScript = pandaScript;
    }

    public void callEvent(String eventName, Factor... factors) {
        pandaScript.call(EventBlock.class, eventName, factors);
    }

    public PandaScript getPandaScript() {
        return pandaScript;
    }

}
