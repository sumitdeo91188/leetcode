package mod11.recursionII.ex06;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    int totalElements; // Represents the total number of elements (n)
    int combinationSize; // Represents the size of combinations to generate (k)
    List<List<Integer>> combinations; // List to store generated combinations

    // Method to generate combinations
    public List<List<Integer>> generateCombinations(int totalElements, int combinationSize) {
        this.totalElements = totalElements;
        this.combinationSize = combinationSize;
        combinations = new ArrayList<>();
        backtrack(1, new ArrayList<>());
        return combinations;
    }

    // Backtracking method to generate combinations
    private void backtrack(int startElement, ArrayList<Integer> currentCombination) {
        // If the current combination has reached the desired size, add it to the list of combinations
        if (currentCombination.size() == combinationSize) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        // Iterate through elements starting from the specified startElement
        for (int i = startElement; i <= totalElements; i++) {
            // Add the current element to the combination
            currentCombination.add(i);
            // Recursively call backtrack to generate combinations with the next element
            backtrack(i + 1, currentCombination);
            // Remove the last added element to backtrack and explore other combinations
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}

