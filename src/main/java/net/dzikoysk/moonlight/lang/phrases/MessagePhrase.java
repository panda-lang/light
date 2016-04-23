package net.dzikoysk.moonlight.lang.phrases;

import org.bukkit.entity.Player;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.phrase.Phrase;

public class MessagePhrase implements Phrase {

    @Override
    public void run(Ray ray) {
        Object message = ray.getExpressionValue(0);
        Player player = ray.getExpressionValue(1);
        player.sendMessage(message.toString());
    }

}
