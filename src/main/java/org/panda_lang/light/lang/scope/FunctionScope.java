package org.panda_lang.light.lang.scope;

import org.panda_lang.light.core.element.scope.Scope;
import org.panda_lang.panda.core.parser.Atom;

public class FunctionScope extends Scope {

    private final String functionName;

    public FunctionScope(Atom atom) {
        this.functionName = atom.getBlockInfo().getSpecifiers().get(0);
    }

    public String getFunctionName() {
        return functionName;
    }

    @Override
    public String getName() {
        return getFunctionName();
    }

}
