package org.panda_lang.moonlight.core.element.scope;

import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Flash;
import org.panda_lang.moonlight.core.element.argument.ArgumentInitializer;
import org.panda_lang.moonlight.core.element.argument.ArgumentRepresentation;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.statement.Block;

public class ScopeRepresentation {

    private final MoonlightCore moonlight;
    private final BlockLayout blockLayout;
    private final ScopeUnit scopeUnit;
    private ScopeUnitGetter scopeUnitGetter;

    public ScopeRepresentation(String scopeName, Class<? extends Block> clazz, MoonlightCore moonlight) {
        this.blockLayout = new BlockLayout(clazz, scopeName);
        this.scopeUnit = new ScopeUnit(scopeName);
        this.moonlight = moonlight;
    }

    public ScopeRepresentation(MoonlightCore moonlight, Class<? extends Block> clazz, String... scopes) {
        this.blockLayout = new BlockLayout(clazz, scopes);
        this.scopeUnit = new ScopeUnit(scopes[0]);
        this.moonlight = moonlight;
    }

    public ScopeRepresentation initializer(final ScopeInitializer scopeInitializer) {
        final ScopeRepresentation scopeRepresentation = this;
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(Atom atom) {
                Flash flash = new Flash(moonlight, atom);
                Scope scope = scopeInitializer.initialize(flash);
                scope.initializeScopeRepresentation(scopeRepresentation);
                return scope;
            }
        });
        return this;
    }

    public ScopeRepresentation scopeUnitGetter(ScopeUnitGetter scopeUnitGetter) {
        this.scopeUnitGetter = scopeUnitGetter;
        return this;
    }

    public void registerArgument(String pattern, ArgumentInitializer argumentInitializer) {
        ArgumentRepresentation argumentRepresentation = new ArgumentRepresentation();
        argumentRepresentation.pattern(pattern);
        argumentRepresentation.initializer(argumentInitializer);
        registerArgument(argumentRepresentation);
    }

    public void registerArgument(ArgumentRepresentation argumentRepresentation) {
        scopeUnit.registerArgument(argumentRepresentation);
    }

    public ScopeUnit getScopeUnit(Scope scope) {
        ScopeUnit scopeUnit = null;
        if (scopeUnitGetter != null) {
            scopeUnit = scopeUnitGetter.get(scope);
        }
        if (scopeUnit == null) {
            scopeUnit = this.scopeUnit;
        }
        return scopeUnit;
    }


    public ScopeUnitGetter getScopeUnitGetter() {
        return scopeUnitGetter;
    }

    public ScopeUnit getScopeUnit() {
        return scopeUnit;
    }

    public BlockLayout getBlockLayout() {
        return blockLayout;
    }

    public MoonlightCore getMoonlight() {
        return moonlight;
    }

    @Override
    public String toString() {
        return "ScopeRepresentation{" +
                "moonlight=" + moonlight +
                ", blockLayout=" + blockLayout +
                ", scopeUnit=" + scopeUnit +
                '}';
    }
}
