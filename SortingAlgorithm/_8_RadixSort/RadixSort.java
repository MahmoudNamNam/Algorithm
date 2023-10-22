package Algorithm.SortingAlgorithm._8_RadixSort;
import java.util.Arrays;

class RadixSort {
    public static int[] radixSort(int[] arr) {
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            arr = countSort(arr, n, exp);
        }

        return arr;
    }

    public static int[] countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;

        int[] sortedArray = radixSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }
}
