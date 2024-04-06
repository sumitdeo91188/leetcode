package mod11.recursionII.ex15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    /**
     * Finds all unique subsets of the input array (including duplicates).
     *
     * @param nums The input array.
     * @return A list of all unique subsets of the input array.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // List to store subsets
        List<List<Integer>> subsets = new ArrayList<>();

        // Sort the input array to handle duplicates
        Arrays.sort(nums);

        // Start backtracking from the beginning of the array
        backtrack(nums, new ArrayList<>(), subsets, 0);

        return subsets;
    }

    /**
     * Backtracking method to find subsets recursively.
     *
     * @param nums          The input array.
     * @param currentSubset The current subset being constructed.
     * @param subsets       The list to store generated subsets.
     * @param startIndex    The index to start considering elements from.
     */
    private void backtrack(int[] nums, ArrayList<Integer> currentSubset, List<List<Integer>> subsets, int startIndex) {
        // Add the current subset to the list of subsets
        subsets.add(new ArrayList<>(currentSubset));

        // Iterate over elements starting from the specified startIndex
        for (int i = startIndex; i < nums.length; i++) {
            // Skip duplicates
            if (i > startIndex && nums[i] == nums[i - 1])
                continue;

            // Add the current element to the current subset
            currentSubset.add(nums[i]);

            // Recursively explore subsets with the updated current subset, starting from the next element
            backtrack(nums, currentSubset, subsets, i + 1);

            // Backtrack: Remove the last added element to explore other subsets
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}





