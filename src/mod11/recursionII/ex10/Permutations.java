package mod11.recursionII.ex10;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    /**
     * Generates all possible permutations of the given array.
     *
     * @param nums The input array for which permutations are generated.
     * @return A list containing all possible permutations of the input array.
     */
    public List<List<Integer>> permute(int[] nums) {
        // List to store permutations
        List<List<Integer>> permutations = new ArrayList<>();
        // Helper method to generate permutations recursively
        backtrack(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    /**
     * Backtracking method to generate permutations recursively.
     *
     * @param nums              The input array.
     * @param currentPermutation The current permutation being constructed.
     * @param permutations      The list to store generated permutations.
     */
    private void backtrack(int[] nums, ArrayList<Integer> currentPermutation, List<List<Integer>> permutations) {
        // Base case: If the current permutation has the same size as the input array,
        // add it to the list of permutations
        if (currentPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutation));
        } else {
            // Iterate through each element in the input array
            for (int num : nums) {
                // Check if the current element is not already present in the current permutation
                if (!currentPermutation.contains(num)) {
                    // Add the current element to the current permutation
                    currentPermutation.add(num);
                    // Recursively generate permutations with the updated current permutation
                    backtrack(nums, currentPermutation, permutations);
                    // Backtrack by removing the last added element to explore other permutations
                    currentPermutation.remove(currentPermutation.size() - 1);
                }
            }
        }
    }
}

