package org.panda_lang.moonlight.core.parser;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.PandaScript;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.core.statement.Executable;
import org.panda_lang.panda.core.statement.util.NamedExecutable;
import org.panda_lang.panda.core.parser.*;
import org.panda_lang.panda.core.parser.util.match.parser.PatternExtractor;
import org.panda_lang.panda.core.statement.*;
import org.panda_lang.panda.core.statement.Runtime;
import org.panda_lang.panda.core.statement.block.PandaBlock;

public class NativeParser implements Parser {

    private final Panda panda;
    private final MoonlightCore moonlightCore;

    public NativeParser(MoonlightCore moonlightCore) {
        this.panda = new Panda();
        this.moonlightCore = moonlightCore;

        this.panda.initializeDefaultElements();
    }

    public static void initialize(MoonlightCore moonlightCore) {
        NativeParser nativeParser = new NativeParser(moonlightCore);
        ParserLayout parserLayout = new ParserLayout(nativeParser);
        parserLayout.pattern("---;", 0, 0, PatternExtractor.FULL);
        moonlightCore.registerParser(parserLayout);
    }

    @Override
    public NamedExecutable parse(Atom atom) {
        final SourcesDivider sourcesDivider = atom.getSourcesDivider();
        final StringBuilder nativeSourceBuilder = new StringBuilder("");
        final Block block = new Block(atom.getCurrent());

        while (sourcesDivider.hasNext() && atom.getPandaParser().isHappy()) {
            String line = sourcesDivider.next();

            if (line.contains("---")) {
                break;
            }

            nativeSourceBuilder.append(line);
            nativeSourceBuilder.append(System.lineSeparator());
        }

        PandaParser pandaParser = new PandaParser(panda, nativeSourceBuilder.toString());
        PandaScript pandaScript = pandaParser.parse();

        PandaBlock pandaBlock = pandaParser.getPandaBlock();
        block.setExecutables(pandaBlock.getExecutables());
        block.setName("native");

        return new Runtime(null, new Executable() {
            @Override
            public Essence run(Alice alice) {
                return block.run(alice);
            }
        }, null);
    }

}
