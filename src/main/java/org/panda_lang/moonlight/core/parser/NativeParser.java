package org.panda_lang.moonlight.core.parser;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.PandaScript;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.core.parser.*;
import org.panda_lang.panda.core.parser.util.match.parser.PatternExtractor;
import org.panda_lang.panda.core.statement.Block;
import org.panda_lang.panda.core.statement.Executable;
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
    public Executable parse(ParserInfo parserInfo) {
        final SourcesDivider sourcesDivider = parserInfo.getSourcesDivider();
        final StringBuilder nativeSourceBuilder = new StringBuilder("");
        final Block block = new Block(parserInfo.getCurrent());

        while (sourcesDivider.hasNext() && parserInfo.getPandaParser().isHappy()) {
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

        return new Executable() {
            @Override
            public Essence execute(Alice alice) {
                return block.execute(alice);
            }
        };
    }

}
