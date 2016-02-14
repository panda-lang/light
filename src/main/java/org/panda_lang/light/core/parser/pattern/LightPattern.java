package org.panda_lang.light.core.parser.pattern;

import org.panda_lang.panda.core.parser.util.Matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LightPattern implements Matcher {

    private final int id;
    private final List<Symbol> symbols;
    private final List<String> hollows;

    protected LightPattern(int id, List<Symbol> symbols) {
        this.id = id;
        this.symbols = symbols;
        this.hollows = new ArrayList<>();
    }

    @Override
    public boolean match(String expression) {
        List<String> fragments = LightPatternUtils.toFragments(expression);
        int f = 0;

        hollows.clear();

        for (Symbol symbol : symbols) {
            loop:

            if (symbol.isBasis()) {
                if (f >= fragments.size()) {
                    return false;
                }

                String fragment = fragments.get(f);

                if (symbol.match(fragment)) {
                    f++;
                    break loop;
                }
                return false;
            }

            else if (symbol.isHollow()) {
                Symbol nextSymbol = symbols.size() > symbol.getID() + 1 ? symbols.get(symbol.getID() + 1) : symbol;
                StringBuilder hollowBuilder = new StringBuilder();

                for (int i = f; i < fragments.size(); i++) {
                    String nextFragment = fragments.get(i);

                    if (nextSymbol.match(nextFragment)) {
                        hollows.add(hollowBuilder.toString().trim());
                        break loop;
                    }

                    hollowBuilder.append(nextFragment);
                    hollowBuilder.append(" ");
                    f++;
                }

                hollows.add(hollowBuilder.toString().trim());
            }

            // <todo: optional>

        }

        return true;
    }

    public Collection<String> getHollows() {
        return hollows;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public int getID() {
        return id;
    }

    public static LightPatternBuilder builder() {
        return new LightPatternBuilder();
    }

}
