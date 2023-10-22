package Algorithm.SortingAlgorithm._22_SoogeSort;

public class StoogeSort {
    // Function to implement Stooge Sort
    static void stoogeSort(int arr[], int l, int h) {
        if (l >= h)
            return;

        // If the first element is greater than the last, swap them
        if (arr[l] > arr[h]) {
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
        }

        // If there are more than 2 elements in the array
        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;

            // Recursively sort the first 2/3 elements
            stoogeSort(arr, l, h - t);

            // Recursively sort the last 2/3 elements
            stoogeSort(arr, l + t, h);

            // Recursively sort the first 2/3 elements again to confirm
            stoogeSort(arr, l, h - t);
        }
    }

    // Driver Code
    public static void main(String args[]) {
        int arr[] = {2, 4, 5, 3, 1};
        int n = arr.length;

        stoogeSort(arr, 0, n - 1);

        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
