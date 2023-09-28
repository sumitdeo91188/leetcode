package mod03.arraysAndString.ex04;

public class diagonalTraverse {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[] result = findDiagonalOrder(mat);

        for (int num : result) {
            System.out.println(num);
        }
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[]{0};
        }

        int m = mat.length;
        int n = mat[0].length;

        int[] result = new int[mat.length * mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                switch (i + j) {
                    case 0:

                }
            }
            
        }
        
        return result;
    }
}
