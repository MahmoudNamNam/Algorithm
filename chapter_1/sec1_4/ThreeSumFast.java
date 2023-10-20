package Algorithm.chapter_1.sec1_4;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int target = -a[i] - a[j];
                int index = binarySearch(a, target);
                if (index > j) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // Binary search implementation
    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
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
