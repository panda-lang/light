package org.panda_lang.light.language.interpreter.parser.phrase;

import org.panda_lang.light.design.interpreter.parser.phrase.PhrasemePattern;
import org.panda_lang.panda.framework.design.architecture.dynamic.Executable;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;

public class Phraseme implements Executable {

    private final PhrasemePattern pattern;
    private final PhrasemeCallback callback;

    public Phraseme(PhrasemePattern pattern, PhrasemeCallback callback) {
        this.pattern = pattern;
        this.callback = callback;
    }

    @Override
    public void execute(ExecutableBranch branch) {
        callback.execute(branch);
    }

    public PhrasemePattern getPattern() {
        return pattern;
    }

}
