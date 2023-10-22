package Algorithm.SortingAlgorithm._21_SleepSort;

import java.util.concurrent.CountDownLatch;

public class SleepSort {

    public static void main(String[] args) {
        int[] arr = {34, 23, 122, 9};
        sleepSort(arr);
    }

    public static void sleepSort(final int[] arr) {
        final CountDownLatch doneSignal = new CountDownLatch(arr.length);

        for (final int num : arr) {
            new Thread(new Runnable() {
                public void run() {
                    doneSignal.countDown();
                    try {
                        doneSignal.await();
                        Thread.sleep(num);
                        System.out.print(num + " ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
