package org.panda_lang.light.core.parser.pattern;

import java.util.List;

public class LightPatternCompiler {

    private final LightPatternBuilder builder;

    protected LightPatternCompiler(LightPatternBuilder builder) {
        this.builder = builder;
    }

    public LightPatternBuilder compile(String pattern) {
        List<String> fragments = LightPatternUtils.toFragments(pattern);

        for (String fragment : fragments) {
            if (fragment.equals("*")) {
                builder.hollow();
            }
            else {
                builder.basis(fragment);
            }
        }
        return builder;
    }

    public LightPatternBuilder getBuilder() {
        return builder;
    }

}
