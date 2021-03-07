package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a circular array (the next element of the last element is the first element of the array)
 * , print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 *
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */
public class NextGreaterNumber2 {

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n*2-1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i %n]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterNumber2 target = new NextGreaterNumber2();
        int[] nums = {1,2,1};
        int[] res = target.nextGreaterElements(nums);
        System.out.println(Arrays.equals(res, new int[]{2,-1,2}));
    }
}
