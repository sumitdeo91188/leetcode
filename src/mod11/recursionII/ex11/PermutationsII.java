package mod11.recursionII.ex11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    /**
     * Generates all permutations of the input array.
     *
     * @param nums The input array.
     * @return A list containing all permutations of the input array.
     */
    public List<List<Integer>> permute(int[] nums) {
        // Sort the input array
        Arrays.sort(nums);

        // List to store permutations
        List<List<Integer>> permutations = new ArrayList<>();

        // Helper method to generate permutations recursively
        backtrack(nums, new ArrayList<>(), permutations, new boolean[nums.length]);
        return permutations;
    }

    /**
     * Backtracking method to generate permutations recursively.
     *
     * @param nums               The input array.
     * @param currentPermutation The current permutation being constructed.
     * @param permutations       The list to store generated permutations.
     * @param used               An array to keep track of whether an element has been used in the current permutation.
     */
    private void backtrack(int[] nums, ArrayList<Integer> currentPermutation, List<List<Integer>> permutations, boolean[] used) {
        // Base case: If the current permutation has the same size as the input array,
        // add it to the list of permutations
        if (currentPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutation));
        } else {
            // Iterate through each element in the input array
            for (int i = 0; i < nums.length; i++) {
                // Check if the current element is not already present in the current permutation
                if (!used[i] && !(i > 0 && nums[i] == nums[i - 1] && used[i - 1])) {
                    // Add the current element to the current permutation
                    used[i] = true;
                    currentPermutation.add(nums[i]);
                    // Recursively generate permutations with the updated current permutation
                    backtrack(nums, currentPermutation, permutations, used);
                    // Backtrack by removing the last added element to explore other permutations
                    used[i] = false;
                    currentPermutation.remove(currentPermutation.size() - 1);
                }
            }
        }
    }
}


