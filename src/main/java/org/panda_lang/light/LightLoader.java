package org.panda_lang.light;

import org.panda_lang.light.core.LightCore;
import org.panda_lang.light.core.block.CommandBlock;
import org.panda_lang.light.core.block.EventBlock;
import org.panda_lang.light.core.block.FunctionBlock;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.PandaParser;
import org.panda_lang.panda.core.parser.util.Injection;
import org.panda_lang.panda.core.syntax.NamedExecutable;
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

        final LightScript lightScript = new LightScript(lightCore.getLight());
        final PandaParser pandaParser = new PandaParser(panda, lightScript, grammaticalSource);

        pandaParser.addInjection(new Injection() {
            @Override
            public void call(Atom atom, NamedExecutable namedExecutable) {
                if (namedExecutable instanceof EventBlock) {
                    lightScript.registerEventBlock((EventBlock) namedExecutable);
                }
                else if (namedExecutable instanceof FunctionBlock) {
                    lightScript.registerFunctionBlock((FunctionBlock) namedExecutable);
                }
                else if (namedExecutable instanceof CommandBlock) {
                    lightScript.registerCommandBlock((CommandBlock) namedExecutable);
                }
            }
        });

        pandaParser.parse();
        return lightScript;
    }

}
