package org.panda_lang.light.core.memory.database;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private final Map<String, DatabaseRecord> records;

    public Database() {
        this.records = new HashMap<>();
    }

    public void update(DatabaseRecord databaseRecord) {

    }

    public void save() {

    }

    public Map<String, DatabaseRecord> getRecords() {
        return records;
    }

}
