package org.panda_lang.light;

import org.panda_lang.light.core.parser.pattern.LightPattern;

public class HollowsTest {

    private static final String CODE = "invoke \"ray\"";

    public static void main(String[] args) {
        LightPattern lightPattern = LightPattern.builder().basis("invoke").hollow().build(0);
        lightPattern.match(CODE);
    }

}
