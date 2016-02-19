package org.panda_lang.light.core.parser;

import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.syntax.Factor;

public class TypeParser implements Parser {

    @Override
    public Factor parse(Atom atom) {
        String typeSource = atom.getSourceCode();

        if (typeSource.charAt(0) == '[') {
            String variable = typeSource.substring(1, typeSource.length() - 1);
            return new Factor(variable);
        }

        return null;
    }

    public Factor parse(Atom atom, String typeSource) {
        atom.setSourceCode(typeSource);
        return parse(atom);
    }

}
