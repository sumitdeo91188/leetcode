package mod01.arrays101.ex16;

import java.util.TreeSet;

public class thirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,1};
        int[] nums2 = new int[]{3,2};
        int[] nums3 = new int[]{3,2,1,1};

        System.out.println(thirdMax(nums1));
        System.out.println(thirdMax(nums2));
        System.out.println(thirdMax(nums3));
    }

    public static int thirdMax(int[] nums) {
        /*long FIRST_MAX = Long.MIN_VALUE;
        long SECOND_MAX = Long.MIN_VALUE;
        long THIRD_MAX = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == FIRST_MAX || num == SECOND_MAX || num == THIRD_MAX) {
                continue;
            }

            if (num > FIRST_MAX) {
                THIRD_MAX = SECOND_MAX;
                SECOND_MAX = FIRST_MAX;
                FIRST_MAX = num;
            } else if (num > SECOND_MAX) {
                THIRD_MAX = SECOND_MAX;
                SECOND_MAX = num;
            } else if (num > THIRD_MAX) {
                THIRD_MAX = num;
            }
        }

        return (int) (THIRD_MAX == Long.MIN_VALUE ? FIRST_MAX : THIRD_MAX);*/

        TreeSet<Integer> max3 = new TreeSet<>();

        for (int num : nums) {
            if (max3.contains(num)) {
                continue;
            }

            if (max3.size() == 3) {
                if (num > max3.first()) {
                    max3.pollFirst();
                    max3.add(num);
                }
            } else {
                max3.add(num);
            }
        }

        return max3.size() == 3 ? max3.first() : max3.last();
    }
}
