package array;

public class MatrixRegionSum {

    private int[][] sums;

    public MatrixRegionSum(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        sums = new int[matrix.length][matrix[0].length + 1];
        //构建前缀和。 sum[i] 代表matrix 第i行的前缀和
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sums[i][j+1] = sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int r = row1; r <= row2; r++) {
            sum += sums[r][col2+1] - sums[r][col1];
        }
        return sum;
    }
}
