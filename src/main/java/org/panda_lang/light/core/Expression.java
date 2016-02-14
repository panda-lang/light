package org.panda_lang.light.core;

import org.panda_lang.panda.core.syntax.Essence;

public class Expression extends Essence {

    public void setValue(Ray ray) {
    }

    public Essence getValue(Ray ray) {
        return run(ray);
    }

}
