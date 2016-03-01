package org.panda_lang.light;

import org.panda_lang.panda.Panda;

import java.io.IOException;

public class BenchmarkTest {

    public static void main(String[] args) throws IOException {
        long initTime = System.nanoTime();

        for (int t = 0; t < 10000; t++) {
            System.out.println("Hello Java");

            if (true) {
                String x = "Variable Test";
                x.length();
                System.out.println(x);

                x = null;
                System.out.println(x);
            }

            for (int i = 0; i < 1; i++) {
                pandaInfo();
            }

            int i = 0;
            while (i < 1) {
                System.out.println(5 > 10);
                i = 1;
            }
        }

        benchmark(initTime, 10000);
    }

    public static void pandaInfo() {
        System.out.println("Hello Panda");
        System.out.println(Panda.PANDA_VERSION);
    }

    public static void benchmark(long initTime, int times) {
        long nsTime = System.nanoTime() - initTime;
        double msTime = nsTime / 1000000.0;
        double secTime = msTime / 1000.0;

        long averageTime = nsTime / times;
        double averageMsTime = averageTime / 1000000.0;
        double averageSecTime = averageMsTime / 1000.0;

        System.out.println("Benchmark:");
        System.out.println("    Full: " + nsTime + "ns -> " + msTime + "ms -> " + secTime + " seconds");
        System.out.println("    Average: " + averageTime + "ns -> " + averageMsTime + "ms -> " + averageSecTime + " seconds");
    }

}
