package array;

import adt.Helper;

/**
 *
 */
public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {
        int left = 0, right = 0, tmp = 0;;
        for (int[] row : A) {
            left = 0;
            right = row.length-1;

            while (left <= right) {
                tmp = row[right];
                row[right] = row[left]^1;
                row[left] = tmp^1;
                left++;
                right--;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(1^1);
        System.out.println(0^1);

        FlipAndInvertImage target = new FlipAndInvertImage();
        int[][] input = Helper.strTo2DArray("[[1,1,0],[1,0,1],[0,0,0]]");
        int[][] output = target.flipAndInvertImage(input);

        input = Helper.strTo2DArray("[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]");
        output = target.flipAndInvertImage(input);
    }
}
