package net.dzikoysk.moonlight.lang;

import net.dzikoysk.moonlight.Moonlight;
import net.dzikoysk.moonlight.lang.phrases.MessagePhrase;
import net.dzikoysk.moonlight.util.BukkitElements;
import org.panda_lang.moonlight.core.element.phrase.PhraseRepresentation;

public class BukkitPhrases implements BukkitElements {

    private final Moonlight moonlight;

    public BukkitPhrases(Moonlight moonlight) {
        this.moonlight = moonlight;
    }

    @Override
    public void registerBukkitElements() {
        PhraseRepresentation messagePhraseRepresentation = new PhraseRepresentation(new MessagePhrase());
        messagePhraseRepresentation.pattern("send * to *");
        moonlight.registerPhrase(messagePhraseRepresentation);
    }

}
