package org.panda_lang.light;

import org.panda_lang.light.core.parser.util.HollowPattern;

import java.util.Collection;

public class HollowsTest {

    public static void main(String[] args) {
        HollowPattern hollowPattern = new HollowPattern(0, "invoke *");
        hollowPattern.match("invoke \"ray\"");

        Collection<String> hollows = hollowPattern.getHollows();
        System.out.print(hollows);
    }

}
