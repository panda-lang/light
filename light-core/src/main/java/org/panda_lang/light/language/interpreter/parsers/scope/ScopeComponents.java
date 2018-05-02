package org.panda_lang.light.language.interpreter.parsers.scope;

import org.panda_lang.panda.framework.design.interpreter.parser.component.*;
import org.panda_lang.panda.framework.design.interpreter.token.*;

public class ScopeComponents {

    public static final Component<TokenRepresentation> DECLARATION = Component.of("light-scope-declaration", TokenRepresentation.class);

    public static final Component<TokenRepresentation[]> CONTENT = Component.of("light-scope-content", TokenRepresentation[].class);

}
