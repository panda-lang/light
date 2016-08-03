package org.panda_lang.light.core.element.scope;

import org.panda_lang.light.LightCore;
import org.panda_lang.panda.core.parser.ParserInfo;
import org.panda_lang.panda.core.parser.essential.util.BlockInitializer;
import org.panda_lang.panda.core.parser.essential.util.BlockLayout;
import org.panda_lang.panda.core.statement.Block;

public class ScopeRepresentation {

    private final LightCore light;
    private final BlockLayout blockLayout;
    private final ScopeUnit scopeUnit;
    private ScopeUnitGetter scopeUnitGetter;

    public ScopeRepresentation(String scopeName, Class<? extends Block> clazz, LightCore light) {
        this.blockLayout = new BlockLayout(clazz, scopeName);
        this.scopeUnit = new ScopeUnit(scopeName);
        this.light = light;
    }

    public ScopeRepresentation(LightCore light, Class<? extends Block> clazz, String... scopes) {
        this.blockLayout = new BlockLayout(clazz, scopes);
        this.scopeUnit = new ScopeUnit(scopes[0]);
        this.light = light;
    }

    public org.panda_lang.light.core.element.scope.ScopeRepresentation initializer(final ScopeInitializer scopeInitializer) {
        final org.panda_lang.light.core.element.scope.ScopeRepresentation scopeRepresentation = this;
        blockLayout.initializer(new BlockInitializer() {
            @Override
            public Block initialize(ParserInfo parserInfo) {
                org.panda_lang.light.core.Flash flash = new org.panda_lang.light.core.Flash(light, parserInfo);
                Scope scope = scopeInitializer.initialize(flash);
                scope.initializeScopeRepresentation(scopeRepresentation);
                return scope;
            }
        });
        return this;
    }

    public org.panda_lang.light.core.element.scope.ScopeRepresentation scopeUnitGetter(ScopeUnitGetter scopeUnitGetter) {
        this.scopeUnitGetter = scopeUnitGetter;
        return this;
    }

    public void registerArgument(org.panda_lang.light.core.element.argument.ArgumentInitializer argumentInitializer, String... patterns) {
        org.panda_lang.light.core.element.argument.ArgumentRepresentation argumentRepresentation = new org.panda_lang.light.core.element.argument.ArgumentRepresentation();
        for (String pattern : patterns) {
            argumentRepresentation.pattern(pattern);
        }
        argumentRepresentation.initializer(argumentInitializer);
        registerArgument(argumentRepresentation);
    }

    public void registerArgument(String pattern, org.panda_lang.light.core.element.argument.ArgumentInitializer argumentInitializer) {
        org.panda_lang.light.core.element.argument.ArgumentRepresentation argumentRepresentation = new org.panda_lang.light.core.element.argument.ArgumentRepresentation();
        argumentRepresentation.pattern(pattern);
        argumentRepresentation.initializer(argumentInitializer);
        registerArgument(argumentRepresentation);
    }

    public void registerArgument(org.panda_lang.light.core.element.argument.ArgumentRepresentation argumentRepresentation) {
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

    public LightCore getLight() {
        return light;
    }

    @Override
    public String toString() {
        return "ScopeRepresentation{" +
                "lightmc=" + light +
                ", blockLayout=" + blockLayout +
                ", scopeUnit=" + scopeUnit +
                '}';
    }
}
