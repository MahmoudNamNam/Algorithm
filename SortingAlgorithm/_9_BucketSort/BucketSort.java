package Algorithm.SortingAlgorithm._9_BucketSort;

import java.util.*;

public class BucketSort {
    public static <T extends Comparable<T>> void bucketSort(T[] arr) {
        int n = arr.length;

        if (n <= 0) {
            return;
        }

        // Create n empty buckets
        List<List<T>> buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int idx = (int) (n * ((Double) arr[i]).doubleValue());
            buckets.get(idx).add(arr[i]);
        }

        // Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets.get(i));
        }

        // Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (T element : buckets.get(i)) {
                arr[index++] = element;
            }
        }
    }

    public static void main(String[] args) {
        Double[] arr = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};

        bucketSort(arr);

        System.out.println("Sorted array is ");
        for (double el : arr) {
            System.out.print(el + " ");
        }
    }
}
