package net.dzikoysk.lightmc.core.command;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.lang.scope.CommandScope;
import org.panda_lang.light.LightScript;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.memory.Global;
import org.panda_lang.panda.core.statement.Executable;
import org.panda_lang.panda.core.statement.block.PandaBlock;
import org.panda_lang.panda.core.statement.util.ExecutableCell;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BukkitCommandCenter {

    private final Light light;
    private final Map<String, BukkitCommand> commands;

    public BukkitCommandCenter(Light light) {
        this.light = light;
        this.commands = new HashMap<>();
    }

    public void registerCommands() {
        Collection<LightScript> lightScripts = light.getLightCore().getScripts();

        for (LightScript lightScript : lightScripts) {
            Alice alice = new Alice(lightScript, Global.COMMON_MEMORY, null, null);
            org.panda_lang.light.core.Ray ray = new org.panda_lang.light.core.Ray();

            ray.script(lightScript);
            ray.particle(alice);

            for (PandaBlock pandaBlock : lightScript.getElements()) {
                for (ExecutableCell executableCell : pandaBlock.getExecutableCells()) {
                    Executable executable = executableCell.getExecutable();

                    if (executable instanceof CommandScope) {
                        CommandScope commandScope = (CommandScope) executable;
                        BukkitCommand bukkitCommand = new BukkitCommand(commandScope, ray);
                        bukkitCommand.register();
                    }
                }
            }
        }
    }

    public Map<String, BukkitCommand> getCommands() {
        return commands;
    }

    public Light getLight() {
        return light;
    }

}
