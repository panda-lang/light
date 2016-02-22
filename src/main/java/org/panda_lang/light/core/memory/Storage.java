package org.panda_lang.light.core.memory;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.panda_lang.light.core.Type;
import org.panda_lang.light.core.memory.database.Database;
import org.panda_lang.light.core.memory.database.DatabaseRecord;
import org.panda_lang.light.core.memory.database.util.DataSerializer;
import org.panda_lang.light.core.parser.assistant.TypeRepresentation;
import org.panda_lang.panda.core.syntax.Essence;

import java.io.DataOutputStream;
import java.io.IOException;

public class Storage {

    private final Followed followed;
    private final Database database;

    public Storage(Followed followed) {
        this.followed = followed;
        this.database = new Database();
    }

    public void load() {

    }

    public void update(Variable variable) throws IOException {
        Essence value = variable.getValue();
        TypeRepresentation typeRepresentation = followed.getPandaCore().getTypeCenter().getTypes().get(value.getClass());

        if (typeRepresentation != null) {
            Type<Essence> type = typeRepresentation.getRepresentation();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            DataSerializer dataSerializer = new DataSerializer(dataOutputStream);

            try {
                type.serialize(dataSerializer, value);

                DatabaseRecord databaseRecord = new DatabaseRecord(variable.getVariableName(), byteArrayOutputStream.toByteArray());
                database.update(databaseRecord);
                save();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                dataOutputStream.close();
                byteArrayOutputStream.close();
            }
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
