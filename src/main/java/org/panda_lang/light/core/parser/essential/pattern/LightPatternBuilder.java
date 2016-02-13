package org.panda_lang.light.core.parser.essential.pattern;

import java.util.ArrayList;
import java.util.List;

public class LightPatternBuilder {

    private final List<Symbol> symbols;
    private Symbol symbol;

    protected LightPatternBuilder() {
        this.symbols = new ArrayList<>();
    }

    public LightPatternBuilder basis(String basis) {
        this.symbol = new Symbol(SymbolType.BASIS, symbols.size());
        this.symbols.add(symbol);
        this.symbol.addVariant(basis);
        return this;
    }

    public LightPatternBuilder variant(String variant) {
        this.symbol.addVariant(variant);
        return this;
    }

    public LightPatternBuilder hollow() {
        this.symbol = new Symbol(SymbolType.HOLLOW, symbols.size());
        this.symbols.add(symbol);
        return this;
    }

    public LightPatternBuilder optional(String fragment) {
        this.symbol = new Symbol(SymbolType.OPTIONAL, symbols.size());
        this.symbols.add(symbol);
        this.symbol.addVariant(fragment);
        return this;
    }

    public LightPatternBuilder optionalSegmentBefore(String segment) {
        this.symbol.addSegmentBefore(segment);
        return this;
    }

    public LightPatternBuilder optionalSegmentAfter(String segment) {
        this.symbol.addSegmentAfter(segment);
        return this;
    }

    public LightPatternBuilder compile(String pattern) {
        return compiler().compile(pattern);
    }

    public LightPatternCompiler compiler() {
        return new LightPatternCompiler(this);
    }

    public LightPattern build(int id) {
        return new LightPattern(id, symbols);
    }

}
