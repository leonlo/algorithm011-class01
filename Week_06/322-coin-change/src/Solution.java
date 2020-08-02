import java.util.Arrays;

public class Solution {
    /**
     * DP Solution. bottom -> top
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int cnt = new Solution().coinChange(new int[] { 1, 2, 5 }, 11);
        System.out.println(cnt);
    }
}
