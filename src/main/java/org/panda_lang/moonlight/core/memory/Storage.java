package org.panda_lang.moonlight.core.memory;

import org.panda_lang.moonlight.core.element.type.Type;
import org.panda_lang.moonlight.core.element.type.TypeCenter;
import org.panda_lang.moonlight.core.element.type.TypeRepresentation;
import org.panda_lang.moonlight.core.memory.database.Database;
import org.panda_lang.moonlight.core.memory.database.DatabaseRecord;
import org.panda_lang.moonlight.core.memory.database.util.DataSerializer;
import org.panda_lang.panda.core.memory.Global;
import org.panda_lang.panda.core.Essence;

import java.io.*;


public class Storage {

    private final Followed followed;
    private final TypeCenter typeCenter;
    private Database database;

    public Storage(Followed followed) {
        this.followed = followed;
        this.typeCenter = followed.getLightCore().getTypeCenter();
    }

    public void initializeDatabase(File file) {
        this.database = new Database(file);
    }

    public void load() {
        database.load();

        for (DatabaseRecord databaseRecord : database.getRecords().values()) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(databaseRecord.getData());
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                DataSerializer dataSerializer = new DataSerializer(dataInputStream);

                String typeClassName = dataSerializer.readUTF();
                Class typeClass = Class.forName(typeClassName);
                TypeRepresentation typeRepresentation = typeCenter.get(typeClass);

                if (typeRepresentation != null) {
                    Type<Essence> type = typeRepresentation.getType();
                    Essence essence = type.deserialize(dataSerializer);
                    Global.COMMON_MEMORY.put(databaseRecord.getRecordName(), essence);
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(String variableName, Essence value) throws IOException {
        TypeRepresentation typeRepresentation = typeCenter.get(value.getClass());

        if (typeRepresentation != null) {
            Type<Essence> type = typeRepresentation.getType();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            DataSerializer dataSerializer = new DataSerializer(dataOutputStream);

            try {
                dataSerializer.writeUTF(variableName);
                dataSerializer.writeUTF(value.getClass().getName());
                type.serialize(dataSerializer, value);

                DatabaseRecord databaseRecord = new DatabaseRecord(variableName, byteArrayOutputStream.toByteArray());
                database.update(databaseRecord);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                dataOutputStream.close();
            }
            return;
        }

        System.out.println("Cannot save variable " + value);
    }

    public void save() {
        try {
            database.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Database getDatabase() {
        return database;
    }

    public Followed getFollowed() {
        return followed;
    }

}
