package org.panda_lang.light;

import org.panda_lang.core.util.match.hollow.HollowPattern;

public class HollowTest {

    public static void main(String[] args) {
        HollowPattern hollowPattern = HollowPattern.builder()
                .basis("arg")
                .hollow()
                .build();

        boolean matched = hollowPattern.match("arg xyz");

        System.out.println(matched);
        System.out.println(hollowPattern.getHollows());
    }

}
