package mod01.arrays101.ex04;

public class duplicateZeros {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        for (int num : arr) {
            System.out.print(num + "\t");
        }

        System.out.println();

        arr = new int[]{1, 2, 3};
        duplicateZeros(arr);
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }

    /*public static void duplicateZeros(int[] arr) {
        int numOfZeros = 0;
        for(int num : arr) {
            if (num == 0) {
                numOfZeros++;
            }
        }

        int[] tempArr = new int[arr.length + numOfZeros];
        int tempArrIndex = 0;

        for (int num : arr) {
            tempArr[tempArrIndex++] = num;
            if (num == 0) {
                tempArr[tempArrIndex++] = num;
            }
        }

        System.arraycopy(tempArr, 0, arr, 0, arr.length);
    }*/

    // O(1) space complexity
    // 1, 0, 2, 3, 0, 4, 5, 0
    // 1, 0, 0, 2, 3, 0, 0, 4, 5, 0
    public static void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}
