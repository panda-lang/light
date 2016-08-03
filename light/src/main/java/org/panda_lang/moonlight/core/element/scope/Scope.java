package org.panda_lang.moonlight.core.element.scope;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.argument.ArgumentRepresentation;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.statement.Block;

public class Scope extends Block {

    protected ScopeRepresentation scopeRepresentation;
    protected Object object;

    public void initializeScopeRepresentation(ScopeRepresentation scopeRepresentation) {
        this.scopeRepresentation = scopeRepresentation;
    }

    @Override
    public Inst execute(Alice alice) {
        Ray ray = alice.getCustom();
        object = ray.getScopeObject();
        return super.execute(alice);
    }

    public boolean argumentBelongsToScope(ArgumentRepresentation argumentRepresentation) {
        return true;
    }

    public Object getObject() {
        return object;
    }

    public ScopeRepresentation getScopeRepresentation() {
        return scopeRepresentation;
    }

}
