package org.panda_lang.moonlight.lang.phrase;

import org.panda_lang.moonlight.core.Ray;
import org.panda_lang.moonlight.core.element.phrase.Phrase;

public class BenchmarkPhrase implements Phrase {

    private long initTime = System.nanoTime();
    private int times = 1;

    @Override
    public void run(Ray ray) {
        switch (ray.getPattern().getIndex()) {
            case 0:
                times = 1;
                initTime = System.nanoTime();
                break;
            case 1:
                ++times;
                break;
            case 2:
                long nsTime = System.nanoTime() - initTime;
                double msTime = nsTime / 1000000.0;
                double secTime = msTime / 1000.0;

                long averageTime = nsTime / times;
                double averageMsTime = averageTime / 1000000.0;
                double averageSecTime = averageMsTime / 1000.0;

                System.out.println("Moonlight Benchmark:");
                System.out.println("    Full: " + nsTime + "ns -> " + msTime + "ms -> " + secTime + " seconds");
                System.out.println("    Average: " + averageTime + "ns -> " + averageMsTime + "ms -> " + averageSecTime + " seconds");
                break;
        }
    }

}
