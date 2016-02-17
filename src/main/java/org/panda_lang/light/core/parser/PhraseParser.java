package org.panda_lang.light.core.parser;

import org.panda_lang.light.Light;
import org.panda_lang.light.LightScript;
import org.panda_lang.light.core.Phrase;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.parser.assistant.PhraseRepresentation;
import org.panda_lang.light.core.parser.pattern.LightPattern;
import org.panda_lang.light.core.util.ExpressionRuntime;
import org.panda_lang.light.core.util.ExpressionUtils;
import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.ParserLayout;
import org.panda_lang.panda.core.parser.util.SimplifiedNamedExecutable;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Executable;
import org.panda_lang.panda.core.syntax.Factor;
import org.panda_lang.panda.core.syntax.NamedExecutable;

import java.util.Collection;
import java.util.List;

public class PhraseParser implements Parser {

    private final Light light;

    public PhraseParser(Light light) {
        this.light = light;
    }

    public NamedExecutable parse(Atom atom) {
        String phraseSource = atom.getSourcesDivider().getLine().trim();
        phraseSource = phraseSource.substring(0, phraseSource.length() - 1);

        for (final PhraseRepresentation phraseRepresentation : light.getLightCore().getPhraseCenter().getPhrases()) {
            for (final LightPattern pattern : phraseRepresentation.getPatterns()) {
                if (pattern.match(phraseSource)) {
                    final ExpressionParser expressionParser = new ExpressionParser(light);
                    final Collection<String> hollows = pattern.getHollows();
                    final List<ExpressionRuntime> expressions = expressionParser.parse(atom, hollows);
                    final Factor[] factors = ExpressionUtils.toFactors(expressions);

                    final Phrase phrase = phraseRepresentation.getRepresentation();
                    final Ray ray = new Ray()
                            .lightScript((LightScript) atom.getPandaScript())
                            .pattern(pattern)
                            .expressionRuntimes(expressions)
                            .factors(factors);

                    return new SimplifiedNamedExecutable(new Executable() {
                        @Override
                        public Essence run(Particle particle) {
                            ray.include(particle);
                            phrase.run(ray);
                            return ray.getReturnValue();
                        }
                    });
                }
            }
        }
        return null;
    }

    public static void initialize(Light light) {
        PhraseParser phraseParser = new PhraseParser(light);
        ParserLayout parserLayout = new ParserLayout(phraseParser);
        parserLayout.pattern("*;", 5);
        light.getLightCore().getPanda().getPandaCore().registerParser(parserLayout);
    }

}
