package org.panda_lang.light.core.parser;

import org.panda_lang.light.LightCore;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.PandaScript;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.parser.*;
import org.panda_lang.panda.core.parser.util.SourcesDivider;
import org.panda_lang.panda.core.parser.util.match.parser.PatternExtractor;
import org.panda_lang.panda.core.statement.Block;
import org.panda_lang.panda.core.statement.Executable;
import org.panda_lang.panda.core.statement.block.PandaBlock;

public class NativeParser implements Parser {

    private final Panda panda;
    private final LightCore lightCore;

    public NativeParser(LightCore lightCore) {
        this.panda = new Panda();
        this.lightCore = lightCore;

        this.panda.initializeDefaultElements();
    }

    public static void initialize(LightCore lightCore) {
        org.panda_lang.light.core.parser.NativeParser nativeParser = new org.panda_lang.light.core.parser.NativeParser(lightCore);
        ParserLayout parserLayout = new ParserLayout(nativeParser);
        parserLayout.pattern("---;", 0, 0, PatternExtractor.FULL);
        lightCore.registerParser(parserLayout);
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
            public Inst execute(Alice alice) {
                return block.execute(alice);
            }
        };
    }

}
