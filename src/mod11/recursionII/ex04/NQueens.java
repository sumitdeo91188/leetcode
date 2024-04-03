package mod11.recursionII.ex04;

import java.util.HashSet;
import java.util.Set;

public class NQueens {
    Set<Integer> cols;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    int count;
    int n;

    public int totalNQueens(int n) {
        this.n = n;
        count = 0;
        cols = new HashSet<>();
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();

        backtrack(0);

        return count;
    }

    private void backtrack(int row) {
        if (row == n)
            count++;

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || posDiag.contains(row + col) || negDiag.contains(row - col))
                continue;

            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);

            backtrack(row + 1);

            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
        }
    }
}
