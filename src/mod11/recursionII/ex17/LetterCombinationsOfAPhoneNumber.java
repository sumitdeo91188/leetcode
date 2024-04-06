package mod11.recursionII.ex17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    // Map to store the mapping of digits to their corresponding letters
    private final Map<Character, String> digitToLettersMap = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    /**
     * Generates all possible letter combinations corresponding to the given digits.
     *
     * @param digits The input string containing digits.
     * @return A list of all possible letter combinations.
     */
    public List<String> letterCombinations(String digits) {
        // If the input string is empty, return an empty list
        if (digits.isEmpty())
            return new ArrayList<>();

        // List to store generated combinations
        List<String> combinations = new ArrayList<>();

        // Convert the input string to a character array
        char[] digitChars = digits.toCharArray();

        // Start backtracking from the first digit
        backtrack(digitChars, new StringBuilder(), combinations, 0);

        return combinations;
    }

    /**
     * Backtracking method to generate letter combinations recursively.
     *
     * @param digitChars   The character array containing digits.
     * @param sb           The StringBuilder to build the current combination.
     * @param combinations The list to store generated combinations.
     * @param currentIndex The index to start considering digits from.
     */
    private void backtrack(char[] digitChars, StringBuilder currentCombination, List<String> combinations, int currentIndex) {
        // Base case: If the length of the current combination equals the number of digits,
        // add it to the list of combinations
        if (currentCombination.length() == digitChars.length) {
            combinations.add(currentCombination.toString());
            return;
        }

        // Get the possible letters corresponding to the current digit
        String possibleLetters = digitToLettersMap.get(digitChars[currentIndex]);

        // Iterate over each possible letter and recursively explore combinations
        for (char letter : possibleLetters.toCharArray()) {
            // Append the current letter to the current combination
            currentCombination.append(letter);
            // Recursively explore combinations with the updated combination, starting from the next digit
            backtrack(digitChars, currentCombination, combinations, currentIndex + 1);
            // Backtrack: Remove the last added letter to explore other combinations
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}





