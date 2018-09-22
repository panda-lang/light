package org.panda_lang.light.framework.language.resource.phrasemes;

import org.panda_lang.light.LightConstants;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader.annotations.Id;
import org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader.annotations.PhrasemeRepresentation;

public class TestPhrasemes {

    @PhrasemeRepresentation("send message:<string> to [the] console")
    public void sendMessageToConsole(@Id("message") String message) {
        System.out.println(message);
    }

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
