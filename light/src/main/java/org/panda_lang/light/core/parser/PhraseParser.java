package org.panda_lang.light.core.parser;

import org.panda_lang.light.LightCore;
import org.panda_lang.light.LightScript;
import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.ParserInfo;
import org.panda_lang.panda.core.parser.ParserLayout;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.statement.Executable;
import org.panda_lang.panda.core.statement.RuntimeValue;

import java.util.ArrayList;
import java.util.List;

public class PhraseParser implements Parser {

    private final LightCore lightCore;

    public PhraseParser(LightCore lightCore) {
        this.lightCore = lightCore;
    }

    public static void initialize(LightCore lightCore) {
        org.panda_lang.light.core.parser.PhraseParser phraseParser = new org.panda_lang.light.core.parser.PhraseParser(lightCore);
        ParserLayout parserLayout = new ParserLayout(phraseParser);
        parserLayout.pattern("*;", 5);
        lightCore.registerParser(parserLayout);
    }

    public Executable parse(final ParserInfo parserInfo) {
        String phraseSource = parserInfo.getSourcesDivider().getLine().trim();
        phraseSource = phraseSource.substring(0, phraseSource.length() - 1);

        for (final org.panda_lang.light.core.element.phrase.PhraseRepresentation phraseRepresentation : lightCore.getPhraseCenter().getElements()) {
            for (final HollowPattern pattern : phraseRepresentation.getPatterns()) {
                if (pattern.match(phraseSource)) {

                    final ExpressionParser expressionParser = new ExpressionParser(lightCore);
                    final List<String> hollows = new ArrayList<>(pattern.getHollows());
                    final List<org.panda_lang.light.core.element.expression.ExpressionRuntime> expressions = new ArrayList<>(hollows.size() - phraseRepresentation.getRaw());
                    final RuntimeValue[] runtimeValues = org.panda_lang.light.core.element.expression.ExpressionUtils.toFactors(expressions);
                    final org.panda_lang.light.core.element.phrase.Phrase phrase = phraseRepresentation.getPhrase();

                    for (int i = phraseRepresentation.getRaw(); i < hollows.size(); i++) {
                        String hollow = hollows.get(i);
                        org.panda_lang.light.core.element.expression.ExpressionRuntime expressionRuntime = expressionParser.parse(parserInfo, hollow);
                        expressions.add(expressionRuntime);
                    }

                    return new Executable() {
                        @Override
                        public Inst execute(Alice alice) {
                            org.panda_lang.light.core.Ray ray = alice.getCustom();
                            if (ray == null) {
                                ray = new org.panda_lang.light.core.Ray();
                            }

                            ray.particle(alice)
                                    .script((LightScript) parserInfo.getPandaScript())
                                    .pattern(pattern)
                                    .hollows(new ArrayList<>(hollows))
                                    .expressionRuntimes(expressions)
                                    .factors(runtimeValues);
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
