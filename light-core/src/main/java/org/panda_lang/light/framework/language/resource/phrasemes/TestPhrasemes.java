package org.panda_lang.light.framework.language.resource.phrasemes;

import org.panda_lang.light.LightConstants;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.registry.PhrasemeRepresentation;

public class TestPhrasemes {

    @PhrasemeRepresentation("light version")
    public String lightVersion() {
        return LightConstants.VERSION;
    }

    @PhrasemeRepresentation("string of <object>")
    public String stringOf(Object obj) {
        return obj.toString();
    }

    @PhrasemeRepresentation("joined <string> and <string>")
    public String join(String a, String b) {
        return a + b;
    }

}
