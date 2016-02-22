package org.panda_lang.light.core.memory;

import org.panda_lang.light.LightCore;

public class Variables {

    private final LightCore lightCore;
    private final Followed followed;
    private final Globalized globalized;

    public Variables(LightCore lightCore) {
        this.lightCore = lightCore;
        this.followed = new Followed(this);
        this.globalized = new Globalized(this);
    }

    public void load() {
        followed.getStorage().load();
    }

    public void save() {
        followed.getStorage().save();
    }

    public Globalized getGlobalized() {
        return globalized;
    }

    public Followed getFollowed() {
        return followed;
    }

    public LightCore getLightCore() {
        return lightCore;
    }

}
