package net.dzikoysk.light.lang.structure;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.panda_lang.light.LightCore;
import org.panda_lang.light.core.Expression;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.Structure;
import org.panda_lang.light.core.memory.database.util.DataSerializer;
import org.panda_lang.light.core.parser.assistant.ExpressionRepresentation;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.lang.StringEssence;

import java.io.IOException;
import java.util.UUID;

public class PlayerStructure extends Structure<Player> {

    @Override
    public void initialize(LightCore lightCore) {
        hookClass(Player.class);

        // todo: minify
        ExpressionRepresentation expressionRepresentation = new ExpressionRepresentation(new Expression() {
            @Override
            public Essence getValue(Ray ray) {
                Player player = ray.getExpressionValue(0);
                return new StringEssence(player.getName());
            }
        });
        expressionRepresentation.pattern("* name");
        addExpressionRepresentation(expressionRepresentation);
    }

    @Override
    public void serialize(DataSerializer dataSerializer, Player object) throws IOException {
        dataSerializer.writeUTF(object.getUniqueId().toString());
    }

    @Override
    public Player deserialize(DataSerializer dataSerializer) throws IOException {
        UUID uuid = UUID.fromString(dataSerializer.readUTF());
        return Bukkit.getPlayer(uuid);
    }

}
