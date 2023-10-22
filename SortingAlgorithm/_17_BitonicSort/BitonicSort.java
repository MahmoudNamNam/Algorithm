package Algorithm.SortingAlgorithm._17_BitonicSort;
public class BitonicSort {
    // Compare and swap elements based on the sorting direction
    void compareAndSwap(int[] arr, int i, int j, int dir) {
        if ((arr[i] > arr[j] && dir == 1) || (arr[i] < arr[j] && dir == 0)) {
            // Swap elements if the condition is met
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Merge a bitonic sequence
    void bitonicMerge(int[] arr, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                // Compare and swap elements in the bitonic sequence
                compareAndSwap(arr, i, i + k, dir);
            }
            // Recursively merge the two halves
            bitonicMerge(arr, low, k, dir);
            bitonicMerge(arr, low + k, k, dir);
        }
    }

    // Recursively sort a bitonic sequence
    void bitonicSort(int[] arr, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            // Sort the first half in ascending order
            bitonicSort(arr, low, k, 1);
            // Sort the second half in descending order
            bitonicSort(arr, low + k, k, 0);
            // Merge the entire sequence in the desired direction
            bitonicMerge(arr, low, cnt, dir);
        }
    }

    // Main sorting method
    void sort(int[] arr, int up) {
        bitonicSort(arr, 0, arr.length, up);
    }

    // Helper function to print the sorted array
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {3, 7, 4, 8, 6, 2, 1, 5};
        int up = 1; // 1 for ascending, 0 for descending
        BitonicSort ob = new BitonicSort();
        ob.sort(arr, up);
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
