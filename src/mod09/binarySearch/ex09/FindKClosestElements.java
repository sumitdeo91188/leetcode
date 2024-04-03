package mod09.binarySearch.ex09;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> elements = new ArrayList<>();

        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for (int i = left; i < left + k; i++) {
            elements.add(arr[i]);
        }
        
        return elements;
    }
}
