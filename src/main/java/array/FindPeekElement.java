package array;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given an integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 *
 * amazing solution.
 *
 */
public class FindPeekElement {

    /**
     * 线性扫描
     * 如果数组是升序，最后一个元素是peak。nums[i] < nums[i+1]
     * 如果数组是降序，第一个元素是peak nums[i] > nums[i+1]
     * 如果peak出现在中间，当遍历上坡时，遇到nums[i] > nums[i+1] 达到峰值。 因为达到i时间，
     *  i-1 i-2 肯定是上坡
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length -1 ; i++) {
            if (nums[i] > nums[i+1]) {
                return i;
            }
        }
        return nums.length-1;
    }

    //
    public int findPeekElement2(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] > nums[mid+1]) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
}
