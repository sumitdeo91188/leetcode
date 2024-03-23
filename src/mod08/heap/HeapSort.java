package mod08.heap;

public class HeapSort {
    public void sort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len / 2 - 1; i++) {
            heapify(arr, i, len);
        }

        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, i);
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        int maxIndex = index;

        if (leftIndex < heapSize && arr[leftIndex] > arr[maxIndex]) {
            maxIndex = leftIndex;
        }

        if (rightIndex < heapSize && arr[rightIndex] > arr[maxIndex]) {
            maxIndex = rightIndex;
        }

        if (maxIndex != index) {
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;
            heapify(arr, maxIndex, heapSize);
        }
    }
}
