package org.panda_lang.light;

import org.panda_lang.light.core.LightCore;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.PandaScript;
import org.panda_lang.panda.util.IOUtils;

import java.io.File;

public class LightLoader {

    public final LightCore lightCore;

    public LightLoader(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public LightScript load(File file) {
        return load(IOUtils.getContentOfFile(file));
    }

    public LightScript load(String source) {
        Panda panda = lightCore.getPanda();

        String[] lines = source.split(System.lineSeparator());
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            if (line.isEmpty()) {
                continue;
            }
            else if (line.endsWith(";") || line.endsWith("{") || line.endsWith("}")) {
                continue;
            }

            lines[i] = line + ';' + System.lineSeparator();
        }

        StringBuilder grammaticalSourceBuilder = new StringBuilder();
        for (String line : lines) {
            grammaticalSourceBuilder.append(line);
        }

        String grammaticalSource = grammaticalSourceBuilder.toString();
        PandaScript pandaScript = panda.getPandaLoader().loadSimpleScript(grammaticalSource);
        return new LightScript(pandaScript);
    }

}
