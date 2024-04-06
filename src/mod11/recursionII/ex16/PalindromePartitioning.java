package mod11.recursionII.ex16;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /**
     * Finds all possible partitions of a string where each partition consists of palindromes.
     *
     * @param s The input string.
     * @return A list of all possible partitions of the input string.
     */
    public List<List<String>> partition(String s) {
        // List to store partitions
        List<List<String>> partitions = new ArrayList<>();

        // Start backtracking from the beginning of the string
        backtrack(s, new ArrayList<String>(), partitions, 0);

        return partitions;
    }

    /**
     * Backtracking method to find partitions recursively.
     *
     * @param s                The input string.
     * @param currentPartition The current partition being constructed.
     * @param partitions       The list to store generated partitions.
     * @param startIndex       The index to start considering characters from.
     */
    private void backtrack(String s, ArrayList<String> currentPartition, List<List<String>> partitions, int startIndex) {
        // Base case: If the current partition covers the entire string, add it to the list of partitions
        if (startIndex == s.length()) {
            partitions.add(new ArrayList<>(currentPartition));
        }

        // Iterate over characters starting from the specified startIndex
        for (int i = startIndex; i < s.length(); i++) {
            // Check if the substring from startIndex to i is a palindrome
            if (isPalindrome(s, startIndex, i)) {
                // Add the palindrome substring to the current partition
                currentPartition.add(s.substring(startIndex, i + 1));
                // Recursively explore partitions with the updated current partition, starting from the next character
                backtrack(s, currentPartition, partitions, i + 1);
                // Backtrack: Remove the last added substring to explore other partitions
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    /**
     * Checks if the substring of a string from low to high index is a palindrome.
     *
     * @param s    The input string.
     * @param low  The starting index of the substring.
     * @param high The ending index of the substring.
     * @return True if the substring is a palindrome, otherwise false.
     */
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}





