/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 */
public class Solution {
    /**
     * Greedy algorithm solution
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                int diff =  prices[i] - prices[i - 1];
                max += diff;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] prices = new int[] { 7,1,5,3,6,4 };
        int res = new Solution().maxProfit(prices);
        System.out.println(res);
    }

}
