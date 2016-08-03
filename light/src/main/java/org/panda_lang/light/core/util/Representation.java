package org.panda_lang.light.core.util;

import org.panda_lang.panda.core.Alice;
import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.statement.util.NamedExecutable;
import org.panda_lang.panda.util.documentation.Documentation;

import java.util.ArrayList;
import java.util.Collection;

public class Representation<T> implements NamedExecutable {

    private final Collection<HollowPattern> patterns;
    private final Documentation documentation;

    public Representation() {
        this.patterns = new ArrayList<>(1);
        this.documentation = new Documentation();
    }

    @Override
    public Inst execute(Alice alice) {
        return null;
    }

    public HollowPattern pattern(String pattern) {
        HollowPattern hollowPattern = HollowPattern.builder()
                .compiler()
                .compile(pattern)
                .build(patterns.size());
        return pattern(hollowPattern);
    }

    public HollowPattern pattern(HollowPattern hollowPattern) {
        patterns.add(hollowPattern);
        return hollowPattern;
    }

    public Documentation documentation() {
        return documentation;
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    public Collection<HollowPattern> getPatterns() {
        return patterns;
    }

    @Override
    public String getName() {
        return patterns.toString();
    }

}
