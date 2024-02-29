package mod08.heap.ex01;

public class ReverseString {
    public void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }

    private void helper(int leftIndex, int rightIndex, char[] chars) {
        if (leftIndex >= rightIndex) return;
        char temp = chars[leftIndex];
        chars[leftIndex] = chars[rightIndex];
        chars[rightIndex] = temp;
        helper(leftIndex + 1, rightIndex - 1, chars);
    }
}
