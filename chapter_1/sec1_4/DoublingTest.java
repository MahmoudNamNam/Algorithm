package Algorithm.chapter_1.sec1_4;

import java.util.Random;

public class DoublingTest {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        Random random = new Random();

        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(2 * MAX) - MAX;
        }

        long startTime = System.currentTimeMillis();
        int cnt = ThreeSum.count(a);
        long endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000.0; // Convert milliseconds to seconds
    }

    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            System.out.printf("%7d %5.1f\n", N, time);
        }
    }
}
