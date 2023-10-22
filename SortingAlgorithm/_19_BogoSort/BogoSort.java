package Algorithm.SortingAlgorithm._19_BogoSort;

public class BogoSort {
    // Sorts array a[0..n-1] using Bogo sort
    void bogoSort(int[] a) {
        // If the array is not sorted, shuffle it again
        while (!isSorted(a))
            shuffle(a);
    }

    // To generate a permutation of the array
    void shuffle(int[] a) {
        // Use Math.random() to generate a double value between 0 and 1
        for (int i = 1; i < a.length; i++)
            swap(a, i, (int) (Math.random() * i));
    }

    // Swapping 2 elements
    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // To check if the array is sorted or not
    boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i - 1])
                return false;
        return true;
    }

    // Prints the array
    void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // Enter the array to be sorted here
        int[] a = {3, 2, 5, 1, 0, 4};
        BogoSort ob = new BogoSort();

        ob.bogoSort(a);

        System.out.print("Sorted array: ");
        ob.printArray(a);
    }
}
