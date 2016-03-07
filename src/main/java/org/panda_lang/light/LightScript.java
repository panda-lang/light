package org.panda_lang.light;

import org.panda_lang.light.lang.scope.CommandScope;
import org.panda_lang.light.lang.scope.EventScope;
import org.panda_lang.light.lang.scope.FunctionScope;
import org.panda_lang.panda.PandaScript;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.memory.Memory;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LightScript extends PandaScript {

    private final Light light;
    private final Map<String, Collection<EventScope>> eventBlockMap;
    private final Map<String, CommandScope> commandBlockMap;
    private final Map<String, FunctionScope> functionBlockMap;

    public LightScript(Light light) {
        super(light.getPanda());

        this.light = light;
        this.eventBlockMap = new HashMap<>();
        this.commandBlockMap = new HashMap<>();
        this.functionBlockMap = new HashMap<>();
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

    public void callEvent(String eventName, Factor... factors) {
        Collection<EventScope> eventScopes = eventBlockMap.get(eventName);
        if (eventScopes != null) {
            Particle particle = new Particle()
                    .pandaScript(this)
                    .factors(factors);

            for (EventScope eventScope : eventScopes) {
                particle.memory(new Memory());
                eventScope.run(particle);
            }
        }
    }

    public Essence callFunction(String functionName, Factor... factors) {
        FunctionScope functionScope = functionBlockMap.get(functionName);
        if (functionScope == null) {
            return null;
        }

        Particle particle = new Particle()
                .pandaScript(this)
                .memory(new Memory())
                .factors(factors);

        return functionScope.run(particle);
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

    public Light getLight() {
        return light;
    }

}
