package org.panda_lang.moonlight.core;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.element.expression.ExpressionRuntime;
import org.panda_lang.moonlight.core.parser.ExpressionParser;
import org.panda_lang.panda.core.parser.Atom;

import java.util.List;

public class Flash {

    private final MoonlightCore moonlight;
    private final Atom atom;

    public Flash(MoonlightCore moonlight, Atom atom) {
        this.moonlight = moonlight;
        this.atom = atom;
    }

    public ExpressionRuntime parseExpression(String expression) {
        ExpressionParser expressionParser = new ExpressionParser(moonlight);
        return expressionParser.parse(atom, expression);
    }

    public String getFullPhrase() {
        return atom.getBlockInfo().getSpecifiersAsPhrase();
    }

    public List<String> getSpecifiers() {
        return atom.getBlockInfo().getSpecifiers();
    }

    public Atom getAtom() {
        return atom;
    }

    public MoonlightCore getMoonlight() {
        return moonlight;
    }

}
