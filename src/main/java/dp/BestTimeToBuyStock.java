package dp;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choose a different day
 * to sell that stock.
 * Return the maximum profit you can achieve from the transaction. If you can't achieve any profit, return 0.
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class BestTimeToBuyStock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }

        return profit;
    }
}
