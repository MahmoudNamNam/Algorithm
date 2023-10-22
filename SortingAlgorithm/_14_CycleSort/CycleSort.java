package Algorithm.SortingAlgorithm._14_CycleSort;

class CycleSort {
    // Function to sort the array using Cycle Sort
    static void cycleSort(int arr[]) {
        int n = arr.length;

        // Traverse the array elements and put them in the right place
        for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
            // Initialize the item as the starting point
            int item = arr[cycle_start];

            // Find the position where we put the item.
            // Count all smaller elements on the right side of the item.
            int pos = cycle_start;
            for (int i = cycle_start + 1; i < n; i++) 
                if (arr[i] < item) 
                    pos++;
                
            

            // If the item is already in the correct position, continue
            if (pos == cycle_start)
                continue;

            // Ignore all duplicate elements
            while (item == arr[pos])
                pos++;

            // Put the item in its right position
            int temp = item;
            item = arr[pos];
            arr[pos] = temp;

            // Rotate the rest of the cycle
            while (pos != cycle_start) {
                pos = cycle_start;

                // Find the position where we put the element
                for (int i = cycle_start + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }

                // Ignore all duplicate elements
                while (item == arr[pos]) 
                    pos++;
                

                // Put the item in its right position
                temp = item;
                item = arr[pos];
                arr[pos] = temp;
            }
        }
    }

    // Driver method
    public static void main(String[] args) {
        int arr[] = { 1, 8, 3, 9, 10, 10, 2, 4 };
        int n = arr.length;
        cycleSort(arr);

        System.out.println("After sorting: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
