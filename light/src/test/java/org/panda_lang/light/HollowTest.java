package org.panda_lang.light;

import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;

public class HollowTest {

    public static void main(String[] args) {
        HollowPattern hollowPattern = HollowPattern.builder().compile("arg *").build(0);
        boolean matched = hollowPattern.match("arg *");

        System.out.println(matched);
        System.out.println(hollowPattern.getHollows());
    }

}
