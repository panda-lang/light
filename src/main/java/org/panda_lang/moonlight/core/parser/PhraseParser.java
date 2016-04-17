package org.panda_lang.moonlight.core.parser;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.MoonlightScript;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.element.expression.ExpressionUtils;
import org.panda_lang.moonlight.core.element.phrase.Phrase;
import org.panda_lang.moonlight.core.element.phrase.PhraseRepresentation;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Essence;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.ParserLayout;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.statement.Executable;
import org.panda_lang.panda.core.statement.Factor;

import java.util.ArrayList;
import java.util.List;

public class PhraseParser implements Parser {

    private final MoonlightCore moonlightCore;

    public PhraseParser(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
    }

    public static void initialize(MoonlightCore moonlightCore) {
        PhraseParser phraseParser = new PhraseParser(moonlightCore);
        ParserLayout parserLayout = new ParserLayout(phraseParser);
        parserLayout.pattern("*;", 5);
        moonlightCore.registerParser(parserLayout);
    }

    public Executable parse(final Atom atom) {
        String phraseSource = atom.getSourcesDivider().getLine().trim();
        phraseSource = phraseSource.substring(0, phraseSource.length() - 1);

        for (final PhraseRepresentation phraseRepresentation : moonlightCore.getPhraseCenter().getElements()) {
            for (final HollowPattern pattern : phraseRepresentation.getPatterns()) {
                if (pattern.match(phraseSource)) {

                    final ExpressionParser expressionParser = new ExpressionParser(moonlightCore);
                    final List<String> hollows = pattern.getHollows();
                    final List<ExpressionRuntime> expressions = new ArrayList<>(hollows.size() - phraseRepresentation.getRaw());
                    final Factor[] factors = ExpressionUtils.toFactors(expressions);
                    final Phrase phrase = phraseRepresentation.getPhrase();

                    for (int i = phraseRepresentation.getRaw(); i < hollows.size(); i++) {
                        String hollow = hollows.get(i);
                        ExpressionRuntime expressionRuntime = expressionParser.parse(atom, hollow);
                        expressions.add(expressionRuntime);
                    }

                    return new Executable() {
                        @Override
                        public Essence execute(Alice alice) {
                            Ray ray = alice.getCustom();
                            if (ray == null) {
                                ray = new Ray();
                            }

                            ray.particle(alice)
                                    .script((MoonlightScript) atom.getPandaScript())
                                    .pattern(pattern)
                                    .hollows(new ArrayList<>(hollows))
                                    .expressionRuntimes(expressions)
                                    .factors(factors);
                            phrase.run(ray);
                            return null;
                        }
                    };
                }
            }
        }
        return null;
    }

}
