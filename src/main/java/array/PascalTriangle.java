package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        if (numRows < 1) return res;
        res.add(Arrays.asList(1));
        List<Integer> above;
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
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
        return res;
    }

    public static void main(String[] args) {
        PascalTriangle target = new PascalTriangle();
        List<List<Integer>> list = target.generate(5);
        list.forEach(t -> {
            System.out.println(t.size());
        });
    }
}
