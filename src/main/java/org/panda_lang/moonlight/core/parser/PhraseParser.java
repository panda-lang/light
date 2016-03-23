package org.panda_lang.moonlight.core.parser;

import org.panda_lang.moonlight.Moonlight;
import org.panda_lang.moonlight.MoonlightScript;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.element.expression.ExpressionUtils;
import org.panda_lang.moonlight.core.element.phrase.Phrase;
import org.panda_lang.moonlight.core.element.phrase.PhraseRepresentation;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.ParserLayout;
import org.panda_lang.panda.core.parser.util.SimplifiedNamedExecutable;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Executable;
import org.panda_lang.panda.core.syntax.Factor;
import org.panda_lang.panda.core.syntax.NamedExecutable;

import java.util.Collection;
import java.util.List;

public class PhraseParser implements Parser {

    private final Moonlight moonlight;

    public PhraseParser(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    public static void initialize(Moonlight moonlight) {
        PhraseParser phraseParser = new PhraseParser(moonlight);
        ParserLayout parserLayout = new ParserLayout(phraseParser);
        parserLayout.pattern("*;", 5);
        moonlight.registerParser(parserLayout);
    }

    public NamedExecutable parse(Atom atom) {
        String phraseSource = atom.getSourcesDivider().getLine().trim();
        phraseSource = phraseSource.substring(0, phraseSource.length() - 1);

        for (PhraseRepresentation phraseRepresentation : moonlight.getMoonlightCore().getPhraseCenter().getElements()) {
            for (HollowPattern pattern : phraseRepresentation.getPatterns()) {
                if (pattern.match(phraseSource)) {

                    ExpressionParser expressionParser = new ExpressionParser(moonlight);
                    Collection<String> hollows = pattern.getHollows();
                    List<ExpressionRuntime> expressions = expressionParser.parse(atom, hollows);
                    Factor[] factors = ExpressionUtils.toFactors(expressions);

                    final Phrase phrase = phraseRepresentation.getPhrase();
                    final Ray ray = new Ray()
                            .lightScript((MoonlightScript) atom.getPandaScript())
                            .pattern(pattern)
                            .expressionRuntimes(expressions)
                            .factors(factors);

                    return new SimplifiedNamedExecutable(new Executable() {
                        @Override
                        public Essence run(Particle particle) {
                            ray.particle(particle);
                            phrase.run(ray);
                            return null;
                        }
                    });
                }
            }
        }
        return null;
    }

}
