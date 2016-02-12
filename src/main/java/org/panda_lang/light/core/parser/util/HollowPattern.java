package org.panda_lang.light.core.parser.util;

import org.panda_lang.panda.core.parser.util.CharArrayDistributor;
import org.panda_lang.panda.core.parser.util.Matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HollowPattern implements Matcher {

    private final int id;
    private final String pattern;
    private final List<String> hollows;

    public HollowPattern(int id, String pattern) {
        this.id = id;
        this.pattern = pattern;
        this.hollows = new ArrayList<>();
    }

    @Override
    public boolean match(String expression) {
        char[] string = expression.toCharArray();
        int i = 0;

        hollows.clear();

        if (string.length == 0) {
            return false;
        }

        StringBuilder hollowBuilder = new StringBuilder();
        CharArrayDistributor distributor = new CharArrayDistributor(pattern.toCharArray());
        while (distributor.hasNext() && i < string.length) {
            char current = distributor.current();
            char compared = string[i];

            if (current == compared) {
                distributor.next();
                i++;
            }
            else if (current == '*') {
                hollowBuilder.append(compared);

                if (distributor.further() == compared) {
                    hollows.add(hollowBuilder.toString());
                    hollowBuilder.setLength(0);

                    distributor.next();
                    distributor.next();
                }

                i++;
            }
            else if (distributor.getPrevious(2) == '*') {
                String beginning = hollows.remove(hollows.size() - 1);
                String part = hollowBuilder.toString();

                hollowBuilder.setLength(0);
                hollowBuilder.append(beginning);
                hollowBuilder.append(part);

                distributor.previous();
                distributor.previous();
            }
            else {
                break;
            }
        }

        if (string.length > i) {
            for (int fill = i; fill < string.length; fill++) {
                hollowBuilder.append(string[fill]);
            }
        }

        if (hollowBuilder.length() > 0) {
            hollows.add(hollowBuilder.toString());
        }

        return !distributor.hasNext();
    }

    public Collection<String> getHollows() {
        return hollows;
    }

    public int getID() {
        return id;
    }

}
