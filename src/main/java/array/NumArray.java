package array;

import adt.Helper;

public class NumArray {

    private int[] accum;

    public NumArray(int[] nums) {
        accum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            accum[i+1] = accum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return accum[j+1] - accum[i];
    }

    public static void main(String[] args) {
        NumArray target = new NumArray(Helper.strToArray("[-2, 0, 3, -5, 2, -1]"));
        System.out.println(target.sumRange(0,2));
        System.out.println(target.sumRange(2,5));
    }
}
