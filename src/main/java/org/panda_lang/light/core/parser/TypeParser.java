package org.panda_lang.light.core.parser;

import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.syntax.Factor;

public class TypeParser implements Parser {

    @Override
    public Factor parse(Atom atom) {
        String typeSource = atom.getSourceCode();

        return null;
    }

    public Factor parse(Atom atom, String typeSource) {
        atom.setSourceCode(typeSource);
        return parse(atom);
    }

}
