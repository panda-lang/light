package org.panda_lang.moonlight.core.memory;

import org.panda_lang.moonlight.MoonlightCore;

public class Variables {

    private final MoonlightCore moonlightCore;
    private final Followed followed;

    public Variables(MoonlightCore moonlightCore) {
        this.moonlightCore = moonlightCore;
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

    public MoonlightCore getMoonlightCore() {
        return moonlightCore;
    }

}
