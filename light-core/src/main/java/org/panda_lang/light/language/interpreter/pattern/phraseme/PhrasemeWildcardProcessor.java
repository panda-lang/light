package org.panda_lang.light.language.interpreter.pattern.phraseme;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.light.language.interpreter.parser.phrase.Phraseme;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesCandidate;
import org.panda_lang.light.language.interpreter.parser.phrase.PhrasemesGroup;

public interface PhrasemeWildcardProcessor {

    Phraseme handle(PhrasemesGroup group, String wildcard, @Nullable PhrasemesCandidate previousCandidate);

}
