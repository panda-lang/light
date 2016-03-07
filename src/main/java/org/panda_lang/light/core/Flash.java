package org.panda_lang.light.core;

import org.panda_lang.light.Light;
import org.panda_lang.light.core.element.expression.ExpressionRuntime;
import org.panda_lang.light.core.parser.ExpressionParser;
import org.panda_lang.panda.core.parser.Atom;

import java.util.List;

public class Flash {

    private final Light light;
    private final Atom atom;

    public Flash(Light light, Atom atom) {
        this.light = light;
        this.atom = atom;
    }

    public ExpressionRuntime parseExpression(String expression) {
        ExpressionParser expressionParser = new ExpressionParser(light);
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

    public Light getLight() {
        return light;
    }

}
