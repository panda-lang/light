package org.panda_lang.light.lang.block.collector;

import org.panda_lang.light.lang.block.FunctionBlock;

import java.util.HashMap;
import java.util.Map;

public class FunctionsCollector {

    private final Map<String, FunctionBlock> functions;

    public FunctionsCollector() {
        this.functions = new HashMap<>();
    }

    public void registerFunctionBlock(FunctionBlock functionBlock) {
        functions.put(functionBlock.getFunctionName(), functionBlock);
    }

    public Map<String, FunctionBlock> getFunctions() {
        return functions;
    }

}
