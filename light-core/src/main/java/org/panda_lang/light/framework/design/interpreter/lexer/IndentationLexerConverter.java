package org.panda_lang.light.framework.design.interpreter.lexer;

import org.panda_lang.light.LightException;
import org.panda_lang.panda.framework.design.interpreter.token.TokenRepresentation;
import org.panda_lang.panda.framework.language.interpreter.token.PandaTokenRepresentation;
import org.panda_lang.panda.framework.language.resource.syntax.separator.Separators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class IndentationLexerConverter {

    private static final TokenRepresentation START = new PandaTokenRepresentation(Separators.LEFT_BRACE_DELIMITER, -2);
    private static final TokenRepresentation END = new PandaTokenRepresentation(Separators.RIGHT_BRACE_DELIMITER, -2);

    public List<TokenRepresentation> convert(List<Object> elements) {
        List<TokenRepresentation> tokens = new ArrayList<>(elements.size() * 2);

        for (Object element : elements) {
            tokens.addAll(convertElement(element));
        }

        return tokens;
    }

    private List<TokenRepresentation> convertElement(Object element) {
        if (element instanceof TokenRepresentation) {
            return convertRepresentation((TokenRepresentation) element);
        }
        else if (element instanceof IndentationLexerTree.Group) {
            return convertGroup((IndentationLexerTree.Group) element);
        }

        throw new LightException("Unknown element type: " + element.getClass());
    }

    private List<TokenRepresentation> convertRepresentation(TokenRepresentation element) {
        return Collections.singletonList(element);
    }

    private List<TokenRepresentation> convertGroup(IndentationLexerTree.Group group) {
        List<TokenRepresentation> tokens = new ArrayList<>();

        tokens.add(group.getMaster());
        tokens.add(START);

        List<TokenRepresentation> body = convert(group.getElements());
        tokens.addAll(body);

        tokens.add(END);
        return tokens;
    }

}
