package mod07.recursionI.ex10;

public class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {
        return dfs(n, k, 0);
    }

    private int dfs(int n, int k, int rootVal) {
        if (n == 1) return rootVal;

        int numOfNodes = (int) Math.pow(2, n - 1);

        if (k > numOfNodes / 2) {
            int nextRootVal = rootVal == 0 ? 1 : 0;
            return dfs(n -1, k - numOfNodes / 2, nextRootVal);
        } else {
            int nextRootVal = rootVal == 0 ? 0 : 1;
            return dfs(n -1, k, nextRootVal);
        }
    }
}
