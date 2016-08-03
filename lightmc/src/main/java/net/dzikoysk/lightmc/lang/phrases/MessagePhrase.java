package net.dzikoysk.lightmc.lang.phrases;

import org.bukkit.entity.Player;

public class MessagePhrase implements org.panda_lang.light.core.element.phrase.Phrase {

    @Override
    public void run(org.panda_lang.light.core.Ray ray) {
        Object message = ray.getExpressionValue(0);
        Player player = ray.getExpressionValue(1);
        player.sendMessage(message.toString());
    }

}
