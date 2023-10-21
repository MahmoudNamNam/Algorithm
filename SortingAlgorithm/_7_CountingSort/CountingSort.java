package Algorithm.SortingAlgorithm._7_CountingSort;

import java.util.*;


public class CountingSort {

    public static int[] countSort(int[] inputArray) {
        // Finding the maximum element in inputArray
        int max = Arrays.stream(inputArray).max().getAsInt();

        // Initializing countArray with 0
        int[] countArray = new int[max + 1];

        // Mapping each element of inputArray as an index of countArray
        for (int num : inputArray) {
            countArray[num]++;
        }

        // Calculating prefix sum at every index of countArray
        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Creating outputArray from countArray
        int[] outputArray = new int[inputArray.length];

        for (int i = inputArray.length - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }

        return outputArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] inputArray =new int[n];
        for (int i=0; i<n; i++)
            inputArray[i]= scanner.nextInt();
        int[] outputArray = countSort(inputArray);

        System.out.println("Sorted Array:");
        for (int num : outputArray) {
            System.out.print(num + " ");
        }
    }
}
