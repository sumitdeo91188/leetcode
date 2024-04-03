package mod11.recursionII.ex03;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        quickSort(new int[] {1,5,3,2,8,7,6,4});
    }

    public static void quickSort(int [] lst) {
        /* Sorts an array in the ascending order in O(n log n) time */
        int n = lst.length;
        qSort(lst, 0, n - 1);
    }

    private static void qSort(int[] lst, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex)
            return;

        int pivot = lst[(leftIndex + rightIndex) / 2];
        int index = partition(lst, leftIndex, rightIndex, pivot);
        qSort(lst, leftIndex, index - 1);
        qSort(lst, index, rightIndex);
    }

    private static int partition(int[] lst, int leftIndex, int rightIndex, int pivot) {
        while (leftIndex <= rightIndex) {
            while (lst[leftIndex] < pivot) {
                leftIndex++;
            }

            while (lst[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(lst, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] lst, int leftIndex, int rightIndex) {
        int temp = lst[leftIndex];
        lst[leftIndex] = lst[rightIndex];
        lst[rightIndex] = temp;
    }
}
