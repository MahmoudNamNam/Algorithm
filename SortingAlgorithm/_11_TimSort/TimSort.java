package Algorithm.SortingAlgorithm._11_TimSort;

import java.util.*;

public class TimSort {
    static final int MIN_MERGE = 32;

    // Calculate the minimum run length for timsort
    private static int calculateMinRunLength(int n) {
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    // Sort a subarray using the Insertion Sort algorithm
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Merge two sorted subarrays into a single sorted subarray
    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArray = Arrays.copyOfRange(arr, left, left + len1);
        int[] rightArray = Arrays.copyOfRange(arr, mid + 1, mid + 1 + len2);
        int i = 0, j = 0, k = left;

        while (i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < len2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Perform Timsort on the given array
    public static void timsort(int[] arr) {
        int n = arr.length;
        int minRun = calculateMinRunLength(n);

        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min(i + MIN_MERGE - 1, n - 1));
        }

        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {-2, 7, 15, -14, 0, 15, 0, 7, -7, -4, -13, 5, 8, -14, 12};
        System.out.println("Given Array:");
        printArray(arr);

        timsort(arr);

        System.out.println("After Sorting:");
        printArray(arr);
    }
}
