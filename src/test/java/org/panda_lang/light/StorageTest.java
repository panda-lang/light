package org.panda_lang.light;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StorageTest {

    public static void main(String[] args) throws IOException {

        for (int x = 0; x < 100; x++) {
            long l = System.currentTimeMillis();

            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < 100_000; i++) {
                map.put(Integer.toString(i), Integer.toString(i));
            }

            File file = new File("database.db");
            FileWriter fileWriter = new FileWriter(file);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                fileWriter.write(entry.getKey() + System.lineSeparator());
                fileWriter.write(entry.getValue().getClass().getName() + System.lineSeparator());
                fileWriter.write(entry.getValue() + System.lineSeparator());
            }
            fileWriter.flush();
            fileWriter.close();

            System.out.println(System.currentTimeMillis() - l);
        }

    }

}
