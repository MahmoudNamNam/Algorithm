package Algorithm.SortingAlgorithm._13_PigeonholeSort;

import java.util.Arrays;

public class PigeonholeSort {

    public static void pigeonholeSort(int arr[]) {
        int min = arr[0];
        int max = arr[0];

        for (int a = 0; a < arr.length; a++) {
            if (arr[a] > max) {
                max = arr[a];
            }
            if (arr[a] < min) {
                min = arr[a];
            }
        }

        int range = max - min + 1;
        int[] pigeonholes = new int[range];
        Arrays.fill(pigeonholes, 0);

        for (int i = 0; i < arr.length; i++) {
            pigeonholes[arr[i] - min]++;
        }

        int index = 0;

        for (int j = 0; j < range; j++) {
            while (pigeonholes[j]-- > 0) {
                arr[index++] = j + min;
            }
        }
    }

    public static void main(String[] args) {
        PigeonholeSort sort = new PigeonholeSort();
        int[] arr = {8, 3, 2, 7, 4, 6, 8};

        System.out.print("Sorted order is: ");
        sort.pigeonholeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
