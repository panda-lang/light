package org.panda_lang.moonlight.core.memory.database;

public class DatabaseRecord {

    private final String recordName;
    private final byte[] data;

    public DatabaseRecord(String recordName, byte[] data) {
        this.recordName = recordName;
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public String getRecordName() {
        return recordName;
    }

}
