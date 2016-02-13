package org.panda_lang.light.core.parser.essential.pattern;

import org.panda_lang.panda.core.parser.util.Matcher;

import java.util.ArrayList;
import java.util.Collection;

public class Symbol implements Matcher {

    private final int id;
    private final SymbolType symbolType;
    private final Collection<String> segmentsBefore;
    private final Collection<String> variants;
    private final Collection<String> segmentsAfter;

    public Symbol(SymbolType symbolType, int id) {
        this.id = id;
        this.symbolType = symbolType;
        this.segmentsBefore = new ArrayList<>(1);
        this.variants = new ArrayList<>(1);
        this.segmentsAfter = new ArrayList<>(1);
    }

    @Override
    public boolean match(String expression) {
        for (String variant : variants) {
            if (variant.equals(expression)) {
                return true;
            }
        }

        // <todo>

        return false;
    }

    public void addSegmentBefore(String segment) {
        this.segmentsBefore.add(segment);
    }

    public void addVariant(String variant) {
        this.variants.add(variant);
    }

    public void addSegmentAfter(String segment) {
        this.segmentsAfter.add(segment);
    }

    public boolean isOptional() {
        return symbolType == SymbolType.OPTIONAL;
    }

    public boolean isHollow() {
        return symbolType == SymbolType.HOLLOW;
    }

    public boolean isBasis() {
        return symbolType == SymbolType.BASIS;
    }

    public Collection<String> getSegmentsBefore() {
        return segmentsBefore;
    }

    public Collection<String> getSegmentsAfter() {
        return segmentsAfter;
    }

    public Collection<String> getVariants() {
        return variants;
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

    public int getID() {
        return id;
    }

}
