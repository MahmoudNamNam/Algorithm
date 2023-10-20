package Algorithm.chapter_1.sec1_4;

import java.util.Random;

public class ThreeSum_2 {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int N = 2000; // Set the array size as desired

        int[] a = new int[N];
        Random random = new Random();

        // Generate random integers within a specified range (-1000000 to 1000000)
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(2000001) - 1000000;
        }

        long startTime = System.currentTimeMillis();
        int cnt = ThreeSum_2.count(a);
        long endTime = System.currentTimeMillis();
        double time = (endTime - startTime) / 1000.0; // Convert to seconds

        System.out.println(cnt + " triples " + time + " seconds");
    }
}
