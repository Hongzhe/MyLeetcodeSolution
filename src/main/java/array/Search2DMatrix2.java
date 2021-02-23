package array;

/**
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix.
 * The matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matix[i][j] <= 109
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -109 <= target <= 109
 */
public class Search2DMatrix2 {

    //search start at top right corner
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length-1;
        while (row < matrix.length && col >=0 ) {
            int v = matrix[row][col];
            if (v == target) return true;
            if (v > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
