package array;

import adt.Helper;

import java.util.Arrays;
import java.util.Stack;

/**
 Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 then the whole array will be sorted in ascending order.

 Return the shortest such subarray and output its length.

 Example 1:

 Input: nums = [2,6,4,8,10,9,15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Example 2:

 Input: nums = [1,2,3,4]
 Output: 0
 Example 3:

 Input: nums = [1]
 Output: 0


 Constraints:

 1 <= nums.length <= 104
 -105 <= nums[i] <= 105
 */
public class ShortestUnsortSubArray {

    //compare with sorted array and find out boundary of unsorted sub array
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int left = nums.length, right = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        return right - left > 0 ? right - left + 1 : 0;
    }


    public int findUnsortedSubarray2(int[] nums) {
        int left = nums.length, right = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()]  < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return right - left > 0 ? right - left + 1 : 0;
    }

    public static void main(String[] args) {
        ShortestUnsortSubArray target = new ShortestUnsortSubArray();
        int[] arr = Helper.strToArray("[2,6,4,8,10,9,15]");
        System.out.println(target.findUnsortedSubarray2(arr) == 5);
    }
}
