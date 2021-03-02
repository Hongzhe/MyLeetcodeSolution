package array;

import java.util.HashSet;
import java.util.Set;

/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n.
 * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set
 * , which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */
public class SetMismatch {
    //1 2 2 3 4
    public int[] findErrorNums(int[] nums) {
        int[] visited = new int[nums.length];
        int sum = 0;
        int[] res = new int[2];
        for (int n : nums) {
            if (visited[n-1] > 0) {
                res[0] = n;
            }
            visited[n-1]++;
            sum += n;
        }
        int expected = nums.length * (1 + nums.length) /2;
        res[1] = expected - sum + res[0];
        return res;
    }

    public int[] findErrorNums2(int[] nums) {
        int[] visited = new int[nums.length];
        for (int n : nums) {
            visited[n-1]++;
        }
        int[] res = new int[2];
        int flag = 0;
        for (int i = 0; i < nums.length && flag != 2; i++) {
            if (visited[i]>1) {
                res[0] = i+1;
                flag++;
            }
            if (visited[i] == 0) {
                res[1] = i+1;
                flag++;
            }
        }
        return res;
    }
}
