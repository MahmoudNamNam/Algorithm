package Algorithm.SortingAlgorithm._12_CombSort;

import java.io.*;

public class CombSort {
    // To find the next gap between elements
    int getNextGap(int gap) {
        // Shrink the gap by a shrink factor
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }

    // Function to sort arr[] using Comb Sort
    void sort(int arr[]) {
        int n = arr.length;
        int gap = n; // Initialize gap
        boolean swapped = true; // Initialize swapped as true to ensure the loop runs

        // Keep running while the gap is more than 1 and the last iteration caused a
        // swap
        while (gap != 1 || swapped) {
            // Find the next gap
            gap = getNextGap(gap);
            swapped = false; // Initialize swapped as false to check if a swap happened

            // Compare all elements with the current gap
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    // Swap arr[i] and arr[i+gap]
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true; // Set swapped to true
                }
            }
        }
    }

    // Driver method
    public static void main(String args[]) {
        CombSort combSort = new CombSort();
        int arr[] = { 8, 4, 1, 56, 3, -44, 23, -6, 28, 0 };
        combSort.sort(arr);

        System.out.println("Sorted array:");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
