package org.panda_lang.moonlight;

import net.dzikoysk.moonlight.lang.scope.CommandScope;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.lang.scope.EventScope;
import org.panda_lang.moonlight.lang.scope.FunctionScope;
import org.panda_lang.panda.PandaScript;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.memory.Memory;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.core.statement.Factor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MoonlightScript extends PandaScript {

    private final MoonlightCore moonlight;
    private final Map<String, Collection<EventScope>> eventBlockMap;
    private final Map<String, CommandScope> commandBlockMap;
    private final Map<String, FunctionScope> functionBlockMap;

    public MoonlightScript(MoonlightCore moonlight) {
        super(moonlight.getPanda());

        this.moonlight = moonlight;
        this.eventBlockMap = new HashMap<>();
        this.commandBlockMap = new HashMap<>();
        this.functionBlockMap = new HashMap<>();
    }

    public void callEvent(String eventName, Object object) {
        Collection<EventScope> eventScopes = eventBlockMap.get(eventName);
        if (eventScopes != null) {
            for (EventScope eventScope : eventScopes) {
                callEvent(eventScope, object);
            }
        }
    }

    public void callEvent(EventScope eventScope, Object object) {
        Ray ray = getAssociatedRay().scopeObject(object);
        eventScope.run(ray.getAlice());
    }

    public Essence callFunction(String functionName, Factor... factors) {
        FunctionScope functionScope = functionBlockMap.get(functionName);
        if (functionScope == null) {
            return null;
        }

        Ray ray = getAssociatedRay().factors(factors);
        return functionScope.run(ray.getAlice());
    }

    public void registerEventBlock(EventScope eventScope) {
        Collection<EventScope> eventScopes = eventBlockMap.get(eventScope.getEventName());
        if (eventScopes == null) {
            eventScopes = new ArrayList<>(1);
        }

        eventScopes.add(eventScope);
        eventBlockMap.put(eventScope.getEventName(), eventScopes);
    }

    public void registerCommandBlock(CommandScope commandScope) {
        commandBlockMap.put(commandScope.getCommandName(), commandScope);
    }

    public void registerFunctionBlock(FunctionScope functionScope) {
        functionBlockMap.put(functionScope.getFunctionName(), functionScope);
    }

    public Ray getAssociatedRay() {
        Alice alice = new Alice(this, new Memory(), null, null);
        return new Ray(alice);
    }

    public Map<String, CommandScope> getCommandBlockMap() {
        return commandBlockMap;
    }

    public Map<String, FunctionScope> getFunctionBlockMap() {
        return functionBlockMap;
    }

    public Map<String, Collection<EventScope>> getEventBlockMap() {
        return eventBlockMap;
    }

    public PandaScript getPandaScript() {
        return this;
    }

    public MoonlightCore getMoonlight() {
        return moonlight;
    }

}
