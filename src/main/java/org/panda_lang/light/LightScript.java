package org.panda_lang.light;

import org.panda_lang.light.lang.block.CommandBlock;
import org.panda_lang.light.lang.block.EventBlock;
import org.panda_lang.light.lang.block.FunctionBlock;
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
    private final Map<String, Collection<EventBlock>> eventBlockMap;
    private final Map<String, CommandBlock> commandBlockMap;
    private final Map<String, FunctionBlock> functionBlockMap;

    public LightScript(Light light) {
        super(light.getPanda());

        this.light = light;
        this.eventBlockMap = new HashMap<>();
        this.commandBlockMap = new HashMap<>();
        this.functionBlockMap = new HashMap<>();
    }

    public void registerEventBlock(EventBlock eventBlock) {
        Collection<EventBlock> eventBlocks = eventBlockMap.get(eventBlock.getEventName());
        if (eventBlocks == null) {
            eventBlocks = new ArrayList<>(1);
        }
        eventBlocks.add(eventBlock);
        eventBlockMap.put(eventBlock.getEventName(), eventBlocks);
    }

    public void registerCommandBlock(CommandBlock commandBlock) {
        commandBlockMap.put(commandBlock.getCommandName(), commandBlock);
    }

    public void registerFunctionBlock(FunctionBlock functionBlock) {
        functionBlockMap.put(functionBlock.getFunctionName(), functionBlock);
    }

    public void callEvent(String eventName, Factor... factors) {
        Collection<EventBlock> eventBlocks = eventBlockMap.get(eventName);
        if (eventBlocks != null) {
            Particle particle = new Particle()
                    .pandaScript(this)
                    .factors(factors);

            for (EventBlock eventBlock : eventBlocks) {
                particle.memory(new Memory());
                eventBlock.run(particle);
            }
        }
    }

    public Essence callFunction(String functionName, Factor... factors) {
        FunctionBlock functionBlock = functionBlockMap.get(functionName);
        if (functionBlock == null) {
            return null;
        }

        Particle particle = new Particle()
                .pandaScript(this)
                .memory(new Memory())
                .factors(factors);

        return functionBlock.run(particle);
    }

    public Map<String, CommandBlock> getCommandBlockMap() {
        return commandBlockMap;
    }

    public Map<String, FunctionBlock> getFunctionBlockMap() {
        return functionBlockMap;
    }

    public Map<String, Collection<EventBlock>> getEventBlockMap() {
        return eventBlockMap;
    }

    public PandaScript getPandaScript() {
        return this;
    }

    public Light getLight() {
        return light;
    }

}
