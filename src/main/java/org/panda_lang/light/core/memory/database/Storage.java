package org.panda_lang.light.core.memory.database;

import org.panda_lang.light.core.Type;
import org.panda_lang.light.core.memory.Followed;
import org.panda_lang.light.core.memory.Variable;
import org.panda_lang.light.core.parser.assistant.TypeRepresentation;
import org.panda_lang.panda.core.syntax.Essence;

public class Storage {

    private final Followed followed;
    private final Database database;

    public Storage(Followed followed) {
        this.followed = followed;
        this.database = new Database();
    }

    public void load() {

    }

    public void update(Variable variable) {
        Essence value = variable.getValue();
        TypeRepresentation typeRepresentation = followed.getPandaCore().getTypeCenter().getTypes().get(value.getClass());

        if (typeRepresentation != null) {
            Type type = typeRepresentation.getRepresentation();

            // <todo>

            save();
        }

        System.out.println("Cannot save variable " + value);
    }

    public void save() {

    }

    public Database getDatabase() {
        return database;
    }

    public Followed getFollowed() {
        return followed;
    }

}
