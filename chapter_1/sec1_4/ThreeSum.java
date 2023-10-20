package Algorithm.chapter_1.sec1_4;

import java.util.Scanner;

public class ThreeSum {
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int N = scanner.nextInt();

        int[] a = new int[N];

        System.out.println("Enter the elements:");

        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        int tripleCount = count(a);
        System.out.println("Number of triples that sum to zero: " + tripleCount);
    }
}
