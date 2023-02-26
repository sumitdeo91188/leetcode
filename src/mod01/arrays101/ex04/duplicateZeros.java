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

    public static void duplicateZeros(int[] arr) {
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
    }
}
