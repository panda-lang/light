package org.panda_lang.light;

import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;

public class HollowsTest {

    private static final String CODE = "invoke \"ray\"";

    public static void main(String[] args) {
        HollowPattern hollowPattern = HollowPattern.builder().basis("invoke").hollow().build(0);
        hollowPattern.match(CODE);
    }

}
