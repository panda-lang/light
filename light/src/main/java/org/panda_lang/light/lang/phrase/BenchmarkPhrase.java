package org.panda_lang.light.lang.phrase;

public class BenchmarkPhrase implements org.panda_lang.light.core.element.phrase.Phrase {

    private long initTime = System.nanoTime();
    private int times = 1;

    @Override
    public void run(org.panda_lang.light.core.Ray ray) {
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

                System.out.println("Light Benchmark:");
                System.out.println("    Full: " + nsTime + "ns -> " + msTime + "ms -> " + secTime + " seconds");
                System.out.println("    Average: " + averageTime + "ns -> " + averageMsTime + "ms -> " + averageSecTime + " seconds");
                break;
        }
    }

}
