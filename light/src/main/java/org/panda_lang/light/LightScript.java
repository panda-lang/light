package org.panda_lang.light;

import org.panda_lang.panda.PandaScript;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.memory.Memory;
import org.panda_lang.panda.core.statement.RuntimeValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LightScript extends PandaScript {

    private final LightCore light;
    private final Map<String, Collection<org.panda_lang.light.lang.scope.EventScope>> eventBlockMap;
    private final Map<String, org.panda_lang.light.lang.scope.FunctionScope> functionBlockMap;

    public LightScript(LightCore light) {
        super(light.getPanda());

        this.light = light;
        this.eventBlockMap = new HashMap<>();
        this.functionBlockMap = new HashMap<>();
    }

    public void callEvent(String eventName, Object object) {
        Collection<org.panda_lang.light.lang.scope.EventScope> eventScopes = eventBlockMap.get(eventName);
        if (eventScopes != null) {
            for (org.panda_lang.light.lang.scope.EventScope eventScope : eventScopes) {
                callEvent(eventScope, object);
            }
        }
    }

    public void callEvent(org.panda_lang.light.lang.scope.EventScope eventScope, Object object) {
        org.panda_lang.light.core.Ray ray = getAssociatedRay().scopeObject(object);
        eventScope.execute(ray.getAlice());
    }

    public Inst callFunction(String functionName, RuntimeValue... runtimeValues) {
        org.panda_lang.light.lang.scope.FunctionScope functionScope = functionBlockMap.get(functionName);
        if (functionScope == null) {
            return null;
        }

        org.panda_lang.light.core.Ray ray = getAssociatedRay().factors(runtimeValues);
        return functionScope.execute(ray.getAlice());
    }

    public void registerEventBlock(org.panda_lang.light.lang.scope.EventScope eventScope) {
        Collection<org.panda_lang.light.lang.scope.EventScope> eventScopes = eventBlockMap.get(eventScope.getEventName());
        if (eventScopes == null) {
            eventScopes = new ArrayList<>(1);
        }

        eventScopes.add(eventScope);
        eventBlockMap.put(eventScope.getEventName(), eventScopes);
    }

    public void registerFunctionBlock(org.panda_lang.light.lang.scope.FunctionScope functionScope) {
        functionBlockMap.put(functionScope.getFunctionName(), functionScope);
    }

    public org.panda_lang.light.core.Ray getAssociatedRay() {
        Alice alice = new Alice(this, new Memory(), null, null);
        return new org.panda_lang.light.core.Ray(alice);
    }

    public Map<String, org.panda_lang.light.lang.scope.FunctionScope> getFunctionBlockMap() {
        return functionBlockMap;
    }

    public Map<String, Collection<org.panda_lang.light.lang.scope.EventScope>> getEventBlockMap() {
        return eventBlockMap;
    }

    public PandaScript getPandaScript() {
        return this;
    }

    public LightCore getLight() {
        return light;
    }

}
