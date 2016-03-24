package org.panda_lang.moonlight.core.element.scope;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Flash;
import org.panda_lang.moonlight.core.element.argument.ArgumentRepresentation;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;

import java.util.ArrayList;
import java.util.Collection;

public class ScopeRepresentation {

    private final MoonlightCore moonlight;
    private final BlockLayout blockLayout;
    private final Collection<ArgumentRepresentation> arguments;

    public ScopeRepresentation(String scope, Class<? extends Block> clazz, MoonlightCore moonlight) {
        this.blockLayout = new BlockLayout(clazz, scope);
        this.arguments = new ArrayList<>();
        this.moonlight = moonlight;
    }

    public ScopeRepresentation(MoonlightCore moonlight, Class<? extends Block> clazz, String... scopes) {
        this.blockLayout = new BlockLayout(clazz, scopes);
        this.arguments = new ArrayList<>();
        this.moonlight = moonlight;
    }

    public ScopeRepresentation initializer(final ScopeInitializer scopeInitializer) {
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                Flash flash = new Flash(moonlight, atom);
                Scope scope = scopeInitializer.initialize(flash);

                return scope;
            }
        });
        return this;
    }

    public ScopeRepresentation registerArgument(ArgumentRepresentation argumentRepresentation) {
        arguments.add(argumentRepresentation);
        return this;
    }

    public Collection<ArgumentRepresentation> getArguments() {
        return arguments;
    }

    public BlockLayout getBlockLayout() {
        return blockLayout;
    }

    public MoonlightCore getMoonlight() {
        return moonlight;
    }

}
