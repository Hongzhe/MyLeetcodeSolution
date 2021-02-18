package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
 *
 * Notice that the row index starts from 0.
 * Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * Constraints:
 *
 * 0 <= rowIndex <= 33
 */
public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>(rowIndex+1);
        //if (numRows < 1) return res;
        res.add(Arrays.asList(1));
        List<Integer> above, row = null;
        for (int i = 1; i < rowIndex+1; i++) {
            row = new ArrayList<>();
            row.add(1);
            above = res.get(i-1);
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    row.add(1);
                    break;
                }
                row.add(above.get(j) + above.get(j-1));
            }
            res.add(row);
        }
        return row;
    }

    public static void main(String[] args) {
        PascalTriangle2 target = new PascalTriangle2();
        List<Integer> list = target.getRow(3);
        list.forEach(System.out::println);
    }
}
