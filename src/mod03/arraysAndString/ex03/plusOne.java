package mod03.arraysAndString.ex03;

public class plusOne {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 8, 9, 9};
        int[] result = plusOne(nums);

        for (int num : result) {
            System.out.println(num);
        }
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int i = len - 1; i > -1; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
