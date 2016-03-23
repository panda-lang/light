package org.panda_lang.moonlight.core.parser;

import org.panda_lang.moonlight.Moonlight;
import org.panda_lang.panda.Panda;
import org.panda_lang.panda.PandaScript;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.*;
import org.panda_lang.panda.core.parser.util.match.parser.PatternExtractor;
import org.panda_lang.panda.core.syntax.*;
import org.panda_lang.panda.core.syntax.Runtime;
import org.panda_lang.panda.core.syntax.block.PandaBlock;

public class NativeParser implements Parser {

    private final Panda panda;
    private final Moonlight moonlight;

    public NativeParser(Moonlight moonlight) {
        this.panda = new Panda();
        this.moonlight = moonlight;

        this.panda.initializeDefaultElements();
    }

    public static void initialize(Moonlight moonlight) {
        NativeParser nativeParser = new NativeParser(moonlight);
        ParserLayout parserLayout = new ParserLayout(nativeParser);
        parserLayout.pattern("---;", 0, 0, PatternExtractor.FULL);
        moonlight.registerParser(parserLayout);
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
            public Essence run(Particle particle) {
                return block.run(particle);
            }
        }, null);
    }

}
