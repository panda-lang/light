package org.panda_lang.light;

import org.panda_lang.core.util.IOUtils;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.parser.PandaParser;
import org.panda_lang.panda.core.parser.ParserInfo;
import org.panda_lang.panda.core.parser.util.Injection;
import org.panda_lang.panda.core.statement.Executable;

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
        final LightScript lightScript = new LightScript(lightCore);

        final String grammaticalSource = org.panda_lang.light.core.parser.util.LightCodeUtils.convert(source);
        final PandaParser pandaParser = new PandaParser(panda, lightScript, grammaticalSource);

        pandaParser.addInjection(new Injection() {
            @Override
            public void call(ParserInfo parserInfo, Executable executable) {
                if (executable instanceof org.panda_lang.light.lang.scope.EventScope) {
                    lightScript.registerEventBlock((org.panda_lang.light.lang.scope.EventScope) executable);
                }
                else if (executable instanceof org.panda_lang.light.lang.scope.FunctionScope) {
                    lightScript.registerFunctionBlock((org.panda_lang.light.lang.scope.FunctionScope) executable);
                }
            }
        });

        pandaParser.parse();
        return lightScript;
    }

}
