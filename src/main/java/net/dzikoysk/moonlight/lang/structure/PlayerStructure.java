package net.dzikoysk.moonlight.lang.structure;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.panda_lang.moonlight.MoonlightCore;
import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.Structure;
import org.panda_lang.moonlight.core.element.expression.Expression;
import org.panda_lang.moonlight.core.element.expression.ExpressionRepresentation;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.lang.StringEssence;

import java.io.IOException;
import java.util.UUID;

public class PlayerStructure extends Structure<Player> {

    @Override
    public void initialize(MoonlightCore moonlightCore) {
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
