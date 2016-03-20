package org.panda_lang.light;

import org.panda_lang.light.core.parser.util.LightCodeUtils;
import org.panda_lang.light.lang.scope.CommandScope;
import org.panda_lang.light.lang.scope.EventScope;
import org.panda_lang.light.lang.scope.FunctionScope;
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
        if (!file.exists()) {
            System.out.println("[LightLoader::load] File '" + file + "' doesn't exist");
            return null;
        }

        final String content = IOUtils.getContentOfFile(file);
        if (content == null) {
            System.out.println("[LightLoader::load] Source is null");
            return null;
        }

        return load(IOUtils.getContentOfFile(file));
    }

    public LightScript load(String source) {
        if (source == null) {
            System.out.println("[LightLoader::load] Source is null");
            return null;
        }

        final Panda panda = lightCore.getPanda();
        final LightScript lightScript = new LightScript(lightCore.getLight());

        final String grammaticalSource = LightCodeUtils.convert(source);
        final PandaParser pandaParser = new PandaParser(panda, lightScript, grammaticalSource);

        pandaParser.addInjection(new Injection() {
            @Override
            public void call(Atom atom, NamedExecutable namedExecutable) {
                if (namedExecutable instanceof EventScope) {
                    lightScript.registerEventBlock((EventScope) namedExecutable);
                }
                else if (namedExecutable instanceof FunctionScope) {
                    lightScript.registerFunctionBlock((FunctionScope) namedExecutable);
                }
                else if (namedExecutable instanceof CommandScope) {
                    lightScript.registerCommandBlock((CommandScope) namedExecutable);
                }
                else {
                    atom.getParent().addExecutable(namedExecutable);
                }
            }
        });

        pandaParser.parse();
        return lightScript;
    }

}
