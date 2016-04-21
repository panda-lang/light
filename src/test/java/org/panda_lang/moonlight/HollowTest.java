package org.panda_lang.moonlight;

import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;

public class HollowTest {

    public static void main(String[] args) {
        HollowPattern hollowPattern = HollowPattern.builder().compile("arg* w*").build(0);
        boolean matched = hollowPattern.match("arg5 wefwer5fewq");

        System.out.println(matched);
        System.out.println(hollowPattern.getHollows());
    }

}
