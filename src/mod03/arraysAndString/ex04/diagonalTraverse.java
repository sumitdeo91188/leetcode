package mod03.arraysAndString.ex04;

public class diagonalTraverse {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = findDiagonalOrder(mat);

        for (int num : result) {
            System.out.println(num);
        }
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];


        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        int[] result = new int[total];

        int k = 0;
        int i = 0;
        int j = 0;
        boolean up = true;
        while (k < total) {
            result[k] = matrix[i][j];


            if (up) {
                if (i == 0 && j < col - 1) {
                    j++;
                    up = false;
                } else if (j == col - 1) {
                    i++;
                    up = false;
                } else {
                    i--;
                    j++;
                }
            } else { //down
                if (i < row - 1 && j == 0) {
                    i++;
                    up = true;
                } else if (i == row - 1) {
                    j++;
                    up = true;
                } else {
                    i++;
                    j--;
                }
            }

            k++;
        }
        return result;
    }
}
