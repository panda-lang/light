package net.dzikoysk.moonlight.core.command;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.lang.scope.CommandScope;
import org.panda_lang.moonlight.MoonlightScript;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.memory.Global;
import org.panda_lang.panda.core.statement.Executable;
import org.panda_lang.panda.core.statement.block.PandaBlock;
import org.panda_lang.panda.core.statement.util.ExecutableCell;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BukkitCommandCenter {

    private final Moonlight moonlight;
    private final Map<String, BukkitCommand> commands;

    public BukkitCommandCenter(Moonlight moonlight) {
        this.moonlight = moonlight;
        this.commands = new HashMap<>();
    }

    public void registerCommands() {
        Collection<MoonlightScript> moonlightScripts = moonlight.getMoonlightCore().getScripts();

        for (MoonlightScript moonlightScript : moonlightScripts) {
            Alice alice = new Alice(moonlightScript, Global.COMMON_MEMORY, null, null);
            Ray ray = new Ray();

            ray.script(moonlightScript);
            ray.particle(alice);

            for (PandaBlock pandaBlock : moonlightScript.getElements()) {
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

    public Moonlight getMoonlight() {
        return moonlight;
    }

}
