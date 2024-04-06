package mod11.recursionII.ex13;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {

    /**
     * Finds all combinations of candidates that sum up to the target.
     *
     * @param candidates The array of candidate numbers.
     * @param target     The target sum.
     * @return A list of combinations of candidate numbers that sum up to the target.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // List to store combinations
        List<List<Integer>> combinations = new ArrayList<>();
        // Start backtracking from the beginning of the candidates array
        backtrack(candidates, target, new ArrayList<>(), combinations, 0);
        return combinations;
    }

    /**
     * Backtracking method to find combinations recursively.
     *
     * @param candidates         The array of candidate numbers.
     * @param target             The remaining target to achieve.
     * @param currentCombination The current combination being constructed.
     * @param combinations       The list to store generated combinations.
     * @param startIndex         The index to start considering candidates from.
     */
    private void backtrack(int[] candidates, int target, ArrayList<Integer> currentCombination, List<List<Integer>> combinations, int startIndex) {
        // Base case: If the target sum is achieved, add the current combination to the list of combinations
        if (target == 0) {
            combinations.add(new ArrayList<>(currentCombination));
        } else if (target > 0) { // Proceed only if the target sum is positive
            // Iterate over candidates starting from the specified startIndex
            for (int i = startIndex; i < candidates.length; i++) {
                // Skip Dups
                if (i > startIndex && candidates[i] == candidates[i - 1])
                    continue;
                // Add the current candidate to the current combination
                currentCombination.add(candidates[i]);
                // Recursively explore combinations with the updated target and combination, starting from the current candidate
                backtrack(candidates, target - candidates[i], currentCombination, combinations, i + 1);
                // Backtrack: Remove the last added candidate to explore other combinations
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}



