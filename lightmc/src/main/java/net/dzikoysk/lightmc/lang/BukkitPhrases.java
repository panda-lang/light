package net.dzikoysk.lightmc.lang;

import net.dzikoysk.lightmc.Light;
import net.dzikoysk.lightmc.lang.phrases.MessagePhrase;
import net.dzikoysk.lightmc.util.BukkitElements;

public class BukkitPhrases implements BukkitElements {

    private final Light light;

    public BukkitPhrases(Light light) {
        this.light = light;
    }

    @Override
    public void registerBukkitElements() {
        org.panda_lang.light.core.element.phrase.PhraseRepresentation messagePhraseRepresentation = new org.panda_lang.light.core.element.phrase.PhraseRepresentation(new MessagePhrase());
        messagePhraseRepresentation.pattern("send * to *");
        light.registerPhrase(messagePhraseRepresentation);
    }

}
