package Algorithm.SortingAlgorithm._15_CocktailSort;

public class CocktailSort {
    void cocktailSort(int a[]) {
        boolean swapped = true;
        int start = 0;
        int end = a.length;

        while (swapped) {
            // Reset the swapped flag on entering the loop
            swapped = false;

            // Loop from bottom to top, same as the bubble sort
            for (int i = start; i < end - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }

            // If nothing moved, then the array is sorted.
            if (!swapped)
                break;

            // Otherwise, reset the swapped flag for the next stage
            swapped = false;

            // Move the end point back by one
            end = end - 1;

            // From top to bottom, do the same comparison as in the previous stage
            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }

            // Increase the starting point
            start = start + 1;
        }
    }

    // Prints the array
    void printArray(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        CocktailSort ob = new CocktailSort();
        int a[] = {5, 1, 4, 2, 8, 0, 2};
        ob.cocktailSort(a);
        System.out.println("Sorted array:");
        ob.printArray(a);
    }
}
