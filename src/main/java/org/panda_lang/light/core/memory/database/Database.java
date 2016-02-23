package org.panda_lang.light.core.memory.database;

import org.panda_lang.light.core.memory.database.util.DataSerializer;
import org.panda_lang.light.core.memory.database.util.DataUtils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Database {

    private final File file;
    private final ConcurrentHashMap<String, DatabaseRecord> records;
    private final ThreadPoolExecutor threadPoolExecutor;

    public Database(File file) {
        this.file = file;
        this.records = new ConcurrentHashMap<>();
        this.threadPoolExecutor = new ThreadPoolExecutor(1, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    public void load() {
        if (!file.exists()) {
            return;
        }

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            DataSerializer dataSerializer = new DataSerializer(dataInputStream);

            while (dataSerializer.available() > 0) {
                int length = dataSerializer.readInt();
                String recordName = dataSerializer.readUTF();

                int contentLength = length - recordName.getBytes().length;
                byte[] data = new byte[contentLength];
                dataSerializer.read(data);

                DatabaseRecord databaseRecord = new DatabaseRecord(recordName, data);
                records.put(databaseRecord.getRecordName(), databaseRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(final DatabaseRecord databaseRecord) {
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                records.put(databaseRecord.getRecordName(), databaseRecord);
                try {
                    save();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void save() throws Exception {
        if (!file.exists()) {
            file.createNewFile();
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            for (Map.Entry<String, DatabaseRecord> entry : records.entrySet()) {
                byte[] data = entry.getValue().getData();
                byte[] length = DataUtils.intToByteArray(data.length);

                fileOutputStream.write(length);
                fileOutputStream.write(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, DatabaseRecord> getRecords() {
        return records;
    }

}
