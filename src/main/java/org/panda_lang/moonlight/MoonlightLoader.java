package org.panda_lang.moonlight;

import org.panda_lang.moonlight.core.parser.util.LightCodeUtils;
import org.panda_lang.moonlight.lang.scope.CommandScope;
import org.panda_lang.moonlight.lang.scope.EventScope;
import org.panda_lang.moonlight.lang.scope.FunctionScope;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.PandaParser;
import org.panda_lang.panda.core.parser.util.Injection;
import org.panda_lang.panda.core.syntax.NamedExecutable;
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
        final MoonlightScript moonlightScript = new MoonlightScript(moonlightCore.getMoonlight());

        final String grammaticalSource = LightCodeUtils.convert(source);
        final PandaParser pandaParser = new PandaParser(panda, moonlightScript, grammaticalSource);

        pandaParser.addInjection(new Injection() {
            @Override
            public void call(Atom atom, NamedExecutable namedExecutable) {
                if (namedExecutable instanceof EventScope) {
                    moonlightScript.registerEventBlock((EventScope) namedExecutable);
                }
                else if (namedExecutable instanceof FunctionScope) {
                    moonlightScript.registerFunctionBlock((FunctionScope) namedExecutable);
                }
                else if (namedExecutable instanceof CommandScope) {
                    moonlightScript.registerCommandBlock((CommandScope) namedExecutable);
                }
                else {
                    atom.getParent().addExecutable(namedExecutable);
                }
            }
        });

        pandaParser.parse();
        return moonlightScript;
    }

}
