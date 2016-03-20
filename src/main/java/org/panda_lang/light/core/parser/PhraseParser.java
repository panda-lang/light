package org.panda_lang.light.core.parser;

import org.panda_lang.light.Light;
import org.panda_lang.light.LightScript;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.element.expression.ExpressionRuntime;
import org.panda_lang.light.core.element.expression.ExpressionUtils;
import org.panda_lang.light.core.element.phrase.Phrase;
import org.panda_lang.light.core.element.phrase.PhraseRepresentation;
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

    private final Light light;

    public PhraseParser(Light light) {
        this.light = light;
    }

    public static void initialize(Light light) {
        PhraseParser phraseParser = new PhraseParser(light);
        ParserLayout parserLayout = new ParserLayout(phraseParser);
        parserLayout.pattern("*;", 5);
        light.registerParser(parserLayout);
    }

    public NamedExecutable parse(Atom atom) {
        String phraseSource = atom.getSourcesDivider().getLine().trim();
        phraseSource = phraseSource.substring(0, phraseSource.length() - 1);

        for (PhraseRepresentation phraseRepresentation : light.getLightCore().getPhraseCenter().getElements()) {
            for (HollowPattern pattern : phraseRepresentation.getPatterns()) {
                if (pattern.match(phraseSource)) {

                    ExpressionParser expressionParser = new ExpressionParser(light);
                    Collection<String> hollows = pattern.getHollows();
                    List<ExpressionRuntime> expressions = expressionParser.parse(atom, hollows);
                    Factor[] factors = ExpressionUtils.toFactors(expressions);

                    final Phrase phrase = phraseRepresentation.getPhrase();
                    final Ray ray = new Ray()
                            .lightScript((LightScript) atom.getPandaScript())
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
