package Algorithm.chapter_1.sec1_4;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a); // Sort the array in ascending order
        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int target = -a[i]; // Calculate the target value for each element
            if (binarySearch(a, target, i + 1)) {
                cnt++;
            }
        }

        return cnt;
    }

    public static boolean binarySearch(int[] a, int target, int start) {
        int left = start;
        int right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == target) {
                return true; // Found the target
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false; // Target not found
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

        int pairCount = count(a);
        System.out.println("Number of pairs that sum to zero: " + pairCount);
    }
}
