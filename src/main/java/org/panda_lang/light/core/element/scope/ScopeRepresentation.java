package org.panda_lang.light.core.element.scope;

import org.panda_lang.light.Light;
import org.panda_lang.light.core.Flash;
import org.panda_lang.light.core.element.type.ArgumentRepresentation;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.syntax.Block;

import java.util.ArrayList;
import java.util.Collection;

public class ScopeRepresentation {

    private final Light light;
    private final BlockLayout blockLayout;
    private final Collection<ArgumentRepresentation> arguments;

    public ScopeRepresentation(String scope, Class<? extends Block> clazz, Light light) {
        this.blockLayout = new BlockLayout(clazz, scope);
        this.arguments = new ArrayList<>();
        this.light = light;
    }

    public ScopeRepresentation(Light light, Class<? extends Block> clazz, String... scopes) {
        this.blockLayout = new BlockLayout(clazz, scopes);
        this.arguments = new ArrayList<>();
        this.light = light;
    }

    public ScopeRepresentation initializer(final ScopeInitializer scopeInitializer) {
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                Flash flash = new Flash(light, atom);
                return scopeInitializer.initialize(flash);
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

    public Light getLight() {
        return light;
    }

}
