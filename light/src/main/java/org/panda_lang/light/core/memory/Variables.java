package org.panda_lang.light.core.memory;

import org.panda_lang.light.LightCore;

public class Variables {

    private final LightCore lightCore;
    private final Followed followed;

    public Variables(LightCore lightCore) {
        this.lightCore = lightCore;
        this.followed = new Followed(this);
    }

    public void load() {
        followed.getStorage().load();
    }

    public void save() {
        followed.getStorage().save();
    }

    public Followed getFollowed() {
        return followed;
    }

    public LightCore getLightCore() {
        return lightCore;
    }

}
