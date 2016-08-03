package org.panda_lang.light.core.memory;

import org.panda_lang.panda.core.Inst;
import org.panda_lang.panda.core.memory.Global;

import java.io.*;


public class Storage {

    private final Followed followed;
    private final org.panda_lang.light.core.element.type.TypeCenter typeCenter;
    private org.panda_lang.light.core.memory.database.Database database;

    public Storage(Followed followed) {
        this.followed = followed;
        this.typeCenter = followed.getLightCore().getTypeCenter();
    }

    public void initializeDatabase(File file) {
        this.database = new org.panda_lang.light.core.memory.database.Database(file);
    }

    public void load() {
        database.load();

        for (org.panda_lang.light.core.memory.database.DatabaseRecord databaseRecord : database.getRecords().values()) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(databaseRecord.getData());
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer = new org.panda_lang.light.core.memory.database.util.DataSerializer(dataInputStream);

                String typeClassName = dataSerializer.readUTF();
                Class typeClass = Class.forName(typeClassName);
                org.panda_lang.light.core.element.type.TypeRepresentation typeRepresentation = typeCenter.get(typeClass);

                if (typeRepresentation != null) {
                    org.panda_lang.light.core.element.type.Type<Inst> type = typeRepresentation.getType();
                    Inst inst = type.deserialize(dataSerializer);
                    Global.COMMON_MEMORY.put(databaseRecord.getRecordName(), inst);
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(String variableName, Inst value) throws IOException {
        org.panda_lang.light.core.element.type.TypeRepresentation typeRepresentation = typeCenter.get(value.getClass());

        if (typeRepresentation != null) {
            org.panda_lang.light.core.element.type.Type<Inst> type = typeRepresentation.getType();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            org.panda_lang.light.core.memory.database.util.DataSerializer dataSerializer = new org.panda_lang.light.core.memory.database.util.DataSerializer(dataOutputStream);

            try {
                dataSerializer.writeUTF(variableName);
                dataSerializer.writeUTF(value.getClass().getName());
                type.serialize(dataSerializer, value);

                org.panda_lang.light.core.memory.database.DatabaseRecord databaseRecord = new org.panda_lang.light.core.memory.database.DatabaseRecord(variableName, byteArrayOutputStream.toByteArray());
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

    public org.panda_lang.light.core.memory.database.Database getDatabase() {
        return database;
    }

    public Followed getFollowed() {
        return followed;
    }

}
