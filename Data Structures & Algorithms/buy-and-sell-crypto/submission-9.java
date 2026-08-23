class Solution {
    public int maxProfit(int[] prices) {
        /**
            dp  max(sell, dp(n - 1))
            0-buy
            1-sell     
            dp(n)(0) = max(-prices[n], dp(n - 1)(1));
            dp(n)(1) = max(dp(n - 1)(1), dp(n- 1)(0) + prices[n]);
            dp(0)(0) = -prices[0]
        */
        int n = prices.length;
        int[][]dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < n; i++){
            // buy
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // sell
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[n - 1][1];
    }
}
