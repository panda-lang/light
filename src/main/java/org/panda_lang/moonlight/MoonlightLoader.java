package org.panda_lang.moonlight;

import org.panda_lang.moonlight.core.parser.util.LightCodeUtils;
import org.panda_lang.moonlight.lang.scope.EventScope;
import org.panda_lang.moonlight.lang.scope.FunctionScope;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.PandaParser;
import org.panda_lang.panda.core.parser.util.Injection;
import org.panda_lang.panda.core.statement.Executable;
import org.panda_lang.panda.util.IOUtils;

import java.io.File;

public class MoonlightLoader {

    public final MoonlightCore moonlightCore;

    public MoonlightLoader(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    public MoonlightScript load(File file) {
        if (!file.exists()) {
            System.out.println("[MoonlightLoader::load] File '" + file + "' doesn't exist");
            return null;
        }

        final String content = IOUtils.getContentOfFile(file);
        if (content == null) {
            System.out.println("[MoonlightLoader::load] Source is null");
            return null;
        }

        return load(IOUtils.getContentOfFile(file));
    }

    public MoonlightScript load(String source) {
        if (source == null) {
            System.out.println("[MoonlightLoader::load] Source is null");
            return null;
        }

        final Panda panda = moonlightCore.getPanda();
        final MoonlightScript moonlightScript = new MoonlightScript(moonlightCore);

        final String grammaticalSource = LightCodeUtils.convert(source);
        final PandaParser pandaParser = new PandaParser(panda, moonlightScript, grammaticalSource);

        pandaParser.addInjection(new Injection() {
            @Override
            public void call(Atom atom, Executable executable) {
                if (executable instanceof EventScope) {
                    moonlightScript.registerEventBlock((EventScope) executable);
                }
                else if (executable instanceof FunctionScope) {
                    moonlightScript.registerFunctionBlock((FunctionScope) executable);
                }
            }
        });

        pandaParser.parse();
        return moonlightScript;
    }

}
