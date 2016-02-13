package org.panda_lang.light;

import org.panda_lang.light.core.parser.essential.pattern.LightPattern;

import java.util.Collection;

public class HollowsTest {

    public static void main(String[] args) {
        LightPattern lightPattern = LightPattern.builder().compile("invoke *").build(0);
        lightPattern.match("invoke \"ray\"");

        Collection<String> hollows = lightPattern.getHollows();
        System.out.print(hollows);
    }

}
