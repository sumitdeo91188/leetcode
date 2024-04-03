package mod09.binarySearch.ex10;

import java.util.ArrayList;
import java.util.List;

public class SearchInASortedArrayOfUnknownSize {

    interface ArrayReader {
      public default int get(int index) {
          return index;
      }
  }
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;

        // search boundaries
        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int index = (left + right) / 2;
            if (target > reader.get(index)) {
                left = index + 1;
            } else if (target < reader.get(index)) {
                right = index - 1;
            } else {
                return index;
            }
        }

        return -1;
    }
}
