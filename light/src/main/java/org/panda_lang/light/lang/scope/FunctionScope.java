package org.panda_lang.light.lang.scope;

public class FunctionScope extends org.panda_lang.light.core.element.scope.Scope {

    private final String functionName;

    public FunctionScope(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
    }

    @Override
    public boolean isReturned() {
        return true;
    }

    @Override
    public String getName() {
        return getFunctionName();
    }

}
