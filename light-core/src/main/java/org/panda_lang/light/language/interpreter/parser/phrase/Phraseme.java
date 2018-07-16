package org.panda_lang.light.language.interpreter.parser.phrase;

import org.panda_lang.panda.framework.design.architecture.dynamic.Executable;
import org.panda_lang.panda.framework.design.runtime.ExecutableBranch;
import org.panda_lang.panda.framework.language.interpreter.pattern.lexical.LexicalPattern;

public class Phraseme implements Executable {

    private final LexicalPattern pattern;
    private final PhrasemeCallback callback;

    public Phraseme(LexicalPattern pattern, PhrasemeCallback callback) {
        this.pattern = pattern;
        this.callback = callback;
    }

    @Override
    public void execute(ExecutableBranch branch) {
        callback.execute(branch);
    }

}
