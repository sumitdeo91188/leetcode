package mod01.arrays101.ex02;

public class numsWithEvenNumOfDigits {
    public static void main(String[] args) {
        int[] nums = new int[]{12,345,2,6,7896};
        System.out.println(findNumbers(nums));

        nums = new int[] {555,901,482,1771};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int numsWithEvenNumOfDigits = 0;

        for (int num : nums) {
            int numOfDigits = 0;
            while (num > 0) {
                numOfDigits++;
                num = num / 10;
            }
            if (numOfDigits % 2 == 0) {
                numsWithEvenNumOfDigits++;
            }
        }

        /*for (int num : nums) {
            String numStr = String.valueOf(num);
            if (numStr.length() % 2 == 0) {
                numsWithEvenNumOfDigits++;
            }
        }*/

        return numsWithEvenNumOfDigits;
    }
}
