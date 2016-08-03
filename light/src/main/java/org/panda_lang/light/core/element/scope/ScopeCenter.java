package org.panda_lang.light.core.element.scope;

import org.panda_lang.light.LightCore;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.PandaCore;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.statement.Block;

public class ScopeCenter extends org.panda_lang.light.core.util.Center<ScopeRepresentation> {

    private final LightCore lightCore;

    public ScopeCenter(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    @Override
    public void registerElement(ScopeRepresentation element) {
        Panda panda = lightCore.getPanda();
        PandaCore pandaCore = panda.getPandaCore();

        super.registerElement(element);
        pandaCore.registerBlock(element.getBlockLayout());
    }

    public ScopeRepresentation select(String scopeName) {
        for (ScopeRepresentation scopeRepresentation : elements) {
            BlockLayout blockLayout = scopeRepresentation.getBlockLayout();
            String[] indications = blockLayout.getIndications();

            for (String indication : indications) {
                if (indication.equals(scopeName)) {
                    return scopeRepresentation;
                }
            }
        }

        return null;
    }

    public ScopeRepresentation select(Class<? extends Block> clazz) {
        for (ScopeRepresentation scopeRepresentation : elements) {
            if (scopeRepresentation.getBlockLayout().getClazz() == clazz) {
                return scopeRepresentation;
            }
        }

        return null;
    }

}
